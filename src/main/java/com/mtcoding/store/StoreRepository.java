package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Store Table DB 전담반
public class StoreRepository {

    // (개념)Read = (DB)select = (http)get
    public List<Store> selectAll(){
        Connection conn = DBConnection.getConnection();
        List<Store> list = new ArrayList<>();

        try {
            String sql = "select * from store_tb order by id desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 조회해서 view로 응답밥기
            ResultSet rs = pstmt.executeQuery();



            // 행이 존재하면 프로젝션
            while (rs.next()){
                // rs를 자바오브젝트로 파싱
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                Store store = new Store(c1,c2,c3,c4);
                list.add(store);

            }

            return list;



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    // Read = select = get
    public Store selectOne(int id){
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "select * from store_tb where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);

            // 조회해서 view로 응답밥기
            ResultSet rs = pstmt.executeQuery();

            // 커서 한칸 내리기
            boolean isRow = rs.next();

            // 행이 존재하면 프로젝션
            if (isRow){
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                Store store = new Store(c1,c2,c3,c4);

                return store;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    // Delete =delete = delete
    public int deleteOne(int id){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();

        String sql = "delete from store_tb where id=?";

        try {

            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);



            // 3. 쿼리 저송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return -1;

    }

    // Update =update = put
    public int updateOne(int id, String name, int price, int qty){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();

        String sql = "update store_tb set name=?,price=?, qty=? where id=?";

        try {

            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,price);
            pstmt.setInt(3,qty);
            pstmt.setInt(4,id);


            // 3. 쿼리 저송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return -1;

    }

    // Create =insert = post
    public int insert(int id, String name, int price, int qty){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();

        // 2. 버퍼달기
        String sql = "insert into store_tb(id,name,price,qty) values(?,?,?,?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setInt(3,price);
            pstmt.setInt(4,qty);


            // 3. 쿼리 저송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return -1;

    }




}
