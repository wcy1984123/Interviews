package FindMinMax;

/**
 * Project: Interviews
 * Package: FindMinMax
 * Date: 15/Mar/2015
 * System Time: 9:45 AM
 */

/*
    Write a function to return minimum and maximum in an array. You program should make minimum number of comparisons.

    There are three methods and 3. Pairwise Solution is the best one
    Minimum Comparison:
        If n is odd:    3*(n-1)/2
        If n is even:   1 Initial comparison for initializing min and max,
                               and 3(n-2)/2 comparisons for rest of the elements
                          =  1 + 3*(n-2)/2 = 3n/2 -2
        Generally, it is (3 * n / 2) -2

    From http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */

class pair {
    int min;
    int max;
}

public class Solution {

    //-------------------------------- 1.Naive Solution ----------------------------------//
    /*
        In this method, total number of comparisons is 1 + 2(n-2) in worst case and 1 + n – 2 in best case.
        In the above implementation, worst case occurs when elements are sorted in descending order.
        Best case occurs when elements are sorted in ascending order.
     */
    pair getMinMaxNaiveVersion(int arr[], int n)
    {
        pair minmax = new pair();
        int i;

        /*If there is only one element then return it as min and max both*/
        if (n == 1)
        {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        /* If there are more than one elements, then initialize min and max*/
        if (arr[0] > arr[1])
        {
            minmax.max = arr[0];
            minmax.min = arr[1];
        }
        else
        {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i<n; i++)
        {
            if (arr[i] >  minmax.max)
                minmax.max = arr[i];

            else if (arr[i] <  minmax.min)
                minmax.min = arr[i];
        }

        return minmax;
    }

    //-------------------------------- 2.Tournament Solution ----------------------------------//
    pair getMinMaxRecursiveVersion(int arr[], int low, int high) // O(nlogn)
    {
        pair minmax = new pair();
        pair mml;
        pair mmr;
        int mid;

        /* If there is only on element */
        if (low == high)
        {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

        /* If there are two elements */
        if (high == low + 1)
        {
            if (arr[low] > arr[high])
            {
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
            else
            {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

        /* If there are more than 2 elements */
        mid = (low + high)/2;
        mml = getMinMaxRecursiveVersion(arr, low, mid);
        mmr = getMinMaxRecursiveVersion(arr, mid + 1, high);

        /* compare minimums of two parts*/
        if (mml.min < mmr.min)
            minmax.min = mml.min;
        else
            minmax.min = mmr.min;

        /* compare maximums of two parts*/
        if (mml.max > mmr.max)
            minmax.max = mml.max;
        else
            minmax.max = mmr.max;

        return minmax;
    }

    //-------------------------------- 3.Pairwise Solution ----------------------------------//
    pair getMinMaxIterativeVersion(int arr[], int n)
    {
        pair minmax = new pair();
        int i;

        /* If array has even number of elements then initialize the first two elements as minimum and maximum */
        if (n%2 == 0)
        {
            if (arr[0] > arr[1])
            {
                minmax.max = arr[0];
                minmax.min = arr[1];
            }
            else
            {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;  /* set the startung index for loop */
        }

        /* If array has odd number of elements then initialize the first element as minimum and maximum */
        else
        {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;  /* set the startung index for loop */
        }

        /* In the while loop, pick elements in pair and compare the pair with max and min so far */
        while (i < n-1)
        {
            if (arr[i] > arr[i+1])
            {
                if(arr[i] > minmax.max)
                    minmax.max = arr[i];
                if(arr[i+1] < minmax.min)
                    minmax.min = arr[i+1];
            }
            else
            {
                if (arr[i+1] > minmax.max)
                    minmax.max = arr[i+1];
                if (arr[i] < minmax.min)
                    minmax.min = arr[i];
            }
            i += 2; /* Increment the index by 2 as two elements are processed in loop */
        }

        return minmax;
    }
}
