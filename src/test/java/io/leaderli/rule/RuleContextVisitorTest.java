package io.leaderli.rule;

import io.leaderli.litool.core.collection.LiMapUtil;
import io.leaderli.rule.tree.ParseException;
import io.leaderli.rule.tree.RuleParser;
import io.leaderli.rule.tree.ast_entry;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

class RuleContextVisitorTest {

    @Test
    void test() throws ParseException, IOException, CannotCompileException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ParserContext context = new ParserContext();
        context.debug = true;
        context.putType("a", "INT");
        context.putType("b", "INT");
        context.putType("c", "TIME");
        context.addRule(1, 2, -1);
        RuleParser ruleParser = new RuleParser(
                "rule:1 true and not (false or a > 5) and a + b > 1 rule:2 true and not (false or true) and a = 1 or c = 10:10:10 rule:-1 true",
                context);
        ast_entry entry = (ast_entry) ruleParser.entry();
        // EntryFunction entryFunction = (EntryFunction) entry.jjtAccept(new RuleContextVisitor(), EntryFunction.class);
        RuleContext ruleContext = new RuleContext();
        // int a = (int) ruleContext.getVarValue("a");

        HashMap<String, Object> vars = LiMapUtil.newHashMap("a", 1);
        vars.put("b", 1);
        vars.put("c", "1");
        // ruleContext.initVars(vars);
        // ruleContext.debug = true;
        // System.out.println(entryFunction.apply(ruleContext));
        vars.put("a", 10);
        ruleContext.initVars(vars);
        // System.out.println(entryFunction.apply(ruleContext));

        // 生成类名
        ClassPool classPool = ClassPool.getDefault();

        CtClass ctClass = classPool.makeClass("Rule1");// Create class
        // vars.forEach((k, v) -> {
        // StringBuilder sb2 = new StringBuilder();
        // sb2.append("private final ");
        // switch (context.getType(k)) {
        // case "TIME":
        // sb2.append("String");
        // break;
        // case "INT":
        // sb2.append("int");
        // break;
        // case "PERCENT":
        // case "DOUBLE":
        // sb2.append("double");
        // break;
        // }
        // sb2.append(" ");
        // sb2.append(k);
        //// sb2.append("= ");
        //// if (v instanceof String) {
        //// sb2.append("\"");
        //// sb2.append(v);
        //// sb2.append("\"");
        //// } else {
        //// sb2.append(v);
        //// }
        // sb2.append(" ;");

        // try {
        // ctClass.addField(CtField.make(sb2.toString(), ctClass));
        // } catch (CannotCompileException e) {
        // throw new RuntimeException(e);
        // }
        // });

        StringBuilder sb = new StringBuilder();
        sb.append("public int apply(io.leaderli.rule.RuleContext context){\r\n\r\n");
        vars.forEach((k, v) -> {

            String localVarType;
            switch (context.getType(k)) {
                case "TIME":
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
                    throw new UnsupportedOperationException();
            }
            sb.append("\t");
            sb.append(localVarType);
            sb.append(" ");
            sb.append(k);
            sb.append(" = ");
            // sb.append("(");
            // sb.append(localVarType);
            // sb.append(") ");
            sb.append(" ");
            if ("int".equals(localVarType)) {
                sb.append("context.getIntValue(\"").append(k).append("\");\r\n");
            } else if ("double".equals(localVarType)) {
                sb.append("context.getDoubleValue(\"").append(k).append("\");\r\n");
            } else {
                sb.append("context.getStringValue(\"").append(k).append("\");\r\n");
            }
            sb.append("\r\n");
        });
        entry.jjtAccept(new CodeGeneratorContextVisitor(), sb);
        sb.append("\tthrow new IllegalStateException(\"not match rule found\");\n");
        sb.append("}");
        System.out.println(sb.toString());
        ctClass.addMethod(CtMethod.make(sb.toString(), ctClass));
        Class<?> clazz = ctClass.toClass();
        Object o = clazz.newInstance();
        System.out.println(clazz.getMethod("apply", RuleContext.class).invoke(o, ruleContext));

    }
}
