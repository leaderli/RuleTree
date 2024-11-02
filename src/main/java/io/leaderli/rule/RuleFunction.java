package io.leaderli.rule;

public class RuleFunction {
    public final int result;
    public final ExprFunction expr;

    public RuleFunction(int result, ExprFunction expr) {
        this.result = result;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "rule:" + result + System.lineSeparator() + expr + System.lineSeparator();
    }
}
