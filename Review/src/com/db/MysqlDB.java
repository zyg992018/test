package com.db;

import java.sql.*;

public class MysqlDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC",
                    "root",
                "990902"
                );
        //创建状态
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM USER";
        statement.execute(sql);
        ResultSet set = statement.getResultSet();
        while(set.next()){
            int id = set.getInt(1);
            String user = set.getString(2);
            String pass = set.getString(3);
            String phone = set.getString(4);
            System.out.println(id+user+pass+phone);
        }
        statement.close();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into USER VALUES (?,?,?,?)");
        preparedStatement.setInt(1,5);
        preparedStatement.setString(2,"小王");
        preparedStatement.setString(3,"1213435");
        preparedStatement.setString(4,"12345678901");
        int a =  preparedStatement.executeUpdate();
        if(a==1){
            System.out.println("插入成功");
        }else {
            System.out.println(a);
        }
    }
}
