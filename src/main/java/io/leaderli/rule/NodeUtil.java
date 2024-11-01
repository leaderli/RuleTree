package io.leaderli.rule;

import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.tree.Node;
import io.leaderli.rule.tree.RuleParserTreeConstants;
import io.leaderli.rule.tree.SimpleNode;

public class NodeUtil {

    public static void dump(SimpleNode simpleNode) {
        dump(simpleNode, "");
    }

    public static void dump(SimpleNode simpleNode, String prefix) {
        Object value = simpleNode.jjtGetValue();
        if (value == null) {
            value = "";
        } else {
            value = ":" + value;
        }
        System.out.println(prefix + RuleParserTreeConstants.jjtNodeName[simpleNode.getId()] + value);
        for (int i = 0; i < simpleNode.jjtGetNumChildren(); i++) {
            SimpleNode children = (SimpleNode) simpleNode.jjtGetChild(i);
            if (children != null) {
                dump(children, prefix + " ");
            }
        }
    }

    public static String getChildrenNodeType(Node node, int index) {
        SimpleNode simpleNode = (SimpleNode) node.jjtGetChild(0);
        Object o = simpleNode.jjtGetValue();
        return ((LiTuple<String, Object>) ((SimpleNode) node.children[0]).jjtGetValue())._2;
    }
}
