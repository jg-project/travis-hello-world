package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }

    void testResolveTwoDifferentRoots() {
        assert equationResolver.resolve(1, 3, -4 ).getX1() == 1;
        assert equationResolver.resolve(1, 3, -4 ).getX2() == -4;
    }

    void testResolveTwoSameRoots() {
       // assert equationResolver.resolve(2, 4, 2 ).getX1() == equationResolver.resolve(2, 4, 2 ).getX2();
        assertEquals(equationResolver.resolve(2, 4, 2 ).getX1(),equationResolver.resolve(2, 4, 2 ).getX2());
    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
