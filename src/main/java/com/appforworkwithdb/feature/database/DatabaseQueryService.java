package com.appforworkwithdb.feature.database;

import com.appforworkwithdb.feature.data.RequestForLongestProject;
import com.appforworkwithdb.feature.data.RequestForMaxProjectsClient;
import com.appforworkwithdb.feature.data.RequestForMaxSalaryWorker;
import com.appforworkwithdb.feature.data.RequestForYoungestEldestWorkers;
import com.appforworkwithdb.feature.prefs.Prefs;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<RequestForLongestProject> findLongestProject(Database database) {
        List<RequestForLongestProject> projectList = new ArrayList<>();
        try {
            String findProject = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findProject))
            );
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                projectList.add(new RequestForLongestProject(
                        resultSet.getString("name"),
                        resultSet.getInt("MONTH_COUNT")));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectList;
    }

    public List<RequestForMaxProjectsClient> findMaxProjectsClient(Database database) {
        List<RequestForMaxProjectsClient> projectsClients = new ArrayList<>();
        try {
            String findClientProject = new Prefs().getString(Prefs.FIND_MAX_PROJECTS_CLIENT_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findClientProject))
            );
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                projectsClients.add(new RequestForMaxProjectsClient(
                        resultSet.getString("name"),
                        resultSet.getInt("NUM_PROJECTS")));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectsClients;
    }

    public List<RequestForMaxSalaryWorker> findMaxSalaryWorker(Database database) {
        List<RequestForMaxSalaryWorker> salaryWorkers = new ArrayList<>();
        try {
            String findMaxSalary = new Prefs().getString(Prefs.FIND_MAX_SALARY_WORKER_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findMaxSalary))
            );
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                salaryWorkers.add(new RequestForMaxSalaryWorker(
                        resultSet.getString("name"),
                        resultSet.getInt("salary")));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salaryWorkers;
    }

    public List<RequestForYoungestEldestWorkers> findYoungestEldestWorkers(Database database) {
        List<RequestForYoungestEldestWorkers> eldestWorkers = new ArrayList<>();
        try {
            String youngestEldest = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(youngestEldest))
            );
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                eldestWorkers.add(new RequestForYoungestEldestWorkers(
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        LocalDate.parse(resultSet.getString("birthday"))
                ));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eldestWorkers;
    }
}
