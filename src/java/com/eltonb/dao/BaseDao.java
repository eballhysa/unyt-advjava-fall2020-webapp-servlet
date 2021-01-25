/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eltonb.dao;

import com.eltonb.model.Department;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author elton.ballhysa
 */
public class BaseDao {
    
    private Properties properties;
    
    public BaseDao() {
        properties = new Properties();
        try (InputStream is = BaseDao.class.getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.pass")
        );
    }
    
}
