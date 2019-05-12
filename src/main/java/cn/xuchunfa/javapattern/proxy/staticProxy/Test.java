package cn.xuchunfa.javapattern.proxy.staticProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 21:31
 **/
public class Test {
    
    public static void main(String[] args) throws SQLException {

        String sql = "insert into score(id,score) value(?,?)";
        DataSource dataSource = DataSource.getDataSource();
        System.out.println("使用前的数据库连接数：" + DataSource.getConnectionList().size());

        //静态代理
        //Connection connection = dataSource.getConnection();//数据库连接数减了一个

        //动态代理
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());//class com.sun.proxy.$Proxy0 返回的代理类

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 668);
            ps.setInt(2,102);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection != null && !connection.isClosed()){
            //if(!proxy.isClosed()){
                try {
                    connection.close();//放回数据库连接池
                    System.out.println("使用静态代理后的数据库连接数：" + DataSource.getConnectionList().size());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
