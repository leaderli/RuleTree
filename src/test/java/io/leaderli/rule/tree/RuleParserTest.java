package io.leaderli.rule.tree;

import io.leaderli.litool.core.exception.AssertException;
import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.NodeUtil;
import io.leaderli.rule.ParserContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RuleParserTest {
    @Test
    void test() throws ParseException {

        Assertions.assertEquals(LiTuple.of("INT", 0), test("0").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("INT", -1), test("-1").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("DOUBLE", 0.0), test("0.0").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("DOUBLE", -0.1), test("-0.1").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("PERCENT", 0.0), test("0.0%").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("PERCENT", 0.01), test("1%").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("PERCENT", -0.01), test("-1%").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("INT", 1), test("1").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("DOUBLE", 1.0), test("1.0").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("DOUBLE", 1.0), test("1.0").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("PERCENT", 0.01), test("1.0%").jjtGetValue());
        Assertions.assertEquals(LiTuple.of("PERCENT", 0.0), test("0%").jjtGetValue());
        Assertions.assertThrows(ParseException.class, () -> test("00"));
        Assertions.assertThrows(ParseException.class, () -> test("01"));
    }

    public static SimpleNode<?> test(String expr) throws ParseException {
        RuleParser demo = new RuleParser(expr, new ParserContext());
        return (SimpleNode<?>) demo.test().jjtGetChild(0);
    }

    @Test
    void testTime() throws ParseException {
        Assertions.assertEquals(LiTuple.of("TIME", "20:20:20"), test("20:20:20").jjtGetValue());
        Assertions.assertThrows(Throwable.class, () -> test("35:20:20"));
        Assertions.assertThrows(Throwable.class, () -> test(""));

        // RuleParser ruleParser = new RuleParser(new StringReader("a 1"));
        //
        // System.out.println(test2().toString());
        // ruleParser = new RuleParser(new StringReader("b 20:20:20"));
        // System.out.println(test2().toString());

    }

    @Test
    void testVar() throws ParseException {

        ParserContext context = new ParserContext();
        context.putType("a", "INT");
        context.putType("b", "TIME");
        context.putType("c", "STR");
        context.putType("d", "PERCENT");
        Assertions.assertThrows(ParseException.class, () -> NodeUtil.dump(test("b+1>1", context)));
        Assertions.assertThrows(AssertException.class, () -> NodeUtil.dump(test("a>1.0", context)));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NodeUtil.dump(test("z>1", context)));
        test("a=1", context);
        test("a=-1", context);
        test("c=1", context);
        test("d=1%", context);
        test("a+a=1", context);
        test("a-a=1", context);
        test("b=10:10:10", context);
        test("b>10:10:10", context);
        test("b>10:10:10", context);
        Assertions.assertThrows(ParseException.class, () -> NodeUtil.dump(test("b-10:10:10>10:10:10", context)));
        Assertions.assertThrows(ParseException.class, () -> NodeUtil.dump(test("b-10:10:10>10:10:10", context)));
        Assertions.assertThrows(AssertException.class, () -> NodeUtil.dump(test("c>1", context)));
        Assertions.assertThrows(AssertException.class, () -> NodeUtil.dump(test("d>1", context)));

    }

    public static SimpleNode<?> test(String expr, ParserContext context) throws ParseException {
        RuleParser demo = new RuleParser(expr, context);
        return (SimpleNode<?>) demo.test().jjtGetChild(0);
    }

    @Test
    void testCompare2() throws ParseException {
        ParserContext context = new ParserContext();
        context.putType("a", "INT");
        context.putType("b", "TIME");
        SimpleNode node = test("a=1", context);
        NodeUtil.dump(node);
        node = test("a=1", context);
        NodeUtil.dump(node);

    }

    @Test
    void testExpr() throws ParseException {
        NodeUtil.dump(expr("true"));
        NodeUtil.dump(expr("false"));
        NodeUtil.dump(expr("true and false"));
        NodeUtil.dump(expr("false or true"));
        NodeUtil.dump(expr("false or false or true and true "));
        NodeUtil.dump(expr("not false or true"));
        NodeUtil.dump(expr("not (false or true)"));

    }

    public static SimpleNode<?> expr(String expr) throws ParseException {
        RuleParser demo = new RuleParser(expr, new ParserContext());
        return (SimpleNode<?>) demo.test();
    }

    @Test
    void testStart() throws ParseException {
        ParserContext context = new ParserContext();
        context.addRule(1, 2);
        RuleParser ruleParser = new RuleParser("rule:1 true and not (false or true)", context);
        NodeUtil.dump(ruleParser.entry());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            new RuleParser("rule:3 true", context).entry();
        });
    }
}
