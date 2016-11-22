import core.ProcessManager;
import core.ProcessManagerImpl;
import file.FileManager;
import file.FileManagerImpl;
import objects.Box;
import objects.Person;

/**
 * Created by vincent on 22/11/16.
 */
public class Main {

    public static void main (String[] args) {
        FileManager fileManager = new FileManagerImpl();
        Person person = new Person();
        ProcessManager processManager = new ProcessManagerImpl();
        try {
            Box[][] boxes = fileManager.getInitializedMap(person);
            processManager.process(person, boxes);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("You are outside the boxes or input file malformed");
        } finally {
            fileManager.save(processManager.getResult());
        }

    }
}
