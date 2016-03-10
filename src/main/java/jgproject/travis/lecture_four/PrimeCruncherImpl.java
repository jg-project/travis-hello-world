package jgproject.travis.lecture_four;

/**
 * Created by tcherevyk on 2/23/2016.
 */
public class PrimeCruncherImpl implements PrimeCruncher {

    @Override
    public boolean isPrime(long test) {
        long i = 2;
        boolean result = true;
        while (result && (i <= Math.sqrt(test))) {
            if (test % i == 0)
               result = false;
               i++;
            }
        return result;
    }
}
