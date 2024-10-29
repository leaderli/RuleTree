package io.leaderli.rule.tree;

import io.leaderli.rule.NodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RuleParserTest {

    @Test
    void test() throws ParseException {

        Assertions.assertEquals(0.0, RuleParser.test("0").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0.0").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0.0%").jjtGetValue());
        Assertions.assertEquals(0.01, RuleParser.test("1%").jjtGetValue());
        Assertions.assertEquals(1.0, RuleParser.test("1").jjtGetValue());
        Assertions.assertEquals(1.0, RuleParser.test("1.0").jjtGetValue());
        Assertions.assertEquals(1.0, RuleParser.test("1.0").jjtGetValue());
        Assertions.assertEquals(0.01, RuleParser.test("1.0%").jjtGetValue());
        Assertions.assertEquals(0.0, RuleParser.test("0%").jjtGetValue());
        Assertions.assertThrows(ParseException.class, () -> RuleParser.test("00"));
        Assertions.assertThrows(ParseException.class, () -> RuleParser.test("01"));
    }

    @Test
    void testStr() throws ParseException {
        // RuleParser ruleParser = new RuleParser(new StringReader("a 1"));
        //
        // System.out.println(ruleParser.test2().toString());
        // ruleParser = new RuleParser(new StringReader("b 20:20:20"));
        // System.out.println(ruleParser.test2().toString());

    }

    @Test
    void testVar() throws ParseException {

        NodeUtil.dump(RuleParser.test("str a;"));
        NodeUtil.dump(RuleParser.test("int a;"));

    }

    @Test
    void testCompare2() throws ParseException {
        NodeUtil.dump(RuleParser.test("a==1"));

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
