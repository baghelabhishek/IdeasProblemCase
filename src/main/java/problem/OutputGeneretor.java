package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishek on 28/04/18.
 */
public class OutputGeneretor {

    public List<String> write(BufferedReader bufferedReader, BufferedWriter bufferedWriter,
                              Map<String, Version> softwareMap) throws IOException {
        String aLine;
        List<String> serverList = new ArrayList<>();
        while ((aLine = bufferedReader.readLine()) != null) {
            String[] split = aLine.split(",");
            String serverName = split[0];
            Version version = new Version(split[3]);
            String key = split[1] + split[2];
            if (softwareMap.get(key.trim()).getVersionNumber() > version.getVersionNumber()){
                serverList.add(serverName);
                System.out.println(serverName);
                bufferedWriter.write(serverName);
                bufferedWriter.newLine();
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
        return serverList;
    }
}
