package io.leaderli.rule.json;

import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.CodeGeneratorContextVisitor;
import io.leaderli.rule.tree.*;

import java.util.ArrayList;
import java.util.List;

import static io.leaderli.rule.tree.RuleParserConstants.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RuleJsonParserVisitor implements RuleParserVisitor {
    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_entry node, Object data) {
        List<RuleBean> rules = new ArrayList<>();

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            RuleBean ruleBean = (RuleBean) node.jjtGetChild(i).jjtAccept(this, rules);
            rules.add(ruleBean);
        }
        return rules;
    }

    @Override
    public Object visit(ast_rule node, Object data) {
        List<RuleBean> rules = (List<RuleBean>) data;
        RuleBean rule = new RuleBean();
        int result = node.jjtGetValue();
        int step = rules.size() + 1;
        node.jjtGetChild(0).jjtAccept(this, rule.expr);
        rule.rule = result;
        rule.step = step;
        return rule;
    }

    @Override
    public Object visit(ast_expr node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 0; i < node.jjtGetNumChildren() - 2; ) {
            node.jjtGetChild(++i).jjtAccept(this, data);
            node.jjtGetChild(++i).jjtAccept(this, data);
        }
        return null;
    }

    @Override
    public Object visit(ast_and node, Object data) {
        List<UnitBean> expr = (List<UnitBean>) data;
        return expr.add(UnitBean.of("operator_bool", "AND"));
    }

    @Override
    public Object visit(ast_or node, Object data) {
        List<UnitBean> expr = (List<UnitBean>) data;
        return expr.add(UnitBean.of("operator_bool", "OR"));
    }

    @Override
    public Object visit(ast_term node, Object data) {
        List<UnitBean> expr = (List<UnitBean>) data;
        int operation = node.jjtGetValue();
        if (operation == TRUE) {
            return expr.add(UnitBean.of("value", "true"));
        }
        if (operation == FALSE) {
            return expr.add(UnitBean.of("value", "false"));
        }
        if (operation == NOT) {
            if (node.jjtGetChild(0) instanceof ast_compare) {
                expr.add(UnitBean.of("operator_bool", "NOT"));
                expr.add(UnitBean.of("paren", "("));
                node.jjtGetChild(0).jjtAccept(this, data);
                expr.add(UnitBean.of("paren", ")"));
                return null;
            } else {
                expr.add(UnitBean.of("operator_bool", "NOT"));
                node.jjtGetChild(0).jjtAccept(this, data);
                return null;
            }
        }
        if (operation == LPAREN) {
            expr.add(UnitBean.of("paren", "("));
            node.jjtGetChild(0).jjtAccept(this, data);
            expr.add(UnitBean.of("paren", ")"));
            return null;
        }
        if (operation == 0) {
            node.jjtGetChild(0).jjtAccept(this, data);
            return null;
        }
        return null;
    }

    @Override
    public Object visit(ast_num_int node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_double node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_percent node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_num_time node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_compare node, Object data) {
        List<UnitBean> expr = (List<UnitBean>) data;
        LiTuple<String, String> var = ((ast_var) node.jjtGetChild(0)).jjtGetValue();
        String name = var._2;
        int operator1 = (int) (node.jjtGetChild(1)).jjtGetValue();
        String math_var_name = "";
        int compare_operator;
        int math_operator = 0;
        Object right;
        if (operator1 != PLUS && operator1 != MINUS) {
            compare_operator = operator1;
            right = ((LiTuple<String, Object>) ((node.jjtGetChild(2)).jjtGetValue()))._2;
        } else {
            math_operator = operator1;
            math_var_name = ((ast_var) node.jjtGetChild(2)).jjtGetValue()._2;
            compare_operator = ((ast_operator) node.jjtGetChild(3)).jjtGetValue();
            right = ((LiTuple<String, Object>) ((node.jjtGetChild(4)).jjtGetValue()))._2;
        }
        switch (var._1) {
            case "TIME":
            case "STR":
                expr.add(UnitBean.of("var_" + var._1, name));
                expr.add(UnitBean.of("operator_compare", CodeGeneratorContextVisitor.getOperatorCodeValue(compare_operator)));
                expr.add(UnitBean.of("value_" + var._1, right));
                break;
            case "PERCENT":
            case "INT":
            case "DOUBLE":
                expr.add(UnitBean.of("var_" + var._1, name));
                if (math_operator == PLUS || math_operator == MINUS) {
                    expr.add(UnitBean.of("operator_math", CodeGeneratorContextVisitor.getOperatorCodeValue(math_operator)));
                    expr.add(UnitBean.of("var_" + var._1, math_var_name));
                }
                expr.add(UnitBean.of("operator_compare", CodeGeneratorContextVisitor.getOperatorCodeValue(compare_operator)));
                expr.add(UnitBean.of("value_" + var._1, right));
                break;

            default:
                throw new UnsupportedOperationException("unsupported var type " + var._1);
        }
        return null;
    }

    @Override
    public Object visit(ast_math node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_operator node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_var node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_test node, Object data) {
        return null;
    }
}
