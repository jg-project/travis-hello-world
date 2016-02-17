package jgproject.travis.lecture_four;

import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

/**
 * Created by rfilipchak on 2/17/2016.
 */
public class PrimeCruncherFactoryImp extends PrimeCruncherFactory {

    @Override
    PrimeCruncher getPrimeCruncher() {
         return new PrimeCruncherImp();
    }
}
