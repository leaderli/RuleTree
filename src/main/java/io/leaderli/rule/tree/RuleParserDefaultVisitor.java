/* Generated By:JavaCC: Do not edit this line. RuleParserDefaultVisitor.java Version 7.0.13 */
package io.leaderli.rule.tree;

public class RuleParserDefaultVisitor implements RuleParserVisitor {
    public Object defaultVisit(SimpleNode node, Object data) {
        node.childrenAccept(this, data);
        return data;
    }

    public Object visit(SimpleNode node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_entry node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_rule node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_expr node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_and node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_or node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_term node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_num_int node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_num_double node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_num_percent node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_num_time node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_compare node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_math node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_operator node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_var node, Object data) {
        return defaultVisit(node, data);
    }

    public Object visit(ast_test node, Object data) {
        return defaultVisit(node, data);
    }
}
/* JavaCC - OriginalChecksum=c195f8ec2c144f27a7ed068e5b5fa258 (do not edit this line) */
