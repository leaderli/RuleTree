/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.leaderli.rule.tree;

import io.leaderli.litool.core.collection.ArrayUtils;

public class SimpleNode<T> implements Node<T> {

    protected SimpleNode<?> parent;
    protected SimpleNode<?>[] children;
    protected int id;
    protected T value;
    protected RuleParser parser;

    public SimpleNode(RuleParser p, int i) {
        this(i);
        parser = p;
    }

    public SimpleNode(int i) {
        id = i;
    }

    public void jjtOpen() {
    }

    public void jjtClose() {
    }

    public void jjtSetParent(Node n) {
        parent = (SimpleNode<?>) n;
    }

    public Node jjtGetParent() {
        return parent;
    }

    public void jjtAddChild(Node n, int i) {
        if (children == null) {
            children = (SimpleNode<?>[]) new SimpleNode[i + 1];
        } else if (i >= children.length) {
            SimpleNode<?>[] c = new SimpleNode[i + 1];
            System.arraycopy(children, 0, c, 0, children.length);
            children = c;
        }
        children[i] = (SimpleNode<?>) n;
    }

    public Node jjtGetChild(int i) {
        return children[i];
    }

    public int jjtGetNumChildren() {
        return (children == null) ? 0 : children.length;
    }

    public int getId() {
        return id;
    }

    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(RuleParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public void jjtSetValue(T value) {
        this.value = value;
    }

    public T jjtGetValue() {
        return value;
    }

    /*
     * You can override these two methods in subclasses of SimpleNode to customize the way the node appears when the
     * tree is dumped. If your output uses more than one line you should override toString(String), otherwise overriding
     * toString() is probably all you need to do.
     */

    /**
     * Accept the visitor.
     **/
    @SuppressWarnings({"ReassignedVariable", "rawtypes", "unchecked"})
    public Object[] childrenAccept(RuleParserVisitor visitor, Object data) {
        if (children != null) {
            Object[] rs = new Object[children.length];
            Class component = null;
            for (int i = 0; i < children.length; i++) {
                rs[i] = children[i].jjtAccept(visitor, data);
                component = rs[i].getClass();
            }
            return ArrayUtils.toWrapperArray(component, rs);
        }
        return new Object[0];
    }

    public String toString() {
        return RuleParserTreeConstants.jjtNodeName[id];
    }

    /*
     * Override this method if you want to customize how the node dumps out its children.
     */

    public String toString(String prefix) {
        return prefix + this;
    }

    public void dump(String prefix) {
        System.out.println(toString(prefix));
        if (children != null) {
            for (SimpleNode<?> child : children) {
                if (child != null) {
                    child.dump(prefix + " ");
                }
            }
        }
    }
}

/* JavaCC - OriginalChecksum=55c9953d1a68ffc0aa4adb6e42430859 (do not edit this line) */
