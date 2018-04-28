package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Abhishek on 28/04/18.
 */
public interface FileInputOutputCreatable {

    BufferedReader getBufferedReaderInstance(String sourceFile) throws FileNotFoundException;

    BufferedWriter getBufferedWriteInstance(String destinationFile) throws IOException;
}
