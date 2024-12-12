package io.leaderli.rule.json;

import io.leaderli.rule.ParserContext;
import io.leaderli.rule.tree.RuleParser;
import io.leaderli.rule.tree.ast_entry;

import java.util.List;

@SuppressWarnings("unchecked")
public class RuleJsonGenerator {

    public static List<RuleBean> parse(int ruleNo, String ruleContent, ParserContext parserContext) throws Exception {
        RuleParser ruleParser = new RuleParser(ruleContent, parserContext);
        ast_entry entry = (ast_entry) ruleParser.entry();
        return (List<RuleBean>) entry.jjtAccept(new RuleJsonParserVisitor(), null);
    }
}
