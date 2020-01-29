package cn.xuchunfa.javapattern.proxy.staticProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 21:09
 **/
public class ConnectionProxy extends ConnectionProxyAdapter {

    private Connection connection;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    //要代理的方法
    //将数据库连接放回数据库连接池
    @Override
    public void close() throws SQLException {
        DataSource.getDataSource().recoveryConnection(connection);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
