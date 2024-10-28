package io.leaderli.rule.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    @Test
    void test() throws ParseException {

        Assertions.assertDoesNotThrow(() -> test_num("0"));
        Assertions.assertDoesNotThrow(() -> test_num("0.0"));
        Assertions.assertDoesNotThrow(() -> test_num("0.0%"));
        Assertions.assertDoesNotThrow(() -> test_num("1"));
        Assertions.assertDoesNotThrow(() -> test_num("1.0"));
        Assertions.assertDoesNotThrow(() -> test_num("1.0%"));
        Assertions.assertDoesNotThrow(() -> test_num("0%"));
        Assertions.assertThrows(ParseException.class,() -> test_num("00"));
        Assertions.assertThrows(ParseException.class,() -> test_num("01"));
    }

    void test_num(String num) throws ParseException {
        RuleParser ruleParser = new RuleParser(new StringReader(num));
        ruleParser.test_num();
    }

}
