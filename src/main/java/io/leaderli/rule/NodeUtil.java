package io.leaderli.rule;

import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.tree.JJTRuleParserState;
import io.leaderli.rule.tree.RuleParserTreeConstants;
import io.leaderli.rule.tree.SimpleNode;

@SuppressWarnings("unchecked")
public class NodeUtil {

    public static void dump(SimpleNode<?> simpleNode) {
        dump(simpleNode, "");
    }

    public static void dump(SimpleNode<?> simpleNode, String prefix) {
        Object value = simpleNode.jjtGetValue();
        if (value == null) {
            value = "";
        } else {
            value = ":" + value;
        }
        System.out.println(prefix + RuleParserTreeConstants.jjtNodeName[simpleNode.getId()] + value);
        for (int i = 0; i < simpleNode.jjtGetNumChildren(); i++) {
            SimpleNode<?> children = (SimpleNode<?>) simpleNode.jjtGetChild(i);
            if (children != null) {
                dump(children, prefix + " ");
            }
        }
    }

    public static <T> String getCurrentChildrenNumNodeType(JJTRuleParserState jjtree) {
        SimpleNode<LiTuple<String, T>> simpleNode = (SimpleNode<LiTuple<String, T>>) jjtree.peekNode();
        return simpleNode.jjtGetValue()._1;
    }

    public static int getCurrentChildrenOperatorNodeValue(JJTRuleParserState jjtree) {
        SimpleNode<Integer> simpleNode = (SimpleNode<Integer>) jjtree.peekNode();
        return simpleNode.jjtGetValue();
    }
}
