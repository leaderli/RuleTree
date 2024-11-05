package io.leaderli.rule;

import io.leaderli.litool.core.collection.LiMapUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class RuleContextVisitorTest {

    @Test
    void test() throws Exception {
        ParserContext parserContext = new ParserContext();
        parserContext.isDebug = true;
        parserContext.putType("a", "INT");
        parserContext.putType("b", "INT");
        parserContext.putType("c", "TIME");
        parserContext.addRule(1, 2, -1);

        RuleExecutor ruleExecutor = RuleClassGenerator.parse(1,
                "rule:1 true and not (false or a > 5) and a + b > 1 rule:2 true and not (false or true) and a = 1 or c = 10:10:10 rule:-1 true",
                parserContext);

        HashMap<String, Object> vars = LiMapUtil.newHashMap("a", 1);
        vars.put("b", 1);
        vars.put("c", "1");
        // ruleContext.initVars(vars);
        // ruleContext.debug = true;
        // System.out.println(entryFunction.apply(ruleContext));
        vars.put("a", 10);
        RuleContext ruleContext = new RuleContext();
        ruleContext.isDebug =true;
        ruleContext.initVars(vars);
        System.out.println("------------------");
        System.out.println(ruleExecutor.apply(ruleContext));


        // System.out.println(entryFunction.apply(ruleContext));



    }
}
