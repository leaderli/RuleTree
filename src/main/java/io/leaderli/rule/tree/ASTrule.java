/* Generated By:JJTree: Do not edit this line. ASTrule.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ASTrule extends SimpleNode {
    public ASTrule(int id) {
        super(id);
    }

    public ASTrule(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, io.leaderli.rule.RuleContext data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=f22bd9bcd5e2ef7f3e535c60162de9bc (do not edit this line) */
