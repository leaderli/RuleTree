/* Generated By:JJTree: Do not edit this line. ASTneg.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ASTneg extends SimpleNode {
    public ASTneg(int id) {
        super(id);
    }

    public ASTneg(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, StringBuilder data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=5c9900aea399d6e9636f97d59c326e62 (do not edit this line) */
