package com.carshiring.webservices;

import com.carshiring.models.AboutUs;
import com.carshiring.models.Category;
import com.carshiring.models.LanguageModel;
import com.carshiring.models.Point;
import com.carshiring.models.SearchData;
import com.carshiring.models.UserDetails;
import com.carshiring.models.CarDetailBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public class Data {

    public ArrayList<LanguageModel> language_list;
    public UserDetails userdetail;
    public List<SearchData> car_list ;
    public List<Location> location;
    public CarDetailBean car_detail;
    public Point point;
    public List<Category> cat;
    public AboutUs about_us;
}
