package io.leaderli.rule;

import io.leaderli.litool.core.exception.LiAssertUtil;
import io.leaderli.litool.core.text.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ParserContext {

    private final Map<String, String> var_type = new HashMap<>();
    private final List<Integer> ruleSet = new ArrayList<>();
    public boolean isDebug = false;
    private Consumer<String> debugConsumer = System.out::print;

    public void addRule(int... rules) {
        for (int rule : rules) {
            ruleSet.add(rule);
        }
    }

    public void setDebugConsumer(Consumer<String> debugConsumer) {
        this.debugConsumer = debugConsumer;
    }

    public void isValidRule(int rule) {
        if (ruleSet.contains(rule)) {
            return;
        }
        throw new UnsupportedOperationException("rule return " + rule + " is not support");
    }

    public void putType(String name, String type) {
        var_type.put(name, type);
    }

    public String getType(String name) {
        String type = var_type.get(name);
        if (type == null) {
            throw new UnsupportedOperationException("var " + name + " not exist");
        }
        LiAssertUtil.assertTrue(StringUtils.equalsAny(type, "INT", "STR", "DOUBLE", "PERCENT", "TIME"), "var type  " + type + " is not supported");
        return type;
    }

    public Map<String,String> getAllParameter(){
        return  new HashMap<>(var_type);
    }

    public void debug(String msg) {
        if (isDebug) {
            debugConsumer.accept(msg);
        }
    }
}