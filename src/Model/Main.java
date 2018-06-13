package Model;

import java.sql.*;
import Model.MySystemModel;

public class Main {

    public static void main(String[] args) throws SQLException {

        Model.MySystemModel sm = new Model.MySystemModel();
        PreparedStatement statement = sm.conctn.prepareStatement("INSERT INTO question values(?, ?, ?, ?, ?, ?) ");
        statement.setString(1, "30");
        statement.setString(2, "22222");
        statement.setString(3, "4");
        statement.setString(4, "bbbbbbb");
        statement.setInt(5, 3);
        statement.setString(6, "sss");

        statement.execute();

    }
}
