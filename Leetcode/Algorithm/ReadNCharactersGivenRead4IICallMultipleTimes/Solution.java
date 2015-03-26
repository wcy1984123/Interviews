package ReadNCharactersGivenRead4IICallMultipleTimes;

/**
 * Project: Interviews
 * Package: ReadNCharactersGivenRead4IICallMultipleTimes
 * Date: 19/Mar/2015
 * Time: 00:53
 * System Time: 12:53 AM
 */

/*
    The API: int read4(char *buf) reads 4 characters at a time from a file.

    The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

    By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

    Note:
    The read function may be called multiple times.
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    public int bufferindex = 0; // the index starting by reading in the buffer
    public int buffersize = 0; // the actual number of bytes in the buffer
    public char[] buffer = new char[4];

    public int read(char[] buf, int n) {

        if (n == 0) return 0;

        int currentread = 0;

        while (currentread < n) {
            int remainingsize = buffersize - bufferindex;
            int availablesize = Math.min(n - currentread, remainingsize);
            if (availablesize == remainingsize) {
                while (bufferindex < buffersize) buf[currentread++] = buffer[bufferindex++];
                bufferindex = 0;
                buffersize = read4(buffer);
                if (buffersize == 0) break; // no available bytes to read

            } else {
                while (currentread < n) buf[currentread++] = buffer[bufferindex++];
                break; // finish reading n bytes
            }
        }

        return currentread;
    }
}

class Reader4 {
    int read4(char[] buf){
        return 0;
    }
}
