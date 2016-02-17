package jgproject.travis.lecture_four;

public class PrimeCrunchFactoryImpl extends PrimeCruncherFactory {
    @Override
    PrimeCruncher getPrimeCruncher () {
        return new PrimeCruncherImpl ();
    }
}
