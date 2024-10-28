package io.leaderli.rule.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

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

}
