package jgproject.travis.lecture_four;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PrimeCrunchFactoryImplTest {

    PrimeCruncherFactory primeCruncherFactory;

    ThreadsEverywhere cruncher;

    ExecutorService executor;

    @Before
    public void setUp () {
        primeCruncherFactory = new PrimeCrunchFactoryImpl ( );

        int threadNumbers = Runtime.getRuntime ( ).availableProcessors ( );
        executor = Executors.newFixedThreadPool ( threadNumbers );

        cruncher = new ThreadsEverywhere ( executor, primeCruncherFactory, threadNumbers );
    }

    @Test
    public void testCheckCruncher () throws InterruptedException {
        cruncher.crunchIt ( 1000, 10000 );
    }


}