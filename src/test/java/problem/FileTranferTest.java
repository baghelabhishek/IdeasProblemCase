package problem;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Abhishek on 28/04/18.
 */
public class FileTranferTest {

    private final FileTranfer fileTranfer = new FileTranfer();

    @Test
    public void completeTest() throws IOException {
        File dir = new File(".");
        String source = dir.getCanonicalPath() + File.separator +"src/main/java/"+ "input.txt";
        String dest = dir.getCanonicalPath() + File.separator + "Destination.txt";

        fileTranfer.process(source,dest);


    }

}