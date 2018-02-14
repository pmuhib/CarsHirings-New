package com.carshiring.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public class car_detail {

    /**
     * status : Available
     * feature : {"aircondition":true,"transmission":"Manual","fueltype":"","bag":"Small Bag 2 Large Bag 1","door":"2"}
     * category : 2
     * model : Maruti Suzuki Alto k10
     * model_code :
     * image : https://carsgates.com/upload/Alto1.jpg
     * package :
     * price : 542.7
     * currency : SAR
     * time_unit : Day
     * time : 2
     * id_context : 4
     * refer_type :
     * deposit_currency :
     * deposit_price :
     * deposit_desc :
     * deposit_name :
     * supplier : rrrrr
     * supplier_city :
     * supplier_logo : https://carsgates.com/upload/
     * drop_city :
     * tc :
     * rule :
     * extra : [{"type":"4","name":"BabySeat","currency":"SAR","amount":"25.00","desc":"Get baby seat with car\r\n"}]
     * coverages : [{"code":"","name":"Fuel Information","currency":"","amount":"0.00","desc":"Full To Full"}]
     * type : 1
     */

    private String status;
    private FeatureBean feature;
    private String category;
    private String model;
    private String model_code;
    private String image;
    @SerializedName("package")
    private String packageX;
    private double price;
    private String currency;
    private String time_unit;
    private String time;
    private String id_context;
    private String refer_type;
    private String deposit_currency;
    private String deposit_price;
    private String deposit_desc;
    private String deposit_name;
    private String supplier;
    private String supplier_city;
    private String supplier_logo;
    private String drop_city;
    private String tc;
    private String rule;
    private String type;
    private List<ExtraBean> extra;
    private List<CoveragesBean> coverages;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FeatureBean getFeature() {
        return feature;
    }

    public void setFeature(FeatureBean feature) {
        this.feature = feature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId_context() {
        return id_context;
    }

    public void setId_context(String id_context) {
        this.id_context = id_context;
    }

    public String getRefer_type() {
        return refer_type;
    }

    public void setRefer_type(String refer_type) {
        this.refer_type = refer_type;
    }

    public String getDeposit_currency() {
        return deposit_currency;
    }

    public void setDeposit_currency(String deposit_currency) {
        this.deposit_currency = deposit_currency;
    }

    public String getDeposit_price() {
        return deposit_price;
    }

    public void setDeposit_price(String deposit_price) {
        this.deposit_price = deposit_price;
    }

    public String getDeposit_desc() {
        return deposit_desc;
    }

    public void setDeposit_desc(String deposit_desc) {
        this.deposit_desc = deposit_desc;
    }

    public String getDeposit_name() {
        return deposit_name;
    }

    public void setDeposit_name(String deposit_name) {
        this.deposit_name = deposit_name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier_city() {
        return supplier_city;
    }

    public void setSupplier_city(String supplier_city) {
        this.supplier_city = supplier_city;
    }

    public String getSupplier_logo() {
        return supplier_logo;
    }

    public void setSupplier_logo(String supplier_logo) {
        this.supplier_logo = supplier_logo;
    }

    public String getDrop_city() {
        return drop_city;
    }

    public void setDrop_city(String drop_city) {
        this.drop_city = drop_city;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ExtraBean> getExtra() {
        return extra;
    }

    public void setExtra(List<ExtraBean> extra) {
        this.extra = extra;
    }

    public List<CoveragesBean> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<CoveragesBean> coverages) {
        this.coverages = coverages;
    }

    public static class FeatureBean {
        /**
         * aircondition : true
         * transmission : Manual
         * fueltype :
         * bag : Small Bag 2 Large Bag 1
         * door : 2
         */

        private boolean aircondition;
        private String transmission;
        private String fueltype;
        private String bag;
        private String door;

        public boolean isAircondition() {
            return aircondition;
        }

        public void setAircondition(boolean aircondition) {
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

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }
    }

    public static class ExtraBean {
        /**
         * type : 4
         * name : BabySeat
         * currency : SAR
         * amount : 25.00
         * desc : Get baby seat with car

         */

        private String type;
        private String name;
        private String currency;
        private String amount;
        private String desc;

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

    public static class CoveragesBean {
        /**
         * code :
         * name : Fuel Information
         * currency :
         * amount : 0.00
         * desc : Full To Full
         */

        private String code;
        private String name;
        private String currency;
        private String amount;
        private String desc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

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
}
