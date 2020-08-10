package com.luban.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBConnectionUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBConnectionUtil.class);

    private static volatile Connection connection;

    private JDBConnectionUtil(){

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 單例獲取Connection
     * @return
     */
    public static Connection getInstance() throws SQLException {
        if(connection == null){
            synchronized (Connection.class){
                if(connection == null){
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_db","root","11111");
                }
            }
        }
        return connection;
    }

    public static PreparedStatement getStatement(String sql,Object[] args) throws SQLException {
        Connection connection = getInstance();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length ; i++) {
            preparedStatement.setObject(i+1,args[i]);
        }
        return preparedStatement;
    }

    public static List<UserDao> selectResults(String sql, Object[] args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(sql,args);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserDao> userDaoList = new ArrayList<UserDao>();
        while (resultSet.next()){
            UserDao userDao = new UserDao();
            userDao.setId(resultSet.getString("id"));
            userDao.setUserName(resultSet.getString("user_name"));
            userDao.setPassWord(resultSet.getString("password"));
            userDao.setName(resultSet.getString("name"));
            userDao.setAge(resultSet.getInt("age"));
            userDao.setSex(resultSet.getInt("sex"));
            userDao.setBirthday(resultSet.getDate("birthday"));
            userDao.setCreated(resultSet.getDate("created"));
            userDao.setUpdated(resultSet.getDate("updated"));
            userDaoList.add(userDao);
        }
        close(preparedStatement,resultSet);
        return userDaoList;
    }

    public static int updateResults(String sql,Object[] args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(sql,args);
        int effectNumbers = preparedStatement.executeUpdate();
        close(preparedStatement,null);
        return effectNumbers;
    }

    public static Boolean insertResults(String sql,Object[] args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(sql,args);
        Boolean result = preparedStatement.execute();
        close(preparedStatement,null);
        return result;
    }

    public static Boolean deleteResults(String sql,Object[] args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(sql,args);
        Boolean result = preparedStatement.execute();
        close(preparedStatement,null);
        return result;
    }

    public static void close(PreparedStatement preparedStatement,ResultSet resultSet){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Close PreparedStatement Exception");
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("Close ResultSet Exception");
                e.printStackTrace();
            }
        }
    }
}
