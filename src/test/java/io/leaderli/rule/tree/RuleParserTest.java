package io.leaderli.rule.tree;

import io.leaderli.rule.NodeUtil;
import io.leaderli.rule.RuleContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

class RuleParserTest {

    @Test
    void test() throws ParseException {

        Assertions.assertEquals(0, RuleParser.test("0").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0.0").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0.0%").jjtGetValue());
        Assertions.assertEquals(0.01, RuleParser.test("1%").jjtGetValue());
        Assertions.assertEquals(1, RuleParser.test("1").jjtGetValue());
        Assertions.assertEquals(1.0, RuleParser.test("1.0").jjtGetValue());
        Assertions.assertEquals(1.0, RuleParser.test("1.0").jjtGetValue());
        Assertions.assertEquals(0.01, RuleParser.test("1.0%").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0%").jjtGetValue());
        Assertions.assertThrows(ParseException.class, () -> RuleParser.test("00"));
        Assertions.assertThrows(ParseException.class, () -> RuleParser.test("01"));
    }

    @Test
    void testTime() throws ParseException {
        Assertions.assertEquals("20:20:20", RuleParser.test("20:20:20").jjtGetValue());
        Assertions.assertThrows(Throwable.class, () -> RuleParser.test("35:20:20"));
        Assertions.assertThrows(Throwable.class, () -> RuleParser.test(""));

        // RuleParser ruleParser = new RuleParser(new StringReader("a 1"));
        //
        // System.out.println(ruleParser.test2().toString());
        // ruleParser = new RuleParser(new StringReader("b 20:20:20"));
        // System.out.println(ruleParser.test2().toString());

    }

    @Test
    void testVar() throws ParseException {

        RuleContext context = new RuleContext();
        context.putType("a", "INT");
        context.putType("b", "TIME");
        NodeUtil.dump(RuleParser.test("a", context));
        NodeUtil.dump(RuleParser.test("b", context));
        Assertions.assertThrows(IllegalStateException.class, () -> NodeUtil.dump(RuleParser.test("c", context)));
        Assertions.assertThrows(ParseException.class, () -> NodeUtil.dump(RuleParser.test("b+1", context)));
        Assertions.assertThrows(ParseException.class, () -> NodeUtil.dump(RuleParser.test("a+1.0", context)));
        NodeUtil.dump(RuleParser.test("a+1", context));
        NodeUtil.dump(RuleParser.test("a-1", context));

    }

    @Test
    void testCompare2() throws ParseException {
        RuleContext context = new RuleContext();
        context.putType("a", "INT");
        context.putType("b", "TIME");
        SimpleNode node = RuleParser.test("a=1", context);
        NodeUtil.dump(node);
        node = RuleParser.test("a=[1,2]", context);
        NodeUtil.dump(node);

    }

    @Test
    void testExpr() throws ParseException {
        NodeUtil.dump(RuleParser.test("true"));
        NodeUtil.dump(RuleParser.test("false"));
        NodeUtil.dump(RuleParser.test("true and false"));
        NodeUtil.dump(RuleParser.test("false or true"));
        NodeUtil.dump(RuleParser.test("not false or true"));
        NodeUtil.dump(RuleParser.test("not (false or true)"));

    }
}
