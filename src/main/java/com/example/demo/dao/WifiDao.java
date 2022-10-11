package com.example.demo.dao;

import com.example.demo.api.DistanceApi;
import com.example.demo.api.GsonApi;
import com.example.demo.controller.LocationController;
import com.example.demo.dto.BaseDto;
import com.example.demo.vo.Wifi;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiDao {

    public String save () {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // 1. JDBC Driver Class
        String driver = "com.mysql.jdbc.Driver";

        // 2. 데이터베이스에 연결하기 위한 정보
        String url = "jdbc:mysql://localhost:3306/wifidb";     // 연결문자열, localhost - 127.0.0.1
        String user = "wifiuser";                                   // 데이터베이스 ID
        String pw = "1234";                                     // 데이터베이스 PW

        BaseDto baseDto = null;

        try {
            //1. JDBC 드라이버 로딩
            Class.forName(driver);

            // 2. Connection 생성
            con = DriverManager.getConnection(url, user, pw);//데이터베이스 연결

            System.out.println("[Database 연결 성공]");

            String sql = "insert into wifi(x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm,\n" +
                    "                 x_swifi_adres1, x_swifi_adres2, x_swifi_instl_floor,\n" +
                    "                 x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se,\n" +
                    "                 x_swifi_cmcwr, x_swifi_cnstc_year, x_swifi_inout_door,\n" +
                    "                 x_swifi_remars3, lat, lnt, work_dttm)\n" +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            System.out.println("Sql 전달 성공");


            GsonApi gsonApi = new GsonApi();
            try {


                int start = 0;
                int end = 999;
                int cnt = 0;
                int r = 0;
                int total = 0;
                boolean flag = true;

                while(flag) {
                    baseDto = gsonApi.parse(start, end);
                    for (int i = 0; i < 999; i++) {
                        pstmt.setString(1, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_MGR_NO());
                        pstmt.setString(2, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_WRDOFC());
                        pstmt.setString(3, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_MAIN_NM());
                        pstmt.setString(4, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_ADRES1());
                        pstmt.setString(5, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_ADRES2());
                        pstmt.setString(6, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_FLOOR());
                        pstmt.setString(7, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_TY());
                        pstmt.setString(8, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_MBY());
                        pstmt.setString(9, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_SVC_SE());
                        pstmt.setString(10, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_CMCWR());
                        pstmt.setString(11, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_CNSTC_YEAR());
                        pstmt.setString(12, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INOUT_DOOR());
                        pstmt.setString(13, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_REMARS3());
                        pstmt.setDouble(14, baseDto.getTbPublicWifiInfo().getRow().get(i).getLNT());
                        pstmt.setDouble(15, baseDto.getTbPublicWifiInfo().getRow().get(i).getLAT());
                        pstmt.setString(16, baseDto.getTbPublicWifiInfo().getRow().get(i).getWORK_DTTM());
                        cnt++;
                        r += pstmt.executeUpdate();
                        pstmt.clearParameters();

                        total = Integer.parseInt(baseDto.getTbPublicWifiInfo().getList_total_count());
                        if(cnt==total){
                            flag = false;
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("잘 실행됨");

            /*
            CUD (create, update, delete)는 excuteUpdate(sql) 함수를 사용하고 int 값을 반환한다.
            R(read)은 excuteQuery(sql) 함수를 사용하고 ResultSet 객체를 반환한다.
             */

        } catch (SQLException e) {

            System.out.println("[SQL Error : " + e.getMessage() +"]");

        } catch (ClassNotFoundException e1) {

            System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
        } finally {
            //Connection 사용 후 Close
            if(con != null) {
                try {
                    con.close();
                } catch (Exception e) {

                }
            }
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {

                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }

        }
        return baseDto.getTbPublicWifiInfo().getList_total_count();
    }
    public void delete () {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;




        // 1. JDBC Driver Class
        String driver = "com.mysql.jdbc.Driver";

        // 2. 데이터베이스에 연결하기 위한 정보
        String url = "jdbc:mysql://localhost:3306/wifidb";     // 연결문자열, localhost - 127.0.0.1
        String user = "wifiuser";                                   // 데이터베이스 ID
        String pw = "1234";                                     // 데이터베이스 PW


        try {
            //1. JDBC 드라이버 로딩
            Class.forName(driver);

            // 2. Connection 생성
            con = DriverManager.getConnection(url, user, pw);//데이터베이스 연결

            System.out.println("[Database 연결 성공]");

            String sql = "truncate table wifi";

            pstm = con.prepareStatement(sql);
            System.out.println("Sql 전달 성공");


            int res = pstm.executeUpdate();

            System.out.println("잘 실행됨");

            /*
            CUD (create, update, delete)는 excuteUpdate(sql) 함수를 사용하고 int 값을 반환한다.
            R(read)은 excuteQuery(sql) 함수를 사용하고 ResultSet 객체를 반환한다.
             */

        } catch (SQLException e) {

            System.out.println("[SQL Error : " + e.getMessage() +"]");

        } catch (ClassNotFoundException e1) {

            System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
        } finally {
            //Connection 사용 후 Close
            if(con != null) {
                try {
                    con.close();
                } catch (Exception e) {

                }
            }
            if(pstm != null) {
                try {
                    pstm.close();
                } catch (Exception e) {

                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }

        }
    }

    public List<Wifi> find (double lat, double lnt) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Wifi wifi = new Wifi();

        List<Wifi> list = new ArrayList<>();

        LocationController locationController = new LocationController();
        DistanceApi distanceApi = new DistanceApi();

        double distance = 0;

        // 1. JDBC Driver Class
        String driver = "com.mysql.jdbc.Driver";

        // 2. 데이터베이스에 연결하기 위한 정보
        String url = "jdbc:mysql://localhost:3306/wifidb";     // 연결문자열, localhost - 127.0.0.1
        String user = "wifiuser";                                   // 데이터베이스 ID
        String pw = "1234";                                     // 데이터베이스 PW


        try {
            //1. JDBC 드라이버 로딩
            Class.forName(driver);

            // 2. Connection 생성
            con = DriverManager.getConnection(url, user, pw);//데이터베이스 연결

            System.out.println("[Database 연결 성공]");

            String sql = "select * " +
                    ", format((6371 * acos(cos(radians(" + lat + ")) * cos(radians(lat)) * cos(radians(lnt) - radians(" + lnt + ")) " +
                    "+ sin(radians(" + lat + ")) * sin(radians(lat)))), 4) as distance " +
                    " from wifi " +
                    " order by distance , X_SWIFI_MGR_NO" +
                    " limit 20";

            pstm = con.prepareStatement(sql);
            System.out.println("Sql 전달 성공");

            rs= pstm.executeQuery();

            System.out.println("잘 실행됨");


            while (rs.next()) {

                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                double LNT = rs.getDouble("LNT");
                double LAT = rs.getDouble("LAT");
                String WORK_DTTM = rs.getString("WORK_DTTM");


                System.out.println("+++++++++++++++++++++");
                System.out.println(LNT);
                System.out.println(LAT);


                distance = distanceApi.distance(locationController.latname,
                        locationController.lntname, LAT, LNT);


                System.out.println(X_SWIFI_MGR_NO + " " +distance + " ");


                list.add(new Wifi(distance ,X_SWIFI_MGR_NO ,X_SWIFI_WRDOFC
                        ,X_SWIFI_MAIN_NM ,X_SWIFI_ADRES1  ,X_SWIFI_ADRES2
                        ,X_SWIFI_INSTL_FLOOR ,X_SWIFI_INSTL_TY ,X_SWIFI_INSTL_MBY
                        ,X_SWIFI_SVC_SE ,X_SWIFI_CMCWR ,X_SWIFI_CNSTC_YEAR
                        ,X_SWIFI_INOUT_DOOR ,X_SWIFI_REMARS3, LNT, LAT, WORK_DTTM));
            }



            /*
            CUD (create, update, delete)는 excuteUpdate(sql) 함수를 사용하고 int 값을 반환한다.
            R(read)은 excuteQuery(sql) 함수를 사용하고 ResultSet 객체를 반환한다.
             */

        } catch (SQLException e) {

            System.out.println("[SQL Error : " + e.getMessage() +"]");

        } catch (ClassNotFoundException e1) {

            System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
        } finally {
            //Connection 사용 후 Close
            if(con != null) {
                try {
                    con.close();
                } catch (Exception e) {

                }
            }
            if(pstm != null) {
                try {
                    pstm.close();
                } catch (Exception e) {

                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }

        }


        return list;
    }


//    public static void main(String[] args) {
//        //데이터베이스와 연결하는 객체
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//
//
//
//        // 1. JDBC Driver Class
//        String driver = "com.mysql.jdbc.Driver";
//
//        // 2. 데이터베이스에 연결하기 위한 정보
//        String url = "jdbc:mysql://localhost:3306/wifi";     // 연결문자열, localhost - 127.0.0.1
//        String user = "root";                                   // 데이터베이스 ID
//        String pw = "coh0303030";                                     // 데이터베이스 PW
//
//
//        try {
//            //1. JDBC 드라이버 로딩
//            Class.forName(driver);
//
//            // 2. Connection 생성
//            con = DriverManager.getConnection(url, user, pw);//데이터베이스 연결
//
//            System.out.println("[Database 연결 성공]");
//
//            String sql = "insert into wifi(x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm,\n" +
//                    "                 x_swifi_adres1, x_swifi_adres2, x_swifi_instl_floor,\n" +
//                    "                 x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se,\n" +
//                    "                 x_swifi_cmcwr, x_swifi_cnstc_year, x_swifi_inout_door,\n" +
//                    "                 x_swifi_remars3, lat, lnt, work_dttm)\n" +
//                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//            pstmt = con.prepareStatement(sql);
//            System.out.println("Sql 전달 성공");
//
//
//            GsonApi gsonApi = new GsonApi();
//            try {
//                BaseDto baseDto = null;
//
//                int start = 0;
//                int end = 999;
//                int cnt = 0;
//                int r = 0;
//                int total = 0;
//                boolean flag = true;
//
//                while(flag) {
//                    baseDto = gsonApi.parse(start, end);
//                    for (int i = 0; i < 999; i++) {
//                        pstmt.setString(1, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_MGR_NO());
//                        pstmt.setString(2, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_WRDOFC());
//                        pstmt.setString(3, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_MAIN_NM());
//                        pstmt.setString(4, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_ADRES1());
//                        pstmt.setString(5, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_ADRES2());
//                        pstmt.setString(6, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_FLOOR());
//                        pstmt.setString(7, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_TY());
//                        pstmt.setString(8, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INSTL_MBY());
//                        pstmt.setString(9, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_SVC_SE());
//                        pstmt.setString(10, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_CMCWR());
//                        pstmt.setString(11, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_CNSTC_YEAR());
//                        pstmt.setString(12, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_INOUT_DOOR());
//                        pstmt.setString(13, baseDto.getTbPublicWifiInfo().getRow().get(i).getX_SWIFI_REMARS3());
//                        pstmt.setDouble(14, baseDto.getTbPublicWifiInfo().getRow().get(i).getLNT());
//                        pstmt.setDouble(15, baseDto.getTbPublicWifiInfo().getRow().get(i).getLAT());
//                        pstmt.setString(16, baseDto.getTbPublicWifiInfo().getRow().get(i).getWORK_DTTM());
//                        cnt++;
//                        r += pstmt.executeUpdate();
//                        pstmt.clearParameters();
//
//                        total = Integer.parseInt(baseDto.getTbPublicWifiInfo().getList_total_count());
//                        if(cnt==total){
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("잘 실행됨");
//
//            /*
//            CUD (create, update, delete)는 excuteUpdate(sql) 함수를 사용하고 int 값을 반환한다.
//            R(read)은 excuteQuery(sql) 함수를 사용하고 ResultSet 객체를 반환한다.
//             */
//
//        } catch (SQLException e) {
//
//            System.out.println("[SQL Error : " + e.getMessage() +"]");
//
//        } catch (ClassNotFoundException e1) {
//
//            System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
//        } finally {
//            //Connection 사용 후 Close
//            if(con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//
//                }
//            }
//            if(pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (Exception e) {
//
//                }
//            }
//            if(rs != null) {
//                try {
//                    rs.close();
//                } catch (Exception e) {
//
//                }
//            }
//
//        }
//    }

}

