package jgproject.travis.lecture_one;

import jgproject.travis.lecture_one.dto.SquareRootResult;

public interface EquationResolver {

    /**
     * Should resolve square equation in real numbers
     * @param a
     * @param b
     * @param c
     * @return null if no roots, otherwise should return result lowest root should be x1, largest - x2.
     */
    SquareRootResult resolve(double a, double b, double c);
}
