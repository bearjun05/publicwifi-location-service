package com.example.demo.service;

import com.example.demo.controller.LocationController;
import com.example.demo.dao.WifiDao;

public class MainService {
    public static void main(String[] args) {

        LocationController locationController = new LocationController();
        double a = locationController.latname;
        double b = locationController.lntname;

        System.out.println(a);

        WifiDao wifiDao = new WifiDao();
        wifiDao.find();
    }
}
