package io.leaderli.rule;

public class IntCompareFunction extends CompareFunction<Integer> {
    public IntCompareFunction(String name, int math_operator, String math_varName, int operator, Integer right) {
        super(name, math_operator, math_varName, operator, right);
    }

    @Override
    public Integer plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public boolean gt(Integer a, Integer b) {
        return a > b;
    }

    @Override
    public boolean ge(Integer a, Integer b) {
        return a >= b;
    }

    @Override
    public boolean lt(Integer a, Integer b) {
        return a < b;
    }

    @Override
    public boolean le(Integer a, Integer b) {
        return a <= b;
    }
}
