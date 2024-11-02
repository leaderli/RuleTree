package io.leaderli.rule;

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
}
