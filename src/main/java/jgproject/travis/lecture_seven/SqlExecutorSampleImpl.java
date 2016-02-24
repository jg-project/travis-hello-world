package jgproject.travis.lecture_seven;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlExecutorSampleImpl implements SqlExecutor {

    private static final Pattern token = Pattern.compile("(\\:([a-zA-Z0-9]+))");
    private Map<String, Statement> cacheStmt = new HashMap<>();
    private Map<String, PreparedStatement> cachePreparedStmt = new HashMap<>();
    private Map<String, Map<Integer, String>> preparedStmtParams = new HashMap<>();
    private Connection conn;

    public SqlExecutorSampleImpl(Connection conn) {
        this.conn = conn;
    }

    public static Map<Integer, String> mapIndexToString(String sql) {
        Map<Integer, String> result = new TreeMap<>();
        Matcher m = token.matcher(sql);
        int i = 1;
        while (m.find()) {
            result.put(i++, m.group(2));
        }
        return result;
    }

    public static String replaceAllPlaceholders(String sql) {
        return sql.replaceAll(token.pattern(), "?");
    }

    public static void main(String[] args) {
        String sql = "select * form dual where a= :id and b = :b2 and true == false";
        mapIndexToString(sql);
        System.out.println(replaceAllPlaceholders(sql));
    }

    public static void setParameters(PreparedStatement ps, Map<Integer, String> mapping, Map<String, Object> values) {
        try {
            for (int i = 1; i <= mapping.size(); i++) {
                Object x = values.get(mapping.get(i));
                ps.setObject(i, x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet execute(String sql) {
        ResultSet result = null;
        try {
            Statement stmt = cacheStmt.get(sql);
            if (stmt == null) {
                stmt = conn.createStatement();
                cacheStmt.put(sql, stmt);
            }
            if (stmt.execute(sql)) {
                result = stmt.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultSet executePrepared(String sql, Map<String, Object> values) {
        ResultSet result = null;
        try {
            String cleanSql = replaceAllPlaceholders(sql);
            PreparedStatement stmt = cachePreparedStmt.get(cleanSql);
            if (stmt == null) {
                stmt = conn.prepareStatement(cleanSql);
                preparedStmtParams.put(cleanSql, mapIndexToString(sql));
                cachePreparedStmt.put(cleanSql, stmt);
            }
            setParameters(stmt, preparedStmtParams.get(cleanSql), values);
            if (stmt.execute()) {
                result = stmt.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
