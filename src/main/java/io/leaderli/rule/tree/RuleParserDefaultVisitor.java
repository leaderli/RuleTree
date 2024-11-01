/* Generated By:JavaCC: Do not edit this line. RuleParserDefaultVisitor.java Version 7.0.13 */
package io.leaderli.rule.tree;

public class RuleParserDefaultVisitor implements RuleParserVisitor {
    public void defaultVisit(SimpleNode node, io.leaderli.rule.RuleContext data) {
        node.childrenAccept(this, data);
        return;
    }

    public void visit(SimpleNode node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_Start node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_rule node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_and node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_or node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_term node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_neg node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_num_int node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_num_double node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_num_percent node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_num_time node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_compare node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_math node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_operator node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_var node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }

    public void visit(ast_test node, io.leaderli.rule.RuleContext data) {
        defaultVisit(node, data);
    }
}
/* JavaCC - OriginalChecksum=7b09de8d888048991750db720b620ca5 (do not edit this line) */
