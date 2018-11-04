package com.ovo.tariff;

import java.util.Objects;

public class Tariff {

    private TariffPlan gasTariff;
    private TariffPlan powerTariff;

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tariff)) return false;
        Tariff tariff = (Tariff) o;
        return  Objects.equals(getGasTariff(), tariff.getGasTariff()) &&
                Objects.equals(getPowerTariff(), tariff.getPowerTariff());
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getGasTariff(), getPowerTariff());
    }

    public TariffPlan getTariff(String fuelType) {
        if("GAS".equalsIgnoreCase(fuelType)){
            return  getGasTariff();
        }else{
            return getPowerTariff();
        }
    }

    public TariffPlan getGasTariff() {
        return gasTariff;
    }

    public void setGasTariff(TariffPlan gasTariff) {
        this.gasTariff = gasTariff;
    }

    public TariffPlan getPowerTariff() {
        return powerTariff;
    }

    public void setPowerTariff(TariffPlan powerTariff) {
        this.powerTariff = powerTariff;
    }
}
