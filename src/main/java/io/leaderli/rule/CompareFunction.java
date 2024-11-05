package io.leaderli.rule;

import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.tree.RuleParserConstants;
import io.leaderli.rule.tree.ast_compare;
import io.leaderli.rule.tree.ast_operator;
import io.leaderli.rule.tree.ast_var;

import java.util.Objects;
import java.util.function.Function;

import static io.leaderli.rule.tree.RuleParserConstants.*;

public class CompareFunction<T> implements Function<RuleContext, Boolean> {

    public final String name;
    public final int math_operator;
    public final String math_var_name;
    public final int compare_operator;
    public final T right;

    public CompareFunction(String name, int math_operator, String math_varName, int operator, T right) {
        this.name = name;
        this.math_operator = math_operator;
        this.math_var_name = math_varName;
        this.compare_operator = operator;
        this.right = right;
    }

    @SuppressWarnings("unchecked")
    public static <T> CompareFunction instance(ast_compare node) {
        LiTuple<String, String> var = ((ast_var) node.jjtGetChild(0)).jjtGetValue();
        String name = var._2;
        int operator1 = (int) (node.jjtGetChild(1)).jjtGetValue();
        String math_var_name = "";
        int compare_operator;
        int math_operator = 0;
        T right;
        if (operator1 != PLUS && operator1 != MINUS) {
            compare_operator = operator1;
            right = ((LiTuple<String, T>) ((node.jjtGetChild(2)).jjtGetValue()))._2;
        } else {
            math_operator = operator1;
            math_var_name = ((ast_var) node.jjtGetChild(2)).jjtGetValue()._2;
            compare_operator = ((ast_operator) node.jjtGetChild(3)).jjtGetValue();
            ;
            right = ((LiTuple<String, T>) ((node.jjtGetChild(4)).jjtGetValue()))._2;
        }
        switch (var._1) {
            case "TIME":
            case "STR":
                return new StrCompareFunction(name, math_operator, math_var_name, compare_operator, (String) right);
            case "INT":
                return new IntCompareFunction(name, math_operator, math_var_name, compare_operator, (Integer) right);
            case "DOUBLE":
            case "PERCENT":
                return new DoubleCompareFunction(name, math_operator, math_var_name, compare_operator, (Double) right);
            default:
                throw new UnsupportedOperationException("unsupported var type " + var._1);
        }
    }

    @Override
    public Boolean apply(RuleContext context) {
        T left = context.getVarValue(name);
        if (math_operator == PLUS) {
            left = plus(left, context.getVarValue(math_var_name));
        } else if (math_operator == MINUS) {
            left = minus(left, context.getVarValue(math_var_name));
        }
        if (context.debug) {
            System.out.println(this);
        }
        switch (compare_operator) {
            case EQ:
                return eq(left, right);
            case NE:
                return ne(left, right);
            case GT:
                return gt(left, right);
            case GE:
                return ge(left, right);
            case LT:
                return lt(left, right);
            case LE:
                return le(left, right);
            default:
                throw new UnsupportedOperationException(
                        RuleParserConstants.tokenImage[compare_operator] + " is not supported");
        }
    }

    public T plus(T a, T b) {
        throw new UnsupportedOperationException();
    }

    ;

    public T minus(T a, T b) {
        throw new UnsupportedOperationException();
    }

    ;

    public boolean eq(T a, T b) {
        return Objects.equals(a, b);
    }

    ;

    public boolean ne(T a, T b) {
        return !Objects.equals(a, b);
    }

    ;

    public boolean gt(T a, T b) {
        throw new UnsupportedOperationException();
    }

    ;

    public boolean ge(T a, T b) {
        throw new UnsupportedOperationException();
    }

    ;

    public boolean lt(T a, T b) {
        throw new UnsupportedOperationException();
    }

    ;

    public boolean le(T a, T b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        if (math_operator == PLUS || math_operator == MINUS) {
            sb.append(tokenImage[math_operator].replace("\"", ""));
            sb.append(" ");
            sb.append(math_var_name);
            sb.append(" ");
        }
        sb.append(tokenImage[compare_operator].replace("\"", ""));
        sb.append(" ");
        sb.append(right);

        return sb.toString();
    }
}
