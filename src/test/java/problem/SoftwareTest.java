package problem;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Abhishek on 28/04/18.
 */
public class SoftwareTest {

    private static final String KEY_1 = "Database MySQL";
    private static final String KEY_2 = "OS Ubuntu";
    private final Software software = new Software();

    @Test
    public void shouldGetVersionMap() throws IOException {
        String aString ="Server1, Database, MySQL, 5.5";
        Reader inputString = new StringReader(aString);
        BufferedReader inFromUser = new BufferedReader(inputString);

        Map<String, Version> mapWithSoftwareVersion = software.getMapWithSoftwareVersion(inFromUser);
        Version version = mapWithSoftwareVersion.get("Database MySQL");
        assertThat(mapWithSoftwareVersion,hasKey(KEY_1));
        assertThat(version.getVersionNumber(), is(55));
    }

    @Test
    public void shouldNotAddVersionWhenVersionNumberIsLow() throws IOException {
        String aString ="Server1, Database, MySQL, 5.5 \n " +
                "Server2, Database, MySQL, 5.2 \n" +
                "erver2, Database, MySQL, 5.1";
        Reader inputString = new StringReader(aString);
        BufferedReader inFromUser = new BufferedReader(inputString);

        Map<String, Version> mapWithSoftwareVersion = software.getMapWithSoftwareVersion(inFromUser);

        assertThat(mapWithSoftwareVersion.size(),is(1));
        assertThat(mapWithSoftwareVersion, hasKey(KEY_1));
        assertThat(mapWithSoftwareVersion.get("Database MySQL").getVersionNumber(),is(55));
    }

    @Test
    public void shouldAddMultipleKeyInMapInCaseOfDifferntInput() throws IOException {
        String aString ="Server1, Database, MySQL, 5.5 \n " +
                "Server3, OS, Ubuntu, 10.04 \n" +
                "erver2, Database, MySQL, 5.1";
        Reader inputString = new StringReader(aString);
        BufferedReader inFromUser = new BufferedReader(inputString);

        Map<String, Version> mapWithSoftwareVersion = software.getMapWithSoftwareVersion(inFromUser);

        assertThat(mapWithSoftwareVersion,hasKey(KEY_1));
        assertThat(mapWithSoftwareVersion,hasKey(KEY_2));
        assertThat(mapWithSoftwareVersion.get(KEY_1).getVersionNumber(),is(55));
        assertThat(mapWithSoftwareVersion.get(KEY_2).getVersionNumber(),is(1004));
    }

}