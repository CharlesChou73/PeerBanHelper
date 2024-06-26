package com.ghostchu.peerbanhelper.metric;

import com.ghostchu.peerbanhelper.util.rule.Rule;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HitRateMetric {
    private final Map<Rule, HitRateMetricRecorder> hitRateMetric = new HashMap<>();

    public void addQuery(Rule object) {
        HitRateMetricRecorder recorder = hitRateMetric.get(object);
        if (recorder == null) {
            recorder = new HitRateMetricRecorder();
        }
        recorder.addQueryCounter();
        hitRateMetric.put(object, recorder);
    }

    public void addHit(Rule object) {
        HitRateMetricRecorder recorder = hitRateMetric.get(object);
        if (recorder == null) {
            recorder = new HitRateMetricRecorder();
        }
        recorder.addHitCounter();
        hitRateMetric.put(object, recorder);
    }

}
