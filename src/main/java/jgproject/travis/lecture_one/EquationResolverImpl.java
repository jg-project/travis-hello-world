package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

import static java.lang.Math.*;

public class EquationResolverImpl implements EquationResolver {

    public SquareRootResult resolve(double a, double b, double c) {

        SquareRootResult Result = null;
        double D = (b * b - 4 * a * c);

        if (D < 0) Result = null;

        if (D > 0)

        {
            double x1 = ((-1) * b + sqrt(D)) / 2 * a;
            double x2 = ((-1) * b - sqrt(D)) / 2 * a;
            if (x1 > x2)
                Result = new SquareRootResult(x1, x2);
            else Result = new SquareRootResult(x2, x1);
            //
        }

        if (D == 0)
        {
            double x = (-1) * b / 2 * a;
            Result = new SquareRootResult(x, x);
        }

        return Result;
    }
}
