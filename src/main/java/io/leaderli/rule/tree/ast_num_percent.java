/* Generated By:JJTree: Do not edit this line. ast_num_percent.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=ast_,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ast_num_percent extends SimpleNode {
    public ast_num_percent(int id) {
        super(id);
    }

    public ast_num_percent(RuleParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public void jjtAccept(RuleParserVisitor visitor, io.leaderli.rule.RuleContext data) {

        visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=5ca8ae10b75b3da996048916871979b8 (do not edit this line) */
