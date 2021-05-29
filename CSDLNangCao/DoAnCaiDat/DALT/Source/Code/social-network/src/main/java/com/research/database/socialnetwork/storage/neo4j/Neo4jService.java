package com.research.database.socialnetwork.storage.neo4j;

import com.research.database.socialnetwork.config.DBHostConfig;
import com.research.database.socialnetwork.utils.SuggestCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@DependsOn({"DBHostConfig"})
public class Neo4jService {
    private Connection conn = null;

    public Neo4jService(DBHostConfig config) throws SQLException {
        conn = DriverManager.getConnection(config.getNeo4jConnectionString());
    }

    public void insertFriend(int id1, int id2) {
        try {
            Statement stmt = conn.createStatement();
            String exe = String.format("MERGE (u1:User {id: %s})" +
                            " MERGE (u2:User {id:%s}) " +
                            " CREATE (u1)-[:FRIEND]->(u2) " +
                            " CREATE (u2)-[:FRIEND]->(u1)",
                    id1, id2);
            stmt.execute(exe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertGen(Integer userId, String generation) {
        try {
            Statement stmt = conn.createStatement();
            String exe = String.format("MERGE (u1:User {id: %s})" +
                            " MERGE (g:GEN {name:'%s'}) " +
                            " CREATE (u1)-[:BORN]->(g) ",
                    userId, generation);
            stmt.execute(exe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertAddress(Integer userId, String city) {
        try {
            Statement stmt = conn.createStatement();
            String exe = String.format("MERGE (u1:User {id: %s})" +
                            " MERGE (g:CITY {name:'%s'}) " +
                            " CREATE (u1)-[:IN]->(g) ",
                    userId, city);
            stmt.execute(exe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Integer> suggestFriendIds(int userId, SuggestCriteria cri) {
        StringBuilder query = new StringBuilder(String.format("MATCH (n:User{id: %s}) ", userId));
        if (cri.getFriendDepth() > 0) {
            query.append(String.format("MATCH (n)-[:FRIEND * %d]-(m) ", cri.getFriendDepth()));
        }
        if (cri.getGeneration() != null && !cri.getGeneration().isEmpty()) {
            query.append(String.format("MATCH (m)-[:BORN]->(g:GEN{name:'%s'}) ", cri.getGeneration()));
        }
        if (cri.getCity() != null && !cri.getCity().isEmpty()) {
            query.append(String.format("MATCH (m)-[:IN]->(c:CITY{name:'%s'}) ", cri.getCity()));
        }
        query.append("WHERE NOT (n)-[:FRIEND]-(m) ");
        query.append("RETURN DISTINCT m.id");
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query.toString());
            List<Integer> ids = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("m.id");
                ids.add(id);
            }
            return ids;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}
