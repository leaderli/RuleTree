package io.leaderli.rule;

import io.leaderli.litool.core.text.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RuleContext {

    private Map<String, Object> vars = Collections.unmodifiableMap(new HashMap<>());

    public boolean debug;

    public void initVars(Map<String, Object> vars) {
        this.vars = Collections.unmodifiableMap(vars);
    }

    @SuppressWarnings("unchecked")
    public <T> T getVarValue(String name) {
        return (T) vars.get(name);
    }

    public int getIntValue(String name) {
        return getVarValue(name);
    }

    public String getStringValue(String name) {
        return getVarValue(name);
    }

    public int getDoubleValue(String name) {
        return getVarValue(name);
    }

    public int compare(String a, String b) {
        return StringUtils.compare(a, b);
    }

    public void debug(String expr) {
        System.out.println(expr);
    }
}
