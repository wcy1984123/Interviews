package FloatBinarySearchTree;

/**
 * Project: Interviews
 * Package: FloatBinarySearchTree
 * Date: 23/Mar/2015
 * Time: 12:03
 * System Time: 12:03 PM
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    Solution tester = new Solution();

    /**
     * Test cases for Question 1 - reverse string
     */

    @Test
    // normal test cases
    public void testReverseStr1() {
        // String with only one char
        assertTrue("a".equals(Solution.reverseStr("a")));

        // String with two same characters
        assertTrue("cc".equals(Solution.reverseStr("cc")));

        // String with two different characters
        assertTrue("ca".equals(Solution.reverseStr("ac")));

        // palindrome string
        assertTrue("bcacb".equals(Solution.reverseStr("bcacb")));

        // random string
        assertTrue("olleh".equals(Solution.reverseStr("hello")));

        // String with combinations of uppercase and lowercase letters.
        assertTrue("AbCdEfGg".equals(Solution.reverseStr("gGfEdCbA")));

        // random string with trailing space
        assertTrue(" olleh".equals(Solution.reverseStr("hello ")));

        // random string with spaces
        assertTrue(" oll  eh".equals(Solution.reverseStr("he  llo ")));

        // random string with \n
        assertTrue("\n\n oll  eh".equals(Solution.reverseStr("he  llo \n\n")));
        assertTrue("ol\nleh".equals(Solution.reverseStr("hel\nlo")));

        // random string with \t
        assertTrue("\t oll  eh".equals(Solution.reverseStr("he  llo \t")));
        assertTrue("ol\tl  eh".equals(Solution.reverseStr("he  l\tlo")));

        // string with special characters
        assertTrue("c1!@#$%^&*()_+  ".equals(Solution
                .reverseStr("  +_)(*&^%$#@!1c")));

        // string with single quote
        assertTrue("hello 'world'".equals(Solution.reverseStr("'dlrow' olleh")));

        // string with digits
        assertTrue("123456788".equals(Solution.reverseStr("887654321")));
    }

    @Test
    // empty string
    public void testReverseStr2() {
        assertEquals("", Solution.reverseStr(""));
    }

    @Test
    // white spaces
    public void testReverseStr3() {
        assertEquals(" ", Solution.reverseStr(" "));
        // assertNotEquals("     ", Solution.reverseStr(" "));
    }

    @Test
    // input string is null
    public void testReverseStr4() {
        String str = null;
        assertEquals(null, Solution.reverseStr(str));
        // assertNotEquals(" ", Solution.reverseStr(str));
    }

    @Test
    // test cases with white spaces and special characters
    public void testReverseStr5() {
        assertTrue(" olleh".equals(Solution.reverseStr("hello ")));
        assertTrue(" oll  eh".equals(Solution.reverseStr("he  llo ")));
        assertTrue("\n oll  eh  ".equals(Solution.reverseStr("  he  llo \n")));
        assertTrue("\t oll  eh ".equals(Solution.reverseStr(" he  llo \t")));
        assertTrue("ol\tl  eh".equals(Solution.reverseStr("he  l\tlo")));
    }

    @Test
    // String with more than 255 characters
    public void testReverseStr6() {
        String str = " hello world";
        String input = "";
        for (int i = 0; i <= 1000; i++) {
            input += str;
        }
        String strRes = "dlrow olleh ";
        String output = "";
        for (int i = 1000; i >= 0; i--) {
            output += strRes;
        }
        assertTrue(output.equals(Solution.reverseStr(input)));
    }

    /**
     * Test cases for Question 2 - binary search for a sorted array of floating
     * point values
     */

    @Test
    // normal case
    public void testBinarySearchFloatArrayFloat1() {
        float numbers[] = { -1000000f };
        int result = Solution.binarySearch(numbers, -1000000f);
        assertTrue(result == 0);
    }

    @Test
    // array having identical values should always return the same item due to
    // the nature of binary search
    public void testBinarySearchFloatArrayFloat2() {
        float numbers[] = { -1000000f, -1000000f, -1000000f, -1000000f,
                -1000000f, -1000000f, -1000000f, -1000000f, -1000000f,
                -1000000f };
        int ret1 = Solution.binarySearch(numbers, -1000000f);
        int ret2 = Solution.binarySearch(numbers, -1000000f);
        assertTrue(ret1 == ret2);
    }

    @Test
    // array does NOT contain the searched value
    public void testBinarySearchFloatArrayFloat3() {
        float numbers[] = new float[] { -1000000f };
        int result1 = Solution.binarySearch(numbers, -100000f);
        assertTrue(result1 == -1);

        float numbers2[] = new float[] { 1.00000002f, 1.0002f, 1.000200001f,
                1.000200001f, 1.000200001f, 1.0002000010001f };
        int result2 = Solution.binarySearch(numbers2, -1000000f);
        assertTrue(result2 == -1);
    }

    @Test
    // empty array or null array
    public void testBinarySearchFloatArrayFloat4() {
        float numbers1[] = null;
        int result1 = Solution.binarySearch(numbers1, 0f);
        assertTrue(result1 == -1);

        float numbers2[] = {};
        int result2 = Solution.binarySearch(numbers2, 0f);
        assertTrue(result2 == -1);
    }

    @Test
    // Numbers between 1 and 0
    public void testBinarySearchFloatArrayFloat5() {
        float numbers[] = new float[] { 0.000000001000001f, 0.000000001000002f,
                0.000000001000003f, 0.000000001000004f, 0.000000001000005f,
                0.000000001000006f, 0.000000001000006f };
        int result1 = Solution.binarySearch(numbers, 0.000000001000005f);
        assertTrue(result1 == 4);

        int result2 = Solution.binarySearch(numbers, 0.000000001000006f);
        assertTrue(result2 == 5);

        int result3 = Solution.binarySearch(numbers, 0.000000001000007f);
        assertTrue(result3 == -1);
    }

    @Test
    // Numbers between -1 and 0
    public void testBinarySearchFloatArrayFloat6() {
        float numbers[] = new float[] { -0.00000000100003f, -0.00000000100002f,
                -0.00000000100001f };
        int result = Solution.binarySearch(numbers, -0.00000000100003f);
        assertTrue(result == 0);
    }

    @Test
    // Comparisons involving zero
    public void testBinarySearchFloatArrayFloat7() {
        float numbers[] = new float[] { -0.00000001f, 0.0f, 0.00000001f };
        int result = Solution.binarySearch(numbers, 0.0f);
        assertTrue(result == 1);

        int result2 = Solution.binarySearch(numbers, 0.00000001f);
        assertTrue(result2 == 2);

        int result3 = Solution.binarySearch(numbers, -0.00000001f);
        assertTrue(result3 == 0);
    }

    @Test
    // Very interesting case where all numbers in the array are extremely close.
    // In this case, Java fails itself because Java truncates the float value
    // automatically. E.g., 1.00200001f is actually stored as 1.002f in Java.
    // Thus, the binary search fails to find the number at the correct position.
    public void testBinarySearchFloatArrayFloat8() {
        float numbers[] = new float[] { 1.00000002f, 1.0002f, 1.000200001f,
                1.000200001f, 1.0002000011f, 1.0002000010001f };
        int result1 = Solution.binarySearch(numbers, 1.0002f);
        int result2 = Solution.binarySearch(numbers, 1.0002000011f);
        assertFalse(result1 == 1);
        assertFalse(result2 == 4);

        // show case where two floats are identical in Java
        float f1 = 1.000200001f;
        float f2 = 1.0002f;
        assertTrue(f1 == f2);
    }

    @Test
    // array with infinity
    public void testBinarySearchFloatArrayFloat9() {
        float numbers1[] = { Float.NEGATIVE_INFINITY, -1000000f,
                Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
        assertTrue(Solution.binarySearch(numbers1, -1000000f) == 1);

        float numbers2[] = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY,
                0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
        assertTrue(Solution.binarySearch(numbers2, 0f) == 2);
        assertTrue(Solution.binarySearch(numbers2, Float.NEGATIVE_INFINITY) == 0);
        assertTrue(Solution.binarySearch(numbers2, Float.POSITIVE_INFINITY) == 3);
    }

    @Test
    // array including infinities and MaxValue
    public void testBinarySearchFloatArrayFloat10() {
        float numbers[] = { Float.NEGATIVE_INFINITY, -1000000f, Float.MAX_VALUE };
        assertTrue(Solution.binarySearch(numbers, -1000000f) == 1);
        assertTrue(Solution.binarySearch(numbers, -Float.MAX_VALUE) == -1);
        assertTrue(Solution.binarySearch(numbers, Float.MAX_VALUE) == 2);
    }

    @Test
    // array including infinities and MinValue
    public void testBinarySearchFloatArrayFloat11() {
        float numbers[] = { Float.NEGATIVE_INFINITY, -1000000f, -0f,
                Float.MIN_VALUE, 100f, 1000f, Float.MAX_VALUE,
                Float.POSITIVE_INFINITY };
        assertTrue(Solution.binarySearch(numbers, -1000000f) == 1);
        assertTrue(Solution.binarySearch(numbers, -Float.MAX_VALUE) == -1);
        assertTrue(Solution.binarySearch(numbers, Float.MAX_VALUE) == 6);
    }

    @Test
    // array including negative and some calculations
    public void testBinarySearchFloatArrayFloat12() {
        float numbers[] = { 10000 * -Float.MIN_VALUE, 10000 * Float.MIN_VALUE,
                10000 * Float.MAX_VALUE };
        assertTrue(Solution.binarySearch(numbers, 10000 * -Float.MIN_VALUE) == 0);
        assertTrue(Solution.binarySearch(numbers, 10000 * Float.MIN_VALUE) == 1);
        assertTrue(Solution.binarySearch(numbers, 10000 * Float.MAX_VALUE) == 2);
    }

    @Test
    // array including numbers very close to zero
    public void testBinarySearchFloatArrayFloat13() {
        float numbers[] = { -0.000000001f, -Float.MIN_VALUE, 0f,
                Float.MIN_VALUE, Float.MAX_VALUE };
        assertTrue(Solution.binarySearch(numbers, -0.000000001f) == 0);
        assertTrue(Solution.binarySearch(numbers, -Float.MIN_VALUE) == 1);
        assertTrue(Solution.binarySearch(numbers, 0f) == 2);
        assertTrue(Solution.binarySearch(numbers, Float.MIN_VALUE) == 3);
    }

    @Test
    // array including regular large numbers
    public void testBinarySearchFloatArrayFloat14() {
        float numbers[] = { 10f, 100f, 101f, 1000f, 10000f, 100001f, 1000000f };
        assertTrue(Solution.binarySearch(numbers, 10f) == 0);
        assertTrue(Solution.binarySearch(numbers, 100f) == 1);
        assertTrue(Solution.binarySearch(numbers, 101f) == 2);
        assertTrue(Solution.binarySearch(numbers, 1000f) == 3);
        assertTrue(Solution.binarySearch(numbers, 100001f) == 5);
    }

    @Test
    // negative large numbers
    public void testBinarySearchFloatArrayFloat15() {
        float numbers[] = { -1000000f, -100001f, -10000f, -1000f, -101f, -100f,
                -10f };
        assertTrue(Solution.binarySearch(numbers, -1000000f) == 0);
        assertTrue(Solution.binarySearch(numbers, -100001f) == 1);
        assertTrue(Solution.binarySearch(numbers, -10000f) == 2);
        assertTrue(Solution.binarySearch(numbers, -1000f) == 3);
        assertTrue(Solution.binarySearch(numbers, -100f) == 5);
    }

    @Test
    // array with a Float.NaN
    public void testBinarySearchFloatArrayFloat16() {
        float numbers1[] = { Float.NaN };
        int result1 = Solution.binarySearch(numbers1, Float.NaN);
        assertTrue(result1 == 0);
    }

    /**
     * Test cases for Question 2 extra point - binary search for a generic
     * sorted array point values
     */

    @Test
    // array of type Integer
    public void testGenericBinarySearch1() {
        Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6 };
        int result1 = Solution.genericBinarySearch(array, 2);
        assertTrue(result1 == 1);
        int result2 = Solution.genericBinarySearch(array, 0);
        assertTrue(result2 == -1);
        Integer[] empty = new Integer[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, 0));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, 0));
    }

    @Test
    // array of type Double
    public void testGenericBinarySearch2() {
        Double[] array = new Double[] { 1.2, 2.3, 3.4, 4.5, 5.6, 6.0 };
        int result1 = Solution.genericBinarySearch(array, 2.3);
        assertTrue(result1 == 1);
        int result2 = Solution.genericBinarySearch(array, 3.3);
        assertTrue(result2 == -1);
        Double[] empty = new Double[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, 2.0));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, 1.0));
    }

    @Test
    // array of type Long
    public void testGenericBinarySearch3() {
        Long[] array = new Long[] { 6L, 8L };
        int result1 = Solution.genericBinarySearch(array, 6L);
        assertTrue(result1 == 0);
        int result2 = Solution.genericBinarySearch(array, 9L);
        assertTrue(result2 == -1);
        Long[] empty = new Long[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, 13L));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, 13L));
    }

    @Test
    // array of type Char
    public void testGenericBinarySearch4() {
        Character[] array = new Character[] { 'a', 'b' };
        int result1 = Solution.genericBinarySearch(array, 'a');
        assertTrue(result1 == 0);
        int result2 = Solution.genericBinarySearch(array, 'c');
        assertTrue(result2 == -1);
        Character[] empty = new Character[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, 'a'));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, 'a'));
    }

    @Test
    // array of type Byte
    public void testGenericBinarySearch5() {
        Byte[] array = new Byte[] { 6, 127 };
        int result1 = Solution.genericBinarySearch(array, (byte) 6);
        assertTrue(result1 == 0);
        int result2 = Solution.genericBinarySearch(array, Byte.MAX_VALUE);
        assertTrue(result2 == 1);
        int result3 = Solution.genericBinarySearch(array, (byte) 10);
        assertTrue(result3 == -1);
        Byte[] empty = new Byte[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, (byte) 2));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, (byte) 2));
    }

    @Test
    // array of type Short
    public void testGenericBinarySearch6() {
        Short[] array = new Short[] { -100, -20, -3, -1, 0, 100, 1000 };
        assertTrue((int) Solution.genericBinarySearch(array, (short) -20) == 1);
        assertTrue((int) Solution.genericBinarySearch(array, (short) -3) == 2);
        assertTrue((int) Solution.genericBinarySearch(array, (short) 0) == 4);
        assertTrue((int) Solution.genericBinarySearch(array, (short) 100) == 5);
        Short[] empty = new Short[] {};
        assertEquals(-1, Solution.genericBinarySearch(empty, (short) 0));
        empty = null;
        assertEquals(-1, Solution.genericBinarySearch(empty, (short) 0));
    }
}
