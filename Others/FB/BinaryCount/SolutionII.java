package BinaryCount;

/**
 * Project: Interviews
 * Package: BinaryCount
 * Date: 23/Mar/2015
 * Time: 12:36
 * System Time: 12:36 PM
 */

/*
    From: http://blogs.msdn.com/b/jeuge/archive/2005/06/08/hakmem-bit-count.aspx
 */

public class SolutionII {
    int BitCount(int u)
    {
        int uCount;

        uCount = u - ((u >> 1) & 033333333333) - ((u >> 2) & 011111111111);
        return ((uCount + (uCount >> 3)) & 030707070707) % 63;
    }
}
