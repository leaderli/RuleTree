package io.leaderli.rule;

import io.leaderli.litool.core.exception.LiAssertUtil;
import io.leaderli.rule.tree.RuleParserConstants;

import java.util.function.Function;

import static io.leaderli.rule.tree.RuleParserConstants.AND;
import static io.leaderli.rule.tree.RuleParserConstants.OR;

public class ExprFunction implements Function<RuleContext, Boolean> {

    public final int[] operators;
    public final TermFunction[] terms;

    public ExprFunction(int[] operators, TermFunction[] terms) {
        this.operators = operators;
        this.terms = terms;
        LiAssertUtil.assertTrue(this.terms.length - this.operators.length == 1);
        for (int op : operators) {
            LiAssertUtil.assertTrue(op == AND || op == OR,
                    "unsupported operator " + RuleParserConstants.tokenImage[op]);
        }

    }

    @Override
    public Boolean apply(RuleContext context) {
        int index = 0;
        boolean result = terms[index].apply(context);

        for (int i = 0; i < operators.length; i++) {
            int op = operators[i];
            if (op == AND) {
                if (!result) {
                    if (context.debug) {
                        System.out.println(toString(i + 1));
                    }
                    return false;
                } else {
                    result = terms[++index].apply(context);
                }
            } else if (op == OR) {
                if (result) {
                    if (context.debug) {
                        System.out.println(toString(i + 1));
                    }
                    return true;
                } else {
                    result = terms[++index].apply(context);
                }
            }
        }
        if (context.debug) {
            System.out.println(this);
        }
        return result;
    }

    public String toString(int end) {
        StringBuilder toString = new StringBuilder();
        toString.append(terms[0]);
        for (int i = 0; i < operators.length && i < end; i++) {
            int op = operators[i];
            toString.append(op == AND ? " and " : " or ").append(terms[i + 1]);
        }

        return toString.toString();
    }

    @Override
    public String toString() {
        return toString(operators.length);
    }
}
