package jgproject.travis.lecture_four;


public class PrimeCruncherImp implements PrimeCruncher{


    @Override
    public boolean isPrime(long test) {

        for (long i=2;i <= Math.sqrt(test);i++) {
                if (test % i == 0) {
                    return false;
                }
            }
        return true;
        }

    }


?