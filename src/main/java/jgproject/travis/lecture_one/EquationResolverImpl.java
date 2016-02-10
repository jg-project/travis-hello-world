package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

public class EquationResolverImpl implements EquationResolver {

    public SquareRootResult resolve(double a, double b, double c) {
        if(a != 0 && b != 0 && c !=0){
            double D = Math.pow(b, 2) - 4 * a * c;
            if (D < 0) {
                return null;
            } else {
                return new SquareRootResult((-b + Math.sqrt(D)) / (2 * a), (-b - Math.sqrt(D)) / (2 * a));
            }
        }else{
            return null;
        }
    }
}
