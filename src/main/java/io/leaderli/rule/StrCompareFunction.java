package io.leaderli.rule;

import io.leaderli.litool.core.text.StringUtils;

public class StrCompareFunction extends CompareFunction<String> {
    public StrCompareFunction(String name, int math_operator, String math_varName, int operator, String right) {
        super(name, math_operator, math_varName, operator, right);
    }

    @Override
    public boolean gt(String a, String b) {
        return StringUtils.compare(a, b) > 0;
    }

    @Override
    public boolean ge(String a, String b) {
        return StringUtils.compare(a, b) >= 0;
    }

    @Override
    public boolean lt(String a, String b) {
        return StringUtils.compare(a, b) < 0;
    }

    @Override
    public boolean le(String a, String b) {
        return StringUtils.compare(a, b) <= 0;
    }
}
