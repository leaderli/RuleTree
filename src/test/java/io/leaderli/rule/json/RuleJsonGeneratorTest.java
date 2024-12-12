package io.leaderli.rule.json;

import com.google.gson.GsonBuilder;
import io.leaderli.litool.json.GsonUtil;
import io.leaderli.rule.ParserContext;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        List<RuleBean> rules = RuleJsonGenerator.parse(1,
                "rule:1 true and not (false or a > 5) and a + b > 1 rule:2 true and not (false or true) and a = 1 or c = 10:10:10 rule:-1 true",
                parserContext);


        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(rules));

        for (RuleBean rule : rules) {
            System.out.println(rule.rule+" "+rule.step);

            for (UnitBean unitBean : rule.expr) {
                System.out.print(unitBean.value+" ");
            }
            System.out.println();
        }

    }

}
