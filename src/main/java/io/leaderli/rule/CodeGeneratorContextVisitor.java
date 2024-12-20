/* Generated By:JavaCC: Do not edit this line. RuleParserDefaultVisitor.java Version 7.0.13 */
package io.leaderli.rule;

import io.leaderli.litool.core.meta.LiTuple;
import io.leaderli.rule.tree.*;

import static io.leaderli.rule.tree.RuleParserConstants.*;

@SuppressWarnings("rawtypes")
public class CodeGeneratorContextVisitor implements RuleParserVisitor {

    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ast_entry node, Object data) {
        StringBuilder sb = (StringBuilder) data;

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            node.jjtGetChild(i).jjtAccept(this, sb);
        }

        return null;
    }

    @Override
    public Object visit(ast_rule node, Object data) {
        int result = node.jjtGetValue();
        StringBuilder sb = (StringBuilder) data;
        sb.append("\t context.recordStep();\r\n");
        sb.append("\tif(");
        int start = sb.length();
        node.jjtGetChild(0).jjtAccept(this, data);
        String expr = sb.substring(start);

        sb.append("){\r\n");
        sb.append("\t\t context.debug(\"rule:").append(result).append("\\r\\n").append(expr.replace("\"", "\\\""))
                .append("\\r\\n\"").append(");\r\n");

        sb.append("\t\t return ").append(result).append(";\r\n");
        sb.append("\t}\r\n\r\n");
        return null;

    }

    @Override
    public Object visit(ast_expr node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 0; i < node.jjtGetNumChildren() - 2;i+=2 ) {
            node.jjtGetChild(i+1).jjtAccept(this, data);
            node.jjtGetChild(i+2).jjtAccept(this, data);
        }
        return null;
    }

    @Override
    public Object visit(ast_and node, Object data) {
        StringBuilder sb = (StringBuilder) data;
        sb.append(" && ");
        return null;
    }

    @Override
    public Object visit(ast_or node, Object data) {
        StringBuilder sb = (StringBuilder) data;
        sb.append(" || ");
        return null;
    }

    @Override
    public Object visit(ast_term node, Object data) {
        StringBuilder sb = (StringBuilder) data;

        int operation = node.jjtGetValue();
        if (operation == TRUE) {
            return sb.append(" true ");
        }
        if (operation == FALSE) {
            return sb.append(" false");
        }
        if (operation == NOT) {
            if (node.jjtGetChild(0) instanceof ast_compare) {
                sb.append("!(");
                node.jjtGetChild(0).jjtAccept(this, data);
                sb.append(")");
            } else {
                sb.append("!");
                node.jjtGetChild(0).jjtAccept(this, data);
            }
            return null;
        }
        if (operation == LPAREN) {
            sb.append("(");
            node.jjtGetChild(0).jjtAccept(this, data);
            sb.append(")");
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

    @SuppressWarnings("unchecked")
    @Override
    public Object visit(ast_compare node, Object data) {
        StringBuilder sb = (StringBuilder) data;
        LiTuple<String, String> typeNameTuple = ((ast_var) node.jjtGetChild(0)).jjtGetValue();
        String name = typeNameTuple._2;
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
        switch (typeNameTuple._1) {
            case "TIME":
            case "STR":
                sb.append("context.compare(");
                sb.append(" ");
                sb.append(name);
                sb.append(", ");
                sb.append(" \"");
                sb.append(right);
                sb.append("\") ");
                sb.append(getOperatorCodeValue(compare_operator));
                sb.append(" 0");
                break;
            case "PERCENT":
            case "INT":
            case "DOUBLE":
                sb.append(" ");
                sb.append(name);
                sb.append(" ");
                if (math_operator == PLUS || math_operator == MINUS) {
                    sb.append(getOperatorCodeValue(math_operator));
                    sb.append(" ");
                    sb.append(math_var_name);
                    sb.append(" ");
                }
                sb.append(getOperatorCodeValue(compare_operator));
                sb.append(" ");
                sb.append(right);
                sb.append(" ");
                break;

            default:
                throw new UnsupportedOperationException("unsupported var type " + typeNameTuple._1);
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

    public static String getOperatorCodeValue(int operator) {
        switch (operator) {
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case EQ:
                return "==";
            case NE:
                return "!=";
            case GT: {
                return ">";
            }
            case GE: {
                return ">=";

            }
            case LT: {
                return "<";

            }
            case LE: {
                return "<=";
            }
            default:
                throw new UnsupportedOperationException(tokenImage[operator]);
        }

    }

}
