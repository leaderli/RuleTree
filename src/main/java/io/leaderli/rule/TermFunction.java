package io.leaderli.rule;

import io.leaderli.litool.core.exception.LiAssertUtil;

import java.util.function.Function;

import static io.leaderli.rule.tree.RuleParserConstants.*;

public class TermFunction implements Function<RuleContext, Boolean> {

    public final int operation;
    public final Function<RuleContext, Boolean> subFunction;

    /**
     * @see io.leaderli.rule.tree.RuleParserConstants#TRUE
     * @see io.leaderli.rule.tree.RuleParserConstants#FALSE
     */
    public TermFunction(int operation) {
        this.operation = operation;
        this.subFunction = null;
        LiAssertUtil.assertTrue(operation == FALSE || operation == TRUE, "not supported operation " + operation);
    }

    public TermFunction(TermFunction subFunction) {
        this.operation = NOT;
        this.subFunction = subFunction;
    }

    public TermFunction(CompareFunction subFunction) {
        this.operation = 0;
        this.subFunction = subFunction;
    }

    public TermFunction(ExprFunction subFunction) {
        this.operation = 0;
        this.subFunction = subFunction;
    }

    @Override
    public Boolean apply(RuleContext context) {

        if (operation == NOT) {
            return !subFunction.apply(context);
        }
        if (operation == TRUE) {
            return true;
        }
        if (operation == FALSE) {
            return false;
        }
        return subFunction.apply(context);
    }

    @Override
    public String toString() {
        if (operation == TRUE) {
            return "true";
        }
        if (operation == FALSE) {
            return "false";
        }
        if (operation == NOT) {
            return "not (" + subFunction + " )";
        }
        if (operation == LPAREN) {
            return "( " + subFunction.toString() + " )";
        }
        return subFunction.toString();
    }
}
