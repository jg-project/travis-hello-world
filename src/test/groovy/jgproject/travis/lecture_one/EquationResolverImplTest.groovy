package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert equationResolver.resolve(3,-8,-93).x1 != equationResolver.resolve(3,-8,-93).x2;
    }

    void testResolveTwoSameRoots() {
        assert equationResolver.resolve(4,4,1).x1 == equationResolver.resolve(4,4,1).x2;
    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
