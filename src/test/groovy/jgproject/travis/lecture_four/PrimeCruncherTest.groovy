package jgproject.travis.lecture_four

class PrimeCruncherTest extends GroovyTestCase {

    PrimeCruncher cruncher

    void setUp() {
        cruncher = new PrimeCruncherImpl();
    }


    void testIsPrime() {
        List<Long> primes = [2L, 3L, 5L, 7L, 23L, 719L, 5039L, 39916801L, 479001599L, 87178291199L, 10888869450418352160768000001L]

        primes.each {
            assert cruncher.isPrime(it) == true
        }
    }

    void testIsNotPrime() {
        List<Long> primes = [20L, 30L, 50L, 70L, 230L, 7190L, 50390L, 399168010L, 4790015990L, 871782911990L, 108888694504183521607680000010L]

        primes.each {
            assert cruncher.isPrime(it) == false
        }
    }
}
