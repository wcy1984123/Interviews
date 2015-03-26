package ReadNCharactersGivenRead4;

/**
 * Project: Interviews
 * Package: ReadNCharactersGivenRead4
 * Date: 19/Mar/2015
 * Time: 00:55
 * System Time: 12:55 AM
 */

/*
    The API: int read4(char *buf) reads 4 characters at a time from a file.

    The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

    By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

    Note:
    The read function will only be called once for each test case.
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmpBuf = new char[4];
        int count = read4(tmpBuf);
        int sum = 0;
        while (count > 0 && sum < n) {
            int i = 0;
            while (sum < n && i < count) {
                buf[sum++] = tmpBuf[i++];
            }
            count = read4(tmpBuf);
        }
        return sum;
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}