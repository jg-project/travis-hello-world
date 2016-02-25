package jgproject.travis.lecture_seven

import groovy.sql.Sql

class SqlFun extends GroovyTestCase {

    static {
        def db = Sql.newInstance('jdbc:hsqldb:db/sample', 'sa', '', 'org.hsqldb.jdbcDriver')
        db.execute """
            CREATE TABLE books (
                book_id INTEGER PRIMARY KEY,
                author_id INTEGER,
                publisher_id INTEGER,
                title VARCHAR(100)
            );"""

        db.execute """
            CREATE TABLE authors (
                author_id INTEGER PRIMARY KEY,
                first_name VARCHAR(100),
                last_name VARCHAR(100)
            );"""

        db.execute """
            CREATE TABLE publishers (
                publisher_id INTEGER PRIMARY KEY,
                name VARCHAR(100)
            );"""
    }

    Sql db

    void setUp() {
        db = Sql.newInstance('jdbc:hsqldb:db/sample', 'sa', '', 'org.hsqldb.jdbcDriver')
        db.executeUpdate('delete from books')
        db.executeUpdate('delete from authors')
        db.executeUpdate('delete from publishers')

        db.dataSet('publishers').with {
            it.add PUBLISHER_ID: 1, NAME: 'Adisson'
            it.add PUBLISHER_ID: 2, NAME: 'Wesley'
            it.add PUBLISHER_ID: 3, NAME: 'Pakt'
        }

        db.dataSet('authors').with {
            it.add author_id: 1, FIRST_NAME: 'Kreg', LAST_NAME: 'Larson'
            it.add author_id: 2, FIRST_NAME: 'Petty', LAST_NAME: 'Smith'
            it.add author_id: 3, FIRST_NAME: 'Aaron', LAST_NAME: 'Baser'
        }

        db.dataSet('books').with {
            it.add book_id: 1, AUTHOR_ID: 1, PUBLISHER_ID: 1, TITLE: 'DB magic'
            it.add book_id: 2, AUTHOR_ID: 2, PUBLISHER_ID: 1, TITLE: 'Java for genius'
            it.add book_id: 3, AUTHOR_ID: 1, PUBLISHER_ID: 2, TITLE: 'IoC for the chosen one'
            it.add book_id: 4, AUTHOR_ID: 3, PUBLISHER_ID: 1, TITLE: 'Algebra for physics'
            it.add book_id: 5, AUTHOR_ID: 1, PUBLISHER_ID: 1, TITLE: 'Hammers for nails'
            it.add book_id: 6, AUTHOR_ID: 2, PUBLISHER_ID: 3, TITLE: 'Drums for N in bus'
            it.add book_id: 7, AUTHOR_ID: 1, PUBLISHER_ID: 3, TITLE: 'Groovy and others'
        }
    }

    void testDbIsAccessible() {

        assert db.rows("select count(1) as cnt from books") == [[CNT: 7]]

        assert db.rows("select count(1) as cnt from authors") == [[CNT: 3]]

        assert db.rows("select count(1) as cnt from publishers") == [[CNT: 3]]
    }

    void testAuthorsAreCorrectForPublisher3() {
        assert db.rows("""
select FIRST_NAME, LAST_NAME from AUTHORS A, BOOKS B
where A.AUTHOR_ID = B.AUTHOR_ID AND PUBLISHER_ID = 3
""") == [
                [FIRST_NAME: 'Kreg', LAST_NAME: 'Larson'],
                [FIRST_NAME: 'Petty', LAST_NAME: 'Smith']
        ]
    }

    void testTitlesAreCorrectForAuthor1and2() {
        assert db.rows("""
select TITLE from books
where AUTHOR_ID = 1 OR AUTHOR_ID = 2
""") == [
                [TITLE: 'DB magic'],
                [TITLE: 'Java for genius'],
                [TITLE: 'IoC for the chosen one'],
                [TITLE: 'Hammers for nails'],
                [TITLE: 'Drums for N in bus'],
                [TITLE: 'Groovy and others']
        ]
    }

    void testNothing() {
        println db.rows("""
select FIRST_NAME, LAST_NAME from authors
""")
    }

    //SCROLL down to see the SQLs.

}

/*select title
from books b
where b.author_id in (1,2)


select FIRST_NAME, LAST_NAME
from authors a, books b
where a.author_id = b.author_id
and publisher_id = 3
 */