package problem;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Abhishek on 28/04/18.
 */
public class VersionTest {


    @Test
    public void shouldGetTheVersionNumber() {
        Version version = new Version("1.2.3");

        assertThat(version.getVersionNumber(), is(123));
    }

    @Test
    public void shouldIgnoreZeroIfItsInFront() {
        Version version = new Version("0.9.8");

        assertThat(version.getVersionNumber(),is(98));
    }

    @Test
    public void shouldTrimStringBeforeConversion() {
        Version version = new Version(" 0.9.8 ");

        assertThat(version.getVersionNumber(),is(98));
    }



}