package com.example.demo.test;

import com.example.demo.api.DistanceApi;

public class DistanceTest {

    public static void main(String[] args) {
//
//        126.96675
//        37.561924
//
//        126.9661696
//        37.552128


        DistanceApi distanceApi = new DistanceApi();
        double distance = distanceApi.distance(37.561924, 126.96675,
                37.552128, 126.9661696);
        System.out.println(distance);

        System.out.println("<><><><><><><><><><><><><><>");

        double aa = 37.561924 - 37.552128;
        double bb = 126.96675 - 126.9661696;
        System.out.println(aa*aa);
        System.out.println(bb*bb);
        System.out.println(Math.max(37.561924, 37.552128));
        System.out.println(Math.min(126.96675, 126.9661696));
        System.out.println(Math.sqrt(Math.pow(aa,2)-Math.pow(bb, 2)));

        double c = 126.96675-126.9661696;
        System.out.println("c = "+ c);


        double a  = Math.sqrt(Math.pow(Math.max(126.96675, 126.9661696) - Math.min(126.96675, 126.9661696), 2) -
                Math.pow(Math.max(37.561924, 37.552128) - Math.min(37.561924, 37.552128), 2));

        System.out.println(a);
    }
}
