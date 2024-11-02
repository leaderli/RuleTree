package io.leaderli.rule;

import io.leaderli.litool.core.collection.LiMapUtil;
import io.leaderli.rule.tree.ParseException;
import io.leaderli.rule.tree.RuleParser;
import io.leaderli.rule.tree.ast_entry;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class RuleContextVisitorTest {

    @Test
    void test() throws ParseException {
        ParserContext context = new ParserContext();
        context.putType("a", "INT");
        context.putType("b", "INT");
        context.addRule(1, 2, 3);
        RuleParser ruleParser = new RuleParser(
                "rule:1 true and not (false or a > 5) and a + b > 1 rule:2 true and not (false or true) and a = 1 rule:3 true",
                context);
        ast_entry entry = (ast_entry) ruleParser.entry();
        EntryFunction entryFunction = (EntryFunction) entry.jjtAccept(new RuleContextVisitor(), EntryFunction.class);
        RuleContext ruleContext = new RuleContext();
        HashMap<String, Object> vars = LiMapUtil.newHashMap("a", 1);
        vars.put("b", 1);
        ruleContext.initVars(vars);
        ruleContext.debug = true;
        System.out.println(entryFunction.apply(ruleContext));
        vars.put("a", 10);
        ruleContext.initVars(vars);
        System.out.println(entryFunction.apply(ruleContext));

    }
}
