/* Generated By:JJTree: Do not edit this line. ast_compare.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=ast_,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ast_compare extends SimpleNode {
    public ast_compare(int id) {
        super(id);
    }

    public ast_compare(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, io.leaderli.rule.RuleContext data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=06af7d517dc64aae698e2f8f6d4762ec (do not edit this line) */
