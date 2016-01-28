package jgproject.travis

class HelloImplTest extends GroovyTestCase {

    Hello hello

    void setUp() {
        hello = new HelloImpl()
    }

    void testGetMessage() {
        assert "Hello World!".equals(hello.getMessage())
    }

    void testGetRandomMessage() {
        def m1 = hello.getRandomMessage()
        def m2 = hello.getRandomMessage()

        assert m1 != null && m1.length() > 0
        assert m2 != null && m2.length() > 0

        assert !m1.equals(m2)
    }
}
