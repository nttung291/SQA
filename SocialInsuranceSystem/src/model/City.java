/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.HometownDAO;
import java.util.ArrayList;

/**
 *
 * @author nttungg
 */
public class City {
    public String city;
    public int level;
    public int code;

    public City(String city, int level, int code) {
        this.city = city;
        this.level = level;
        this.code = code;
    }
    
    public static String[] name = { "An Giang",
                                    "Bà Rịa - Vũng Tàu",
                                    "Bắc Giang",
                                    "Bắc Kạn",
                                    "Bạc Liêu",
                                    "Bắc Ninh",
                                    "Bến Tre",
                                    "Bình Định",
                                    "Bình Dương",
                                    "Bình Phước",
                                    "Bình Thuận",
                                    "Cà Mau",
                                    "Cao Bằng",
                                    "Đắk Lắk",
                                    "Đắk Nông",
                                    "Điện Biên",
                                    "Đồng Nai",
                                    "Đồng Tháp",
                                    "Gia Lai",
                                    "Hà Giang",
                                    "Hà Nam",
                                    "Hà Tĩnh",
                                    "Hải Dương",
                                    "Hậu Giang",
                                    "Hòa Bình",
                                    "Hưng Yên",
                                    "Khánh Hòa",
                                    "Kiên Giang",
                                    "Cần Thơ",
                                    "Đà Nẵng",
                                    "Hải Phòng",
                                    "Hà Nội",
                                    "TP HCM",
                                    "Kon Tum",
                                    "Lai Châu",
                                    "Lâm Đồng",
                                    "Lạng Sơn",
                                    "Lào Cai",
                                    "Long An",
                                    "Nam Định",
                                    "Nghệ An",
                                    "Ninh Bình",
                                    "Ninh Thuận",
                                    "Phú Thọ",
                                    "Quảng Bình",
                                    "Quảng Nam",
                                    "Quảng Ngãi",
                                    "Quảng Ninh",
                                    "Quảng Trị",
                                    "Sóc Trăng",
                                    "Sơn La",
                                    "Tây Ninh",
                                    "Thái Bình",
                                    "Thái Nguyên",
                                    "Thanh Hóa",
                                    "Thừa Thiên Huế",
                                    "Tiền Giang",
                                    "Trà Vinh",
                                    "Tuyên Quang",
                                    "Vĩnh Long",
                                    "Vĩnh Phúc",
                                    "Yên Bái",
                                    "Phú Yên"};
    
    public static ArrayList<Hometown> initCities() {
        ArrayList<Hometown> cities = new ArrayList<>();
        Hometown city;
        for (int i=0;i<name.length;i++) {
            if (i <= 10){
              
                city = new Hometown(i + 10,name[i], 2);
            } else if (i>=11 && i <= 29) {
               
                city = new Hometown(i + 10, name[i], 3);
            } else if (i >= 30 && i <= 42) {
               
                city = new Hometown(i + 10, name[i], 4);
            } else {
                city = new Hometown(i + 10, name[i], 1);
            }
            HometownDAO.insertHometown(city);
            cities.add(city);
        }
        
        return cities;
    }
    
}
