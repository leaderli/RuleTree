package io.leaderli.rule;

public class DoubleCompareFunction extends CompareFunction<Double> {
    public DoubleCompareFunction(String name, int math_operator, String math_varName, int operator, Double right) {
        super(name, math_operator, math_varName, operator, right);
    }

    @Override
    public Double plus(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double minus(Double a, Double b) {
        return a - b;
    }

    @Override
    public boolean gt(Double a, Double b) {
        return a > b;
    }

    @Override
    public boolean ge(Double a, Double b) {
        return a >= b;
    }

    @Override
    public boolean lt(Double a, Double b) {
        return a < b;
    }

    @Override
    public boolean le(Double a, Double b) {
        return a <= b;
    }
}
