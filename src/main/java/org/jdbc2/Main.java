package org.jdbc2;

import org.jdbc2.config.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        String sql = "SELECT NOW()";
        try(Connection con = datasource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            System.out.println(rs.next() ? rs.getString(1) : null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}