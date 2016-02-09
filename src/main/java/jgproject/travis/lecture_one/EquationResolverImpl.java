package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

public class EquationResolverImpl implements EquationResolver {

    public SquareRootResult resolve(double a, double b, double c) {
        double root1, root2;
        double D = b*b-4*a*c;
        if (D == 0) {
           root1 = -b/(2*a);
           root2 = root1;
        }
        else if (D>0) {
            root1 = (-b - Math.sqrt(D))/(2*a);
            root2 = (-b + Math.sqrt(D))/(2*a);
        }
        else {
            return null;
        }
        return new SquareRootResult(root1, root2);
    }
}
