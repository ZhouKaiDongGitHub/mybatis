package com.luban.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 原生JDBC實現數據庫的操作
 *  這邊數據庫以Mysql為例
 */
public class SqlTest {

    private Logger logger = LoggerFactory.getLogger(SqlTest.class);

    public static void main(String[] args) {
        SqlTest sqlTest = new SqlTest();
        try {
            //增加
            String insertSql = "INSERT INTO TEST_DB.TB_USER ( ID,USER_NAME, PASSWORD, NAME, AGE, SEX, BIRTHDAY, CREATED, UPDATED) " +
                    " VALUES (4,'zs','123456','張三','22','1','1997-09-05',sysdate(), sysdate())";
            //sqlTest.insetUser(insertSql,new Object[]{});

            //查找
            String selectSql = "SELECT ID,USER_NAME, PASSWORD, NAME, AGE, SEX, BIRTHDAY, CREATED, UPDATED  FROM TEST_DB.TB_USER WHERE ID = ?";
            sqlTest.selectUser(selectSql,new Object[]{1});

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List<UserDao> selectUser(String sql, Object[] args) throws SQLException {
        List<UserDao> userDaoList = JDBConnectionUtil.selectResults(sql,args);
        logger.debug("Select Results : " + userDaoList.toString());
        return userDaoList;
    }

    public  Boolean insetUser(String sql, Object[] args) throws SQLException {
        Boolean result = JDBConnectionUtil.insertResults(sql,args);
        logger.debug("Insert Results : " + result);
        return result;
    }
    /*public  List<UserDao> updateUser(String sql, Object[] args) throws SQLException {
        List<UserDao> userDaoList = JDBConnectionUtil.selectResults(sql,args);
        logger.info("Select Results : " + userDaoList.toString());
        return userDaoList;
    }
    public  List<UserDao> deleteUser(String sql, Object[] args) throws SQLException {
        List<UserDao> userDaoList = JDBConnectionUtil.selectResults(sql,args);
        logger.info("Select Results : " + userDaoList.toString());
        return userDaoList;
    }*/
}
