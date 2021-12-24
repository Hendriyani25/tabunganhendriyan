/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabunganhendrian.helper;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class SQLiteHelper {
    private static final String driverClass = "org.sqlite.JDBC";
    private static final String programsFolderPath = Paths.get(
            System.getProperty("user.home"),
            "tabunganhendriyan"
    ).toString();
    private static final String databasePath = Paths.get(
            programsFolderPath,
            "database.db"
    ).toString();

    private static SQLiteHelper instance;

    public static SQLiteHelper getInstance() {
        if (instance == null) {
            instance = new SQLiteHelper();
        }

        return instance;
    }

    public Connection getConnection() {
        File appDir = new File(programsFolderPath);
        
        if (!appDir.exists() || !appDir.isDirectory()) appDir.mkdirs();
            
        try {
            Class.forName(driverClass);

            return DriverManager.getConnection("jdbc:sqlite:" + databasePath);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
