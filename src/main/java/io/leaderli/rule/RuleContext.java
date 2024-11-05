package io.leaderli.rule;

import io.leaderli.litool.core.text.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RuleContext {

    public boolean debug;
    private Map<String, Object> vars = Collections.unmodifiableMap(new HashMap<>());

    public void initVars(Map<String, Object> vars) {
        this.vars = Collections.unmodifiableMap(vars);
    }

    public int getIntValue(String name) {
        return getVarValue(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T getVarValue(String name) {
        return (T) vars.get(name);
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
