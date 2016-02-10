package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert new SquareRootResult(-2.0, -1.0) == equationResolver.resolve(2, 6, 4)

    }

    void testResolveTwoSameRoots() {
        assert  new SquareRootResult(-1.0, -1.0) == equationResolver.resolve(1, 2, 1)

    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(2, 4, 4);
    }
}
