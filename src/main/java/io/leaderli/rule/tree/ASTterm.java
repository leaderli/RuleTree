/* Generated By:JJTree: Do not edit this line. ASTterm.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ASTterm extends SimpleNode {
    public ASTterm(int id) {
        super(id);
    }

    public ASTterm(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, StringBuilder data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=8d6b0c51407f6582bdeed4145a0b5e53 (do not edit this line) */