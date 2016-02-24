package jgproject.travis.lecture_seven;

import java.sql.ResultSet;
import java.util.Map;

public interface SqlExecutor {

    ResultSet execute(String sql);

    ResultSet executePrepared(String sql, Map<String, Object> values);
}
