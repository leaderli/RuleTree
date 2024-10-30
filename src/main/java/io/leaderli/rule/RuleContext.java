package io.leaderli.rule;

import io.leaderli.litool.core.meta.LiTuple;

import java.util.HashMap;
import java.util.Map;

public class RuleContext {

    private Map<String, String> var_type = new HashMap<>();

    public void putType(String name, String type) {
        var_type.put(name, type);
    }

    public String getType(String name) {
        String type = var_type.get(name);
        if (type == null) {
            throw new IllegalStateException("var " + name + " not exist");
        }
        return type;
    }
}
