/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.beans.Nutrient;
import data.beans.Product;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.NamingException;

import java.util.*;

/**
 *
 * @author dhira
 */
public class Dao {

    private static Dao dao;
    Connection connection;

    public static Map<Integer, Product> productMap = new HashMap<>();
    public static Map<Integer, Nutrient> nutrientMap = new HashMap<>();

    private Dao() {
        InitialContext ic;

        try {
            ic = new InitialContext();
            Context xmlContext = (Context) ic.lookup("java:comp/env");
            DataSource dataSource = (DataSource) xmlContext.lookup("datasource");
            connection = dataSource.getConnection();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Dao getInstance() {
        if (dao == null) {
            dao = new Dao();
        }

        return dao;
    }

}
