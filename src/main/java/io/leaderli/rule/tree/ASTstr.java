/* Generated By:JJTree: Do not edit this line. ASTstr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ASTstr extends SimpleNode {
    public ASTstr(int id) {
        super(id);
    }

    public ASTstr(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, StringBuilder data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=d9e9c66910ec287be88193ce1efb5a07 (do not edit this line) */
