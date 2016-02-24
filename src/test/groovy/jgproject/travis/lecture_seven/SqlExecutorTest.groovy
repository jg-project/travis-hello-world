package jgproject.travis.lecture_seven

import org.apache.tomcat.jdbc.pool.DataSource
import org.apache.tomcat.jdbc.pool.PoolProperties

import java.sql.Connection
import java.sql.ResultSet

class SqlExecutorTest extends GroovyTestCase {

    private static final String CONNECTION_STRING = "jdbc:hsqldb:mem:testdb;shutdown=false";
    private static final String USER_NAME = "SA";
    private static final String PASSWORD = "";
    public static final String DRIVER_CLASSNAME = "org.hsqldb.jdbcDriver"

    DataSource ds

    SqlExecutor executor

    @Override
    protected void setUp() throws Exception {
        ds = createDs()
        executor = new SqlExecutorSampleImpl(ds.getConnection())
    }

    DataSource createDs() {
        PoolProperties properties = new PoolProperties(
                url: CONNECTION_STRING,
                username: USER_NAME,
                password: PASSWORD,
                driverClassName: DRIVER_CLASSNAME,
                defaultAutoCommit: true
        )
        return new DataSource(properties)
    }


    Connection getConnection() {
        return ds.getConnection()
    }

    void testExecute() {
        executor.execute("create table foo (num integer)")
        executor.execute("insert into foo values (100)")
        executor.execute("insert into foo values (200)")
        executor.execute("insert into foo values (300)")
        ResultSet rs = executor.execute("select count(1) as cnt from foo")
        int cnt = 0
        while (rs.next()) {
            assert 3 == rs.getInt("cnt")
            cnt++
        }

        assert cnt == 1

    }

    void testExecutePrepared() {
        executor.execute("create table MYTABLE (num integer)")
        executor.executePrepared("insert into MYTABLE values (:num)", [num: 100])
        executor.executePrepared("insert into MYTABLE values (:num)", [num: 200])
        executor.executePrepared("insert into MYTABLE values (:num)", [num: 300])
        ResultSet rs = executor.execute("SELECT count(1) as cnt FROM MYTABLE")
        int cnt = 0
        while (rs.next()) {
            assert 3 == rs.getInt("cnt")
            cnt++
        }

        assert cnt == 1
    }


}
