package com.example.demo.service;

import com.example.demo.controller.LocationController;
import com.example.demo.dao.WifiDao;

public class MainService {
    public static void main(String[] args) {

        LocationController locationController = new LocationController();
        double lat = locationController.latname;
        double lnt = locationController.lntname;

        WifiDao wifiDao = new WifiDao();
        wifiDao.find(lat, lnt);


    }
}
