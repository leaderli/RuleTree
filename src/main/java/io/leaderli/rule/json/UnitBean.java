package io.leaderli.rule.json;

public class UnitBean {

    public final String type;
    public final Object value;

    public UnitBean(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public static UnitBean of(String type, Object value) {
        return new UnitBean(type, value);
    }
}
