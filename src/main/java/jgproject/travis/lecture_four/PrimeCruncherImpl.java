package jgproject.travis.lecture_four;

public class PrimeCruncherImpl implements PrimeCruncher {
    @Override
    public boolean isPrime ( long test ) {
        return divCheck.iDivide (test);
    }
}
