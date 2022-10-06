package com.example.demo.dao;





import java.sql.*;

public class HistoryDao {
    public void save() {
        //데이터베이스와 연결하는 객체
        Connection con = null;
        PreparedStatement pstmt = null;
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

            String sql = "insert into history (id, lnt, lat, date) VALUES (?, ?, ? ,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setLong(1, 1L);
            pstmt.setDouble(2, 1.54D);
            pstmt.setDouble(3, 0.33D);
            pstmt.setDate(4, null);

            System.out.println("잘 실행됨");

            int r = pstmt.executeUpdate();
            System.out.println("변경된 row = " + r);



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
    }

}

