/* Generated By:JavaCC: Do not edit this line. RuleParserVisitor.java Version 7.0.13 */
package io.leaderli.rule.tree;

public interface RuleParserVisitor {
    public void visit(SimpleNode node, io.leaderli.rule.RuleContext data);

    public void visit(ASTStart node, io.leaderli.rule.RuleContext data);

    public void visit(ASTrule node, io.leaderli.rule.RuleContext data);

    public void visit(ASTand node, io.leaderli.rule.RuleContext data);

    public void visit(ASTor node, io.leaderli.rule.RuleContext data);

    public void visit(ASTterm node, io.leaderli.rule.RuleContext data);

    public void visit(ASTneg node, io.leaderli.rule.RuleContext data);

    public void visit(ASTnum node, io.leaderli.rule.RuleContext data);

    public void visit(ASTcompare node, io.leaderli.rule.RuleContext data);

    public void visit(ASTmath node, io.leaderli.rule.RuleContext data);

    public void visit(ASToperator node, io.leaderli.rule.RuleContext data);

    public void visit(ASTvar node, io.leaderli.rule.RuleContext data);

    public void visit(ASTtest node, io.leaderli.rule.RuleContext data);
}
/* JavaCC - OriginalChecksum=46fdc5309d4a0fd8b93cd4b49baa4ffe (do not edit this line) */
