/* Generated By:JavaCC: Do not edit this line. RuleParserVisitor.java Version 7.0.13 */
package io.leaderli.rule.tree;

public interface RuleParserVisitor {
    public Object visit(SimpleNode node, Object data);

    public Object visit(ast_entry node, Object data);

    public Object visit(ast_rule node, Object data);

    public Object visit(ast_expr node, Object data);

    public Object visit(ast_and node, Object data);

    public Object visit(ast_or node, Object data);

    public Object visit(ast_term node, Object data);

    public Object visit(ast_num_int node, Object data);

    public Object visit(ast_num_double node, Object data);

    public Object visit(ast_num_percent node, Object data);

    public Object visit(ast_num_time node, Object data);

    public Object visit(ast_compare node, Object data);

    public Object visit(ast_math node, Object data);

    public Object visit(ast_operator node, Object data);

    public Object visit(ast_var node, Object data);

    public Object visit(ast_test node, Object data);
}
/* JavaCC - OriginalChecksum=b576851f5d49f6ef6114f9d42f727226 (do not edit this line) */
