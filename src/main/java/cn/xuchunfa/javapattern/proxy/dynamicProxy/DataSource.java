package cn.xuchunfa.javapattern.proxy.staticProxy;

import cn.xuchunfa.javapattern.proxy.dynamicProxy.MyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @description: 数据库连接池
 * @author: Xu chunfa
 * @create: 2018-11-08 21:12
 **/
public class DataSource {

    private static LinkedList<Connection> connectionList = new LinkedList<Connection>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","520999");
    }

    private DataSource(){
        if(connectionList == null || connectionList.size() == 0){
            for(int i = 0;i < 10;i++){
                try {
                    connectionList.add(createConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Connection getConnection(){
        //原有方式
        //return connectionList.remove()
        if(connectionList.size() > 0){
            final Connection  connection = connectionList.remove();
            Connection proxy = (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(), connection.getClass().getInterfaces(),
                    new MyProxy(connection));

            return proxy;
            //return new ConnectionProxy(connectionList.remove());
        }
        return null;
    }

    public void recoveryConnection(Connection connection){
        connectionList.add(connection);
    }

    public static LinkedList<Connection> getConnectionList() {
        return connectionList;
    }

    public static DataSource getDataSource(){
        return Holder.dataSource;
    }

    static class Holder{
        private static final DataSource dataSource = new DataSource();
    }
}
