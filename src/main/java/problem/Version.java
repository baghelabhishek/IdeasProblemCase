package problem;

import java.util.Objects;

/**
 * Created by Abhishek on 28/04/18.
 */
public class Version {

    private final int versionNumber;

    public Version(String version) {
        String finalVersion = version.replace(".", "").trim();
        this.versionNumber = Integer.parseInt(finalVersion);
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Version)) {
            return false;
        }

        Version version = (Version) obj;
        return versionNumber == version.versionNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionNumber);
    }
}
