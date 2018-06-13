package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by ronnie on 13-Jun-18.
 */
public abstract class Logger {

    public void writeToLog(String Action) {
        Connection conctn = DBConnection.getInstance().getConnection();
        //
        try {
            PreparedStatement statement = conctn.prepareStatement("SELECT ID FROM loggerActionRecord");
            ResultSet rs = statement.executeQuery();
            int maxId = 0;
            while (rs.next()) {
                int userId = Integer.parseInt(rs.getString("ID"));
                if (userId > maxId)
                    maxId = userId;
            }
            statement = conctn.prepareStatement("INSERT INTO loggerActionRecord VALUES(?, ?)");
            statement.setString(1, String.valueOf(maxId + 1));
            statement.setString(2, Action);
            statement.execute();
        } catch (Exception e) {}
    }
}
