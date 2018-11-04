package com.ovo.tariff;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TariffCalculatorImpl implements TariffCalculator{


    private final double VAT = 0.05;
    Map<String, Tariff> tariffPlans;

    public TariffCalculatorImpl() {
        tariffPlans = loadJsonFile();

    }

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
    public Map<Double,String> energyConsuptionEstimator(int powerUsage, int gasUsage)
    {
        Map<Double,String> energyEstimationsPerTariffPlan = new TreeMap<>();
        for (String tariffName : tariffPlans.keySet()){
            double totalEnergyConsumption = 0.00;
            Tariff tariff = tariffPlans.get(tariffName);
            if (powerUsage > 0) {
                totalEnergyConsumption = (powerUsage * tariff.getPowerTariff().getTariff_charges()) + tariff.getPowerTariff().getStanding_charges();
            }
            if (gasUsage > 0) {
                totalEnergyConsumption = totalEnergyConsumption + (gasUsage * tariff.getGasTariff().getTariff_charges()) + tariff.getGasTariff().getStanding_charges();
            }
            totalEnergyConsumption = totalEnergyConsumption + (totalEnergyConsumption*VAT);
            energyEstimationsPerTariffPlan.put(totalEnergyConsumption,tariffName);
        }
        return energyEstimationsPerTariffPlan;
    }

    /**
     * For the specified tariff calculate how much energy (in kWh) would be used annually
     * from a monthly spend in pounds (inclusive of VAT). Fuel type can be of power or gas.
     *
     * @param tariffName - Tariff name
     * @param fuelType - Fuel type (power or gas)
     * @param monthlySpend - Monthly spend in pounds
     *
     * @return The total annual consumption.
     */
    public double usage(String tariffName, String fuelType, double monthlySpend)
    {
        TariffPlan tariffPlan = tariffPlans.get(tariffName).getTariff(fuelType);
        double tariffCharges = tariffPlan.getTariff_charges();
        double netChargesPerKWH = tariffPlan.getStanding_charges()+tariffPlan.getTariff_charges() + (tariffPlan.getStanding_charges()+tariffPlan.getTariff_charges())*VAT;
        return 12*(monthlySpend/netChargesPerKWH);
    }

    private Map<String, Tariff> loadJsonFile(){
        JSONParser parser = new JSONParser();
        Map<String, Tariff> tariffs = new HashMap<>();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(this.getClass().getResource("prices.json")));
            JSONObject tariffJson = (JSONObject) jsonObject.get("tariff");
            JSONArray tariffsArray = (JSONArray) tariffJson.get("tariff_plans");
            for (int i = 0; i < tariffsArray.size(); i++) {
                Tariff tariff = new Tariff();
                JSONObject tariffJSONObject = (JSONObject) tariffsArray.get(i);
                TariffPlan gasTariff = new TariffPlan();
                JSONObject gasTariffObject = (JSONObject) tariffJSONObject.get("gas_tariff");
                gasTariff.setFuel_type((String)gasTariffObject.get("fuel_type"));
                gasTariff.setTariff_charges((double)gasTariffObject.get("tariff_charges"));
                gasTariff.setStanding_charges((double)gasTariffObject.get("standing_charges"));
                tariff.setGasTariff(gasTariff);
                TariffPlan powerTariff = new TariffPlan();
                JSONObject powerTariffObject = (JSONObject) tariffJSONObject.get("power_tariff");
                powerTariff.setFuel_type((String)powerTariffObject.get("fuel_type"));
                powerTariff.setTariff_charges((double)powerTariffObject.get("tariff_charges"));
                powerTariff.setStanding_charges((double)powerTariffObject.get("standing_charges"));
                tariff.setPowerTariff(powerTariff);
                tariffs.put((String) tariffJSONObject.get("tariff_name"), tariff);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tariffs;
    }
}
