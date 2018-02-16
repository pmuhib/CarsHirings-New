package com.carshiring.models;

import java.util.List;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public class CarDetailBean {

    /**
     * feature : {"aircondition":"true","transmission":"Manual","fueltype":"Petrol","bag":"1","passenger":"4","door":"2"}
     * category : 1
     * model : FORD KA
     * model_code : MBMR
     * image : https://static.carhire-solutions.com/images/car/Enterprise/large/t_MBMR_DE.jpg
     * price : 753.72
     * currency : SAR
     * time_unit : Day
     * time : 5
     * driver_min_age : 25
     * driver_max_age : 80
     * opening_hours_start : 07:00
     * opening_hours_end : 23:00
     * collision_damage_waiver : ["Maximum excess of 850 EUR to be paid in the case of damage. Please note that comprehensive insurance does not cover damage to wheels, tires, mirrors and underbody"]
     * theft_protection : ["In case of theft, there is an excess of 850 EUR.  Please note: this does not cover loss of personal items."]
     * deposit_currency : EUR
     * deposit_price : 1000
     * deposit_desc : Upon collection of the car a security deposit will be blocked on the driver’s credit card. This deposit is determined by supplier considering your selected car category. The value of one tank of fuel and possible traffic fines can be additionally blocked on a valid credit card (prepaid debit cards, prepaid credit cards and cash cannot be accepted).
     For luxury cars two credit cards in the same name are required for all rentals. The credit card must not be from the same issuer. Please note some suppliers will not accept American Express, Visa Premier or Diners Club credit cards, we strongly recommend to use a Visa or Mastercard. In the event that you fail to produce a valid credit card or have insufficient funds available the car rental agent may refuse to release the vehicle. In this instance no funds will be reimbursed.Estimated deposit amount: EUR 1000
     * deposit_name : Estimated deposit amount
     * fullprotection_currency : USD
     * fullprotection_amount : 36.50
     * supplier : Enterprise
     * supplier_city : BERLIN AIRPORT
     * supplier_logo : https://static.carhire-solutions.com/images/supplier/logo/logo61.png
     * drop_city : null
     * tc : https://createpdf.carhire-solutions.com/termsandconditions.aspx?reference=62192246233072489421620813&languageId=2
     * extra : [{"type":"413","name":"Full Protection","price":"36.50","currency":"USD"},{"type":"222","name":"Additional Driver","price":"5.00","currency":"EUR"}]
     * coverages : [{"name":"Kilometer inclusive: 1500 km (0,31 EUR/km)","currency":"EUR","amount":"0.31","desc":"per km: 0.31 EUR"},{"name":"Other taxes and service charges","currency":"EUR","amount":"44.09","desc":"per rental: 44.09 EUR"},{"name":"Location service charge","currency":"USD","amount":"0.00","desc":"An additional service charge applies at some airports, railway stations and ports- In this offer it is included."},{"name":"Collision damage waiver","currency":"USD","amount":"0.00","desc":"Maximum excess of 850 EUR to be paid in the case of damage. Please note that comprehensive insurance does not cover damage to wheels, tires, mirrors and underbody"},{"name":"Supplementary Liability Insurance","currency":"USD","amount":"0.00","desc":"Legally required, insurance for damages on the adversarial vehicle, persons and objects- In this offer it is included."},{"name":"Theft protection","currency":"USD","amount":"0.00","desc":"In case of theft, there is an excess of 850 EUR.  Please note: this does not cover loss of personal items."},{"name":"Airport Service Charge","currency":"USD","amount":"0.00","desc":"Some airports charge a service fee- In this offer it is included."},{"name":"One way rental","currency":"USD","amount":"0.00","desc":"Onewayrental fees are included"},{"name":"Fuel Information","currency":"USD","amount":"0.00","desc":"Full to Full: Pick up and drop off with a full tank. If the car is not returned with a full tank, suppliers will charge fuel plus refueling charges. "},{"name":"VAT","currency":"USD","amount":"0.00","desc":"The rate corresponds with the VAT-rate of the particular country."}]
     * cancledetail : {"Coverage":{"@attributes":{"CoverageType":"Cancellation fee","Code":"CF"},"Details":[{"Coverage":{"@attributes":{"CoverageType":"2018-02-16T06:34:03_2018-02-26T10:15:00"}},"Charge":{"@attributes":{"CurrencyCode":"EUR","Amount":"0.00","Description":"Up to 48 hours before pick-up, cancellation free of charge. Within 48 hours prior to pick-up a fee equal to the total rental price with a maximum amount of USD 125 will be charged. In the event of a no-show 100% of the sales price will be charged.","IncludedInRate":"true"}}},{"Coverage":{"@attributes":{"CoverageType":"2018-02-26T10:15:00_2018-02-28T10:15:00"}},"Charge":{"@attributes":{"CurrencyCode":"EUR","Amount":"153.06","Description":"Up to 48 hours before pick-up, cancellation free of charge. Within 48 hours prior to pick-up a fee equal to the total rental price with a maximum amount of USD 125 will be charged. In the event of a no-show 100% of the sales price will be charged."},"Calculation":{"@attributes":{"UnitCharge":"191.4231","UnitName":"PreferedCurrencyPrice: CurrencyCode=USD"}}}}]},"Charge":{"@attributes":{"IncludedInRate":"true"}}}
     * type : 0
     */

    public FeatureBean feature;
    public String category;
    public String model;
    public String model_code;
    public String image;
    public String price;
    public String currency;
    public String time_unit;
    public String time;
    public String driver_min_age;
    public String driver_max_age;
    public String opening_hours_start;
    public String opening_hours_end;
    public String deposit_currency;
    public String deposit_price;
    public String deposit_desc;
    public String deposit_name;
    public String fullprotection_currency;
    public String fullprotection_amount;
    public String supplier;
    public String supplier_city;
    public String supplier_logo;
    public Object drop_city;
    public String tc;
    public CancledetailBean cancledetail;
    public String type;
    public List<String> collision_damage_waiver;
    public List<String> theft_protection;
    public List<ExtraBean> extra;
    public List<CoveragesBean> coverages;

    public static class FeatureBean {
        /**
         * aircondition : true
         * transmission : Manual
         * fueltype : Petrol
         * bag : 1
         * passenger : 4
         * door : 2
         */

        public String aircondition;
        public String transmission;
        public String fueltype;
        public String bag;
        public String passenger;
        public String door;

        public String getAircondition() {
            return aircondition;
        }

        public void setAircondition(String aircondition) {
            this.aircondition = aircondition;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public String getFueltype() {
            return fueltype;
        }

        public void setFueltype(String fueltype) {
            this.fueltype = fueltype;
        }

        public String getBag() {
            return bag;
        }

        public void setBag(String bag) {
            this.bag = bag;
        }

        public String getPassenger() {
            return passenger;
        }

        public void setPassenger(String passenger) {
            this.passenger = passenger;
        }

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }
    }

    public static class CoveragesBean  {

        /**
         * name : Kilometer inclusive: 1500 km (0,31 EUR/km)
         * currency : EUR
         * amount : 0.31
         * desc : per km: 0.31 EUR
         */

        public String name;
        public String currency;
        public String amount;
        public String desc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class ExtraBean {

        /**
         * type : 413
         * name : Full Protection
         * price : 36.50
         * currency : USD
         */

        public String type;
        public String name;
        public String price;
        public String currency;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static class CancledetailBean {

        /**
         * Coverage : {"@attributes":{"CoverageType":"Cancellation fee","Code":"CF"},"Details":[{"Coverage":{"@attributes":{"CoverageType":"2018-02-16T06:34:03_2018-02-26T10:15:00"}},"Charge":{"@attributes":{"CurrencyCode":"EUR","Amount":"0.00","Description":"Up to 48 hours before pick-up, cancellation free of charge. Within 48 hours prior to pick-up a fee equal to the total rental price with a maximum amount of USD 125 will be charged. In the event of a no-show 100% of the sales price will be charged.","IncludedInRate":"true"}}},{"Coverage":{"@attributes":{"CoverageType":"2018-02-26T10:15:00_2018-02-28T10:15:00"}},"Charge":{"@attributes":{"CurrencyCode":"EUR","Amount":"153.06","Description":"Up to 48 hours before pick-up, cancellation free of charge. Within 48 hours prior to pick-up a fee equal to the total rental price with a maximum amount of USD 125 will be charged. In the event of a no-show 100% of the sales price will be charged."},"Calculation":{"@attributes":{"UnitCharge":"191.4231","UnitName":"PreferedCurrencyPrice: CurrencyCode=USD"}}}}]}
         * Charge : {"@attributes":{"IncludedInRate":"true"}}
         */

   /*     public CoverageBeanX Coverage;
        public ChargeBeanX Charge;
*/
       // FIXME generate failure  field _$Attributes70
       public static class ChargeBeanX {

        }
    }
}
