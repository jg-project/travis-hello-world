package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

public class EquationResolverImpl implements EquationResolver {

    public SquareRootResult resolve(double a, double b, double c) {
        double d = (b * b) - 4 * a * c;
        double x1, x2;

        if (d < 0) {
            return null;
        } else if (d >= 0) {
            x1 = (((-1) * b - Math.sqrt(d))) / (2 * a);
            x2 = (((-1) * b + Math.sqrt(d))) / (2 * a);
            return new SquareRootResult(x1, x2);
        } else {
            x1 = (-1) * b / 2 * a;
            x2 = x1;
            return new SquareRootResult(x1, x2);
        }
    }
}




