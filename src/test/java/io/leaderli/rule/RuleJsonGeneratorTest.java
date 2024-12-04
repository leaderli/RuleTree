package io.leaderli.rule;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class RuleJsonGeneratorTest {

    @Test
    void test() throws Exception {

        ParserContext parserContext = new ParserContext();
//        parserContext.isDebug = true;
        parserContext.putType("a", "INT");
        parserContext.putType("b", "INT");
        parserContext.putType("c", "TIME");
        parserContext.putType("d", "TIME");
        parserContext.addRule(1, 2, -1);

        List<Map<String, Object>> rules = RuleJsonGenerator.parse(1,
                "rule:1 true and not (false or a > 5) and a + b > 1 rule:2 true and not (false or true) and a = 1 or c = 10:10:10 rule:-1 true",
                parserContext);

        for (Map<String, Object> rule : rules) {
            System.out.println(rule);
        }

    }

}
