package com.appforworkwithdb.feature.database;

import com.appforworkwithdb.feature.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
    }

    public void initDb(Database database) {
        try {
            String initDb = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(initDb))
            );
            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
