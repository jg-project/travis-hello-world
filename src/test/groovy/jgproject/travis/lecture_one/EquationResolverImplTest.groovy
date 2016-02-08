package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert new SquareRootResult(0,4.5) == equationResolver.resolve(2, -9, 0);
    }

    void testResolveTwoSameRoots() {
        assert new SquareRootResult(2,2) == equationResolver.resolve(1, -4, 4);
    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
