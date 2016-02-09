package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

public class EquationResolverImpl implements EquationResolver {

    public SquareRootResult resolve(double a, double b, double c) {
        double d;
        double x1;
        double x2;
        d = (b * b) - (4 * a * c);
        if (d < 0) {
            return null;
        } else {
            if (d == 0) {
                x1 = (-b) / (2 * a);
                x2 = x1;
                return new SquareRootResult(x1, x2);
            } else {
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                return new SquareRootResult(x1, x2);
            }
        }
    }
}