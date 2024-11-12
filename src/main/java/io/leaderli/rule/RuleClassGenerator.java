package io.leaderli.rule;

import io.leaderli.rule.tree.RuleParser;
import io.leaderli.rule.tree.ast_entry;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class RuleClassGenerator {

    public static RuleExecutor parse(int ruleNo, String ruleContent, ParserContext parserContext) throws Exception {
        RuleParser ruleParser = new RuleParser(ruleContent, parserContext);
        ast_entry entry = (ast_entry) ruleParser.entry();

        ClassPool classPool = ClassPool.getDefault();

        CtClass ctClass = classPool.makeClass("io.leaderli.rule.RuleExecutorImpl" + ruleNo,
                classPool.get("io.leaderli.rule.RuleExecutor"));// Create class
        StringBuilder sb = new StringBuilder();
        sb.append("public int apply(io.leaderli.rule.RuleContext context){\r\n\r\n");
        parserContext.getNeededParameter().forEach((name, type) -> {

            String localVarType;
            switch (type) {
                case "TIME":
                case "STR":
                    localVarType = "String";
                    break;
                case "INT":
                    localVarType = "int";
                    break;
                case "PERCENT":
                case "DOUBLE":
                    localVarType = "double";
                    break;
                default:
                    throw new UnsupportedOperationException(type);
            }
            sb.append("\t");
            sb.append(localVarType);
            sb.append(" ");
            sb.append(name);
            sb.append(" = ");
            sb.append(" ");
            if ("int".equals(localVarType)) {
                sb.append("context.getIntValue(\"").append(name).append("\");\r\n");
            } else if ("double".equals(localVarType)) {
                sb.append("context.getDoubleValue(\"").append(name).append("\");\r\n");
            } else {
                sb.append("context.getStringValue(\"").append(name).append("\");\r\n");
            }
            sb.append("\r\n");
        });
        entry.jjtAccept(new CodeGeneratorContextVisitor(), sb);
        sb.append("\tthrow new IllegalStateException(\"not match rule found\");\n");
        sb.append("}");
        parserContext.debug(sb + "\r\n");
        ctClass.addMethod(CtMethod.make(sb.toString(), ctClass));
        return (RuleExecutor) ctClass.toClass().newInstance();
    }
}
