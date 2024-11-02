package io.leaderli.rule;

import java.util.function.Function;

public class EntryFunction implements Function<RuleContext, Integer> {

    private final RuleFunction[] rules;

    public EntryFunction(RuleFunction[] rules) {
        this.rules = rules;
    }

    @Override
    public Integer apply(RuleContext context) {
        for (int i = 0; i < rules.length; i++) {

            RuleFunction rule = rules[i];
            boolean match = rule.expr.apply(context);
            if (context.debug) {
                System.out.println((i + 1) + ". " + rule);
            }
            if (match) {
                return rule.result;
            }
        }
        throw new IllegalStateException("not match rule found");
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (RuleFunction rule : rules) {
            toString.append(rule);
        }
        return toString.toString();
    }
}
