package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert new SquareRootResult(-1,3).equals(equationResolver.resolve(1,-2,-3));
    }

    void testResolveTwoSameRoots() {
        assert new SquareRootResult(-1,-1).equals(equationResolver.resolve(1,2,1));

    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
