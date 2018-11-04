package com.ovo.tariff;

import java.util.Map;
import java.util.Scanner;

public class RunOvoTariff {

    public static void main(String[] args) {
        int powerUsage;
        int gasUsage;
        String fuelType;
        String tariffName;
        double monthlySpentLimit;
        try{
            System.out.println("Enter power usage in kHw (EX: 100) : ");
            Scanner scanner = new Scanner(System.in);
            powerUsage  = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gas usage in kWH (EX: 100) :");
            gasUsage = Integer.parseInt(scanner.nextLine());
            TariffCalculator tariffCalculator =  new TariffCalculatorImpl();
            Map<Double,String> energyEstimationsPerTariffPlan = tariffCalculator.energyConsuptionEstimator(powerUsage,gasUsage);
            System.out.println("Displaying the tariff charges per plan in ascending order.");
            for (Double estmatedTariffCharges : energyEstimationsPerTariffPlan.keySet()){
                System.out.println("TARIFF_NAME : "+energyEstimationsPerTariffPlan.get(estmatedTariffCharges)+" COST : "+ String.format ("%.2f",estmatedTariffCharges));
            }
            System.out.println("---------------------------- Command2----------------------------");
            System.out.println("Please Enter Fuel Type (EX: gas | power) : ");
            fuelType = scanner.nextLine();
            System.out.println("Please Enter Tariff Name (EX:tariff1 | tariff2 | tariff3) : ");
            tariffName = scanner.nextLine();
            System.out.println("Please Enter Your Monthly Spending Amount (EX: 100 | 100.00) : ");
            monthlySpentLimit = Double.parseDouble(scanner.nextLine());
            System.out.println("Your Total Annual Consumption in kWh  :  "+ String.format ("%.2f", ((TariffCalculatorImpl) tariffCalculator).usage(tariffName,fuelType,monthlySpentLimit)));
        }catch (Exception e){
            System.out.println("Invalid Input Parameters : " + e.getMessage());
        }
    }
}