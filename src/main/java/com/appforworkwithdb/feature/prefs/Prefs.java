package com.appforworkwithdb.feature.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prefs {
    public static final String JDBC_CONNECTION_URL = "jdbcUrl";
    public static final String INIT_DB_SQL_FILE_PATH = "initDBSQL";
    public static final String POPULATE_DB_SQL_FILE_PATH = "populateDB";
    public static final String FIND_LONGEST_PROJECT_FILE_PATH = "findLongestProject";
    public static final String FIND_MAX_PROJECTS_CLIENT_FILE_PATH = "findMaxProject";
    public static final String FIND_MAX_SALARY_WORKER_FILE_PATH = "findMaxSalary";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH = "findYoungestEldest";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Objects> prefs = new HashMap<>();

    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));
            TypeToken<?> typeToken = TypeToken.getParameterized(Map.class, String.class, Object.class);
            prefs = new Gson().fromJson(json, typeToken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }

}
