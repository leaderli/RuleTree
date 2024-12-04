package io.leaderli.rule;

import io.leaderli.rule.tree.RuleParser;
import io.leaderli.rule.tree.ast_entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuleJsonGenerator {

    public static List<Map<String, Object>> parse(int ruleNo, String ruleContent, ParserContext parserContext) throws Exception {
        RuleParser ruleParser = new RuleParser(ruleContent, parserContext);
        ast_entry entry = (ast_entry) ruleParser.entry();
        List<Map<String, Object>> rules = new ArrayList<>();
        entry.jjtAccept(new RuleJsonParserVisitor(), rules);
        return rules;
    }
}
