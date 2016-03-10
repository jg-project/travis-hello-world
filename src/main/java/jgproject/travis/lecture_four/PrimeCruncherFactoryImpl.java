package jgproject.travis.lecture_four;

/**
 * Created by tcherevyk on 3/1/2016.
 */
public class PrimeCruncherFactoryImpl extends PrimeCruncherFactory {
    @Override
    PrimeCruncher getPrimeCruncher(){
        return new PrimeCruncherImpl();
    }
}
