/* Generated By:JJTree: Do not edit this line. ast_expr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=ast_,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

public class ast_expr extends SimpleNode<Void> {
    public ast_expr(int id) {
        super(id);
    }

    public ast_expr(RuleParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(RuleParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=dfd80249cb5673a49402a4aa0b73234b (do not edit this line) */