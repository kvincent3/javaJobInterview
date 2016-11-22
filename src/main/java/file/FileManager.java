package file;

import objects.Box;
import objects.Person;

/**
 * Created by vincent on 22/11/16.
 */
public interface FileManager {

    public Box[][] getInitializedMap(Person person);

    void save(String result);
}
