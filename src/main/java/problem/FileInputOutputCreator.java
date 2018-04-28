package problem;

import java.io.*;

/**
 * Created by Abhishek on 28/04/18.
 */
public class FileInputOutputCreator implements FileInputOutputCreatable {

    public BufferedReader getBufferedReaderInstance(String sourceFile) throws FileNotFoundException {
        File file = new File(sourceFile);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new BufferedReader(new InputStreamReader(fileInputStream));
    }

    public BufferedWriter getBufferedWriteInstance(String destinationFile) throws IOException {
        FileWriter fstream = new FileWriter(destinationFile, true);
        BufferedWriter out = new BufferedWriter(fstream);
        return new BufferedWriter(fstream);
    }
}
