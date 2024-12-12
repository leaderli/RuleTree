package io.leaderli.rule.json;

import java.util.ArrayList;
import java.util.List;

public class RuleBean {

    public int rule;
    public int step;
    public List<UnitBean> expr = new ArrayList<>();
}
