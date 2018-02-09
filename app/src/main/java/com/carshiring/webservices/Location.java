package com.carshiring.webservices;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rakhi on 09/02/2018.
 */

public class Location implements Serializable{
    public String city_name ;
    public String city_id ;
    public String company_id ;
    /**
     * response_code : 101
     * response : {"location":[{"city_name":"Dubai Al Maktoum International Airport (DWC)","city_id":"4","code":"6493","iata":"DWC","country_code":"AE","type":"a"},{"city_name":"Dubai International Airport (DXB)","city_id":"5","code":"3081","iata":"DXB","country_code":"AE","type":"a"},{"city_name":"Dubai","city_id":"25","code":"2453","iata":"","country_code":"AE","type":"c"}]}
     */

    private int response_code;
    private ResponseBean response;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        private List<LocationBean> location;

        public List<LocationBean> getLocation() {
            return location;
        }

        public void setLocation(List<LocationBean> location) {
            this.location = location;
        }

        public static class LocationBean {
            /**
             * city_name : Dubai Al Maktoum International Airport (DWC)
             * city_id : 4
             * code : 6493
             * iata : DWC
             * country_code : AE
             * type : a
             */

            @SerializedName("city_name")
            private String city_nameX;
            @SerializedName("city_id")
            private String city_idX;
            private String code;
            private String iata;
            private String country_code;
            private String type;

            public String getCity_nameX() {
                return city_nameX;
            }

            public void setCity_nameX(String city_nameX) {
                this.city_nameX = city_nameX;
            }

            public String getCity_idX() {
                return city_idX;
            }

            public void setCity_idX(String city_idX) {
                this.city_idX = city_idX;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getIata() {
                return iata;
            }

            public void setIata(String iata) {
                this.iata = iata;
            }

            public String getCountry_code() {
                return country_code;
            }

            public void setCountry_code(String country_code) {
                this.country_code = country_code;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
