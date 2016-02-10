package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert new SquareRootResult(-1,-0.2).equals(equationResolver.resolve(5,6,1));
    }

    void testResolveTwoSameRoots() {
        assert new SquareRootResult(-0.5,-0.5).equals(equationResolver.resolve(4,4,1));

    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
