package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
         assert new SquareRootResult(2,-3) == equationResolver.resolve(1, 1, -6);
    }

    void testResolveTwoSameRoots() {
        assert new SquareRootResult(-3,-3) == equationResolver.resolve(1, 6, 9);
    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
