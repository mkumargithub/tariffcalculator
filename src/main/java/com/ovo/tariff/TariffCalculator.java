package com.ovo.tariff;

import java.util.Map;

public interface TariffCalculator {
    public Map<Double,String> energyConsuptionEstimator(int powerUsage, int gasUsage);
}
