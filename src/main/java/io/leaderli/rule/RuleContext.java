package io.leaderli.rule;

import io.leaderli.litool.core.text.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RuleContext {

    /**
     * 每个规则匹配 + 1
     */
    public int step;
    public boolean isDebug;
    private Consumer<String> debugConsumer = System.out::print;

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

    public double getDoubleValue(String name) {
        return getVarValue(name);
    }

    public int compare(String a, String b) {
        return StringUtils.compare(a, b);
    }

    public void setDebugConsumer(Consumer<String> debugConsumer) {
        this.debugConsumer = debugConsumer;
    }

    public void debug(String expr) {
        this.debugConsumer.accept(expr);
    }

    public void recordStep() {
        step++;
    }
}
