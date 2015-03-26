package CompareVersionNumbers;

/**
 * Project: Interviews
 * Package: CompareVersionNumbers
 * Date: 19/Mar/2015
 * Time: 00:38
 * System Time: 12:38 AM
 */

/*
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

    You may assume that the version strings are non-empty and contain only digits and the . character.
    The . character does not represent a decimal point and is used to separate number sequences.
    For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

    Here is an example of version numbers ordering:

    0.1 < 1.1 < 1.2 < 13.37
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null) return (version2 == null || version2.length() == 0) ? 0 : -1;
        if (version2 == null || version2.length() == 0) return 1;

        String[] versionarray1 = version1.split("\\.");
        String[] versionarray2 = version2.split("\\.");
        int versionlength1 = versionarray1.length;
        int versionlength2 = versionarray2.length;

        int length = Math.min(versionlength1, versionlength2);

        // compare with two arrays with the same length
        for (int i = 0; i < length; i++) {
            int integer1 = Integer.parseInt(versionarray1[i]);
            int integer2 = Integer.parseInt(versionarray2[i]);
            if (integer1 != integer2) return integer1 > integer2 ? 1 : -1;
        }

        // deal with the last values in the longer array
        if (versionlength1 != versionlength2) {
            String[] versionarray = versionlength1 > versionlength2 ? versionarray1 : versionarray2;

            for (int i = length; i < versionarray.length; i++) {
                if (Integer.parseInt(versionarray[i]) != 0) return versionlength1 > versionlength2 ? 1 : -1;
            }
        }

        return 0;
    }
}
