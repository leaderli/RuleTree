/* Generated By:JJTree: Do not edit this line. ASTor.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ASTor extends SimpleNode {
    public ASTor(int id) {
        super(id);
    }

    public ASTor(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, io.leaderli.rule.RuleContext data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=f9f0193291646a0ab818a0f67e6f064b (do not edit this line) */
