/* Generated By:JJTree: Do not edit this line. ast_and.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=ast_,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ast_and extends SimpleNode {
    public ast_and(int id) {
        super(id);
    }

    public ast_and(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, io.leaderli.rule.RuleContext data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=6a46cb92bd85538a10cac8fbcb82b448 (do not edit this line) */
