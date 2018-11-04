package com.ovo.tariff;

import java.util.Map;

public interface TariffCalculator {

    /**
     * For the given annual kWh consumption(s), output an annual cost inclusive of VAT
     * for applicable tariffs, sorted by cheapest first.
     * Each tariff should be printed on its own line in the format TARIFF_NAME COST.
     * If any usage is 0 assume the customer is not being supplied for that fuel type.
     *
     * @param powerUsage - Power annual consumption
     * @param gasUsage - Power annual consumption
     *
     * @return Annual cost inclusive of VAT for applicable tariffs,
     * sorted by cheapest first.
     */
    public Map<Double,String> energyConsuptionEstimator(int powerUsage, int gasUsage);
}
