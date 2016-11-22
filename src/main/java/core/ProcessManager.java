package core;

import objects.Box;
import objects.Person;

/**
 * Created by vincent on 22/11/16.
 */
public interface ProcessManager {
    void process(Person person, Box[][] boxes) throws ArrayIndexOutOfBoundsException;
    String getResult();
}
