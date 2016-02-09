package jgproject.travis;

import java.util.concurrent.ThreadLocalRandom;

public class HelloImpl implements Hello {

    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    @Override
    public String getMessage() {
        return "Hello World!";
    }

    @Override
    public String getRandomMessage() {
        return String.valueOf(rnd.nextLong());
    }
}
