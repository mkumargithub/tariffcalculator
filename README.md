# Tariff Calculator

# Description:
This is a small java project to claulate customer tariff uses in kWh 

# Requirement:
```
Input
Your program should support two commands:
cost <POWER_USAGE> <GAS_USAGE>
For the given annual kWh consumption(s), output an annual cost inclusive of VAT for applicable tariffs, sorted by cheapest first. Each tariff should be printed on its own line in the format TARIFF_NAME COST. If any usage is 0 assume the customer is not being supplied for that fuel type.
usage <TARIFF_NAME> <FUEL_TYPE> <TARGET_MONTHLY_SPEND>
For the specified tariff calculate how much energy (in kWh) would be used annually from a monthly spend in pounds (inclusive of VAT). Fuel type can be of power or gas. Output should just be the total annual consumption.
Resources
prices.json contains a set of rates that describe how much the customer will be charged for each kilowatt-hour (kWh) of energy they use. Tariffs are divided into power and/or gas. Additionally, a tariff defines a monthly standing charge (exclusive of VAT) which is applied to each energy type separately.
Prices are defined as £/kWh exclusive of VAT. VAT is then applied at 5%.
```

# How to run 
to run the application please execute RunOvoTariff.java file

# User Input:
User need to give the input for power and gas uses.


# Consol Output:
```code
Enter power usage in kHw (EX: 100) : 
100
Enter gas usage in kWH (EX: 100) :
100
Displaying the tariff charges per plan in ascending order.
TARIFF_NAME : tariff3 COST : 122.85
TARIFF_NAME : tariff1 COST : 451.5
TARIFF_NAME : tariff2 COST : 567.0
---------------------------- Command2----------------------------
Please Enter Fuel Type (EX: gas | power) : 
gas
Please Enter Tariff Name (EX:tariff1 | tariff2 | tariff3) : 
tariff1
Please Enter Your Monthly Spending Amount (EX: 100 | 100.00) : 
200
Your Total Annual Consumption in kWh  :  198.76

Process finished with exit code 0
```

## Import with Maven: ##
    <dependency>
         <groupId>com.ovo.traiff</groupId>
        <artifactId>tariffcalculator</artifactId>
        <version>1.0-OVOTEST</version>
    </dependency>



# MVN Build Status:
```log
Manishs-iMac:tariffcalculator manish$ mvn clean compile assembly:single
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.ovo.traiff:tariffcalculator >-------------------
[INFO] Building tariffcalculator 1.0-OVOTEST
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tariffcalculator ---
[INFO] Deleting /Users/manish/IdeaProjects/tariffcalculator/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tariffcalculator ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ tariffcalculator ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 5 source files to /Users/manish/IdeaProjects/tariffcalculator/target/classes
[INFO] 
[INFO] --- maven-assembly-plugin:2.2-beta-5:single (default-cli) @ tariffcalculator ---
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] org/ already added, skipping
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] org/ already added, skipping
[INFO] org/hamcrest/ already added, skipping
[INFO] org/hamcrest/core/ already added, skipping
[INFO] org/hamcrest/internal/ already added, skipping
[INFO] LICENSE.txt already added, skipping
[INFO] org/hamcrest/BaseDescription.class already added, skipping
[INFO] org/hamcrest/BaseMatcher.class already added, skipping
[INFO] org/hamcrest/core/AllOf.class already added, skipping
[INFO] org/hamcrest/core/AnyOf.class already added, skipping
[INFO] org/hamcrest/core/DescribedAs.class already added, skipping
[INFO] org/hamcrest/core/Is.class already added, skipping
[INFO] org/hamcrest/core/IsAnything.class already added, skipping
[INFO] org/hamcrest/core/IsEqual.class already added, skipping
[INFO] org/hamcrest/core/IsInstanceOf.class already added, skipping
[INFO] org/hamcrest/core/IsNot.class already added, skipping
[INFO] org/hamcrest/core/IsNull.class already added, skipping
[INFO] org/hamcrest/core/IsSame.class already added, skipping
[INFO] org/hamcrest/CoreMatchers.class already added, skipping
[INFO] org/hamcrest/Description.class already added, skipping
[INFO] org/hamcrest/Factory.class already added, skipping
[INFO] org/hamcrest/internal/ArrayIterator.class already added, skipping
[INFO] org/hamcrest/internal/SelfDescribingValue.class already added, skipping
[INFO] org/hamcrest/internal/SelfDescribingValueIterator.class already added, skipping
[INFO] org/hamcrest/Matcher.class already added, skipping
[INFO] org/hamcrest/SelfDescribing.class already added, skipping
[INFO] org/hamcrest/StringDescription.class already added, skipping
[INFO] META-INF/maven/ already added, skipping
[INFO] Building jar: /Users/manish/IdeaProjects/tariffcalculator/target/tariffcalculator-1.0-OVOTEST-jar-with-dependencies.jar
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] org/ already added, skipping
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] org/ already added, skipping
[INFO] org/hamcrest/ already added, skipping
[INFO] org/hamcrest/core/ already added, skipping
[INFO] org/hamcrest/internal/ already added, skipping
[INFO] LICENSE.txt already added, skipping
[INFO] org/hamcrest/BaseDescription.class already added, skipping
[INFO] org/hamcrest/BaseMatcher.class already added, skipping
[INFO] org/hamcrest/core/AllOf.class already added, skipping
[INFO] org/hamcrest/core/AnyOf.class already added, skipping
[INFO] org/hamcrest/core/DescribedAs.class already added, skipping
[INFO] org/hamcrest/core/Is.class already added, skipping
[INFO] org/hamcrest/core/IsAnything.class already added, skipping
[INFO] org/hamcrest/core/IsEqual.class already added, skipping
[INFO] org/hamcrest/core/IsInstanceOf.class already added, skipping
[INFO] org/hamcrest/core/IsNot.class already added, skipping
[INFO] org/hamcrest/core/IsNull.class already added, skipping
[INFO] org/hamcrest/core/IsSame.class already added, skipping
[INFO] org/hamcrest/CoreMatchers.class already added, skipping
[INFO] org/hamcrest/Description.class already added, skipping
[INFO] org/hamcrest/Factory.class already added, skipping
[INFO] org/hamcrest/internal/ArrayIterator.class already added, skipping
[INFO] org/hamcrest/internal/SelfDescribingValue.class already added, skipping
[INFO] org/hamcrest/internal/SelfDescribingValueIterator.class already added, skipping
[INFO] org/hamcrest/Matcher.class already added, skipping
[INFO] org/hamcrest/SelfDescribing.class already added, skipping
[INFO] org/hamcrest/StringDescription.class already added, skipping
[INFO] META-INF/maven/ already added, skipping
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.375 s
[INFO] Finished at: 2018-11-04T13:15:22Z
[INFO] ------------------------------------------------------------------------
Manishs-iMac:tariffcalculator manish$ 
```

