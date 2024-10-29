package io.leaderli.rule.tree;

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
}
