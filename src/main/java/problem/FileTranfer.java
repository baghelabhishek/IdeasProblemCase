package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Abhishek on 28/04/18.
 */
public class FileTranfer {

    private final FileInputOutputCreatable fileInputOutputCreatable = new FileInputOutputCreator();
    private final Software software = new Software();
    private final OutputGeneretor outputGeneretor = new OutputGeneretor();

    public void process(String source,String dest) throws IOException{
        BufferedReader bufferedReader = fileInputOutputCreatable.getBufferedReaderInstance(source);
        BufferedWriter bufferedWriter = fileInputOutputCreatable.getBufferedWriteInstance(dest);

        Map<String, Version> softwareMap = software.getMapWithSoftwareVersion(bufferedReader);

        bufferedReader = fileInputOutputCreatable.getBufferedReaderInstance(source);
        outputGeneretor.write(bufferedReader, bufferedWriter, softwareMap);
    }

}

