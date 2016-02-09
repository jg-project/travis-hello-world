package jgproject.travis.lecture_one

import jgproject.travis.lecture_one.dto.SquareRootResult

class EquationResolverImplTest extends GroovyTestCase {

    EquationResolver equationResolver;

    @Override
    protected void setUp() throws Exception {
        equationResolver = new EquationResolverImpl();
    }



    void testResolveTwoDifferentRoots() {

        SquareRootResult test1 = equationResolver.resolve(2, 5, -3);
        assert test1 != null;
        assert test1.x1>test1.x2;
        //
    }

    void testResolveTwoSameRoots() {
        SquareRootResult test1 = equationResolver.resolve(9, -12, 4);
        assert test1 != null;
        assert test1.x1==test1.x2;

    }

    void testResolveNoRoot() {
        assert null == equationResolver.resolve(10, -4, 4);
    }
}
