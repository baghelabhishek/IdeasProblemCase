package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhishek on 28/04/18.
 */
public class Software {

    public Map<String, Version> getMapWithSoftwareVersion(BufferedReader bufferedReader) throws IOException {
        Map<String, Version> softwareMap = new HashMap<>();
        String aLine = "";

        while ((aLine = bufferedReader.readLine()) != null) {
            String[] split = aLine.split(",");
            Version newVersion = new Version(split[3]);
            String key = split[1] + split[2];
            Version existingVersion = softwareMap.get(key.trim());
            if (existingVersion == null){
                softwareMap.put(key.trim(), newVersion);
            }else if (newVersion.getVersionNumber() > existingVersion.getVersionNumber()){
                softwareMap.put(key.trim(), newVersion);
            }
        }
        return softwareMap;
    }
}
