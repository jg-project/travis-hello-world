package jgproject.travis.lecture_four;

public class divCheck {
    public static boolean iDivide ( long number ) {
        for ( long i = 2 ; i <= Math.sqrt ( number ) ; i++ ) {
            if ( number % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}

