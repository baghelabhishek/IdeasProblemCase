package problem;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * Created by Abhishek on 28/04/18.
 */
public class OutputGeneretorTest {

    private final OutputGeneretor outputGeneretor = new OutputGeneretor();

    @Test
    public void shouldGetOnlyOneServerWhichHaveOldVersion() throws IOException {
        String aString ="Server1, Database, MySQL, 5.5 \n " +
                "Server3, OS, Ubuntu, 10.04 \n" +
                "Server2, Database, MySQL, 5.1";
        Reader inputString = new StringReader(aString);
        BufferedReader inFromUser = new BufferedReader(inputString);
        java.io.FileWriter writer = new java.io.FileWriter("ss");

        Map<String,Version> map = new HashMap<>();
        map.put("Database MySQL",new Version("5.5"));
        map.put("OS Ubuntu",new Version("10.04"));

        List<String> serverList = outputGeneretor.write(inFromUser, new BufferedWriter(writer), map);
        assertThat(serverList, hasSize(1));
        assertThat(serverList,contains("Server2"));
    }

    @Test
    public void shouldReturnEmptyListWhenThereIsNoOldVersion() throws IOException {
        String aString ="Server1, Database, MySQL, 5.5 \n " +
                "Server3, OS, Ubuntu, 10.04 \n" +
                "Server2, Language, Python, 2.6.3";
        Reader inputString = new StringReader(aString);
        BufferedReader inFromUser = new BufferedReader(inputString);
        java.io.FileWriter writer = new java.io.FileWriter("ss");

        Map<String,Version> map = new  HashMap<>();
        map.put("Database MySQL",new Version("5.5"));
        map.put("OS Ubuntu",new Version("10.04"));
        map.put("Language Python",new Version("2.6.3"));

        List<String> serverList = outputGeneretor.write(inFromUser, new BufferedWriter(writer), map);
        assertThat(serverList, hasSize(0));

    }



}