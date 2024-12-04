package io.leaderli.rule;

import io.leaderli.rule.tree.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RuleJsonParserVisitor implements RuleParserVisitor {
    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_entry node, Object data) {
        List<Map<String, Object>> rules = (List<Map<String, Object>>) data;

        HashMap<String, Object> rule = new HashMap<>();
        rules.add(rule);
        
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            node.jjtGetChild(i).jjtAccept(this, rule);
        }

        return null;
    }

    @Override
    public Object visit(ast_rule node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_expr node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_and node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_or node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_term node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_int node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_double node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_percent node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_time node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_compare node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_math node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_operator node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_var node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_test node, Object data) {
        return null;
    }
}
