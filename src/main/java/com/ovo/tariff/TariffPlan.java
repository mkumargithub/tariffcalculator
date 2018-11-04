package com.ovo.tariff;

import java.util.Objects;

public class TariffPlan {
    private String fuel_type;
    private double tariff_charges;
    private double standing_charges;

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public double getTariff_charges() {
        return tariff_charges;
    }

    public void setTariff_charges(double tariff_charges) {
        this.tariff_charges = tariff_charges;
    }

    public double getStanding_charges() {
        return standing_charges;
    }

    public void setStanding_charges(double standing_charges) {
        this.standing_charges = standing_charges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TariffPlan)) return false;
        TariffPlan that = (TariffPlan) o;
        return Double.compare(that.getTariff_charges(), getTariff_charges()) == 0 &&
                Double.compare(that.getStanding_charges(), getStanding_charges()) == 0 &&
                Objects.equals(getFuel_type(), that.getFuel_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuel_type(), getTariff_charges(), getStanding_charges());
    }
}
