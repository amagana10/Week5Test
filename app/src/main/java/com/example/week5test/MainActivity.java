package com.example.week5test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* Java program for Merge Sort */

    public static void main(String args[])
    {
        MergeSort ob = new MergeSort();

        int arr[] = {2,8,9,3,4,3,2,6,6,2,4,9,8};

        System.out.println("Input Array");
        printArray(arr);


        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);

        String string = "frog";

        StringList str  = new StringList();
        ArrayList<String> list = str.getStringList(string);

        System.out.println("current string: "+string);
        System.out.println(list);

    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static void printArray(ArrayList<String> arr)
    {
        for (String s : arr) {
            System.out.println(s);
        }

    }

    private static class StringList{

        public ArrayList<String> getStringList(String string) {
            ArrayList<String> list = new ArrayList<>();

            char[] stringChars = string.toCharArray();

            int n = stringChars.length;
            for (int i =1; i<n;i++){
                printCombination(stringChars, n, i,list);

            }
            return list;

        }

        static void combinationUtil(char[] arr, char[] data, int start,
                                    int end, int index, int r, ArrayList<String> list)
        {
            // Current combination is ready to be printed, print it
            if (index == r)
            {
                String s ="";
                for (int j=0; j<r; j++)
                    s= s+data[j]+" ";
                list.add(s);
                return;
            }

            for (int i=start; i<=end && end-i+1 >= r-index; i++)
            {
                data[index] = arr[i];
                combinationUtil(arr, data, i+1, end, index+1, r, list);
            }
        }

        // The main function that prints all combinations of size r
        // in arr[] of size n. This function mainly uses combinationUtil()
        static void printCombination(char[] arr, int n, int r, ArrayList<String> list)
        {
            // A temporary array to store all combination one by one
            char[] data=new char[r];

            // Print all combination using temprary array 'data[]'
            combinationUtil(arr, data, 0, n-1, 0, r,list);
        }

    }





    private static class MergeSort
    {
        void merge(int arr[], int left, int middle, int right)
        {
            // Find sizes of two subarrays to be merged
            int n1 = middle - left + 1;
            int n2 = right - middle;

            /* Create temp arrays */
            int[] LeftArray = new int [n1];
            int[] RightArray = new int [n2];

            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i)
                LeftArray[i] = arr[left + i];
            for (int j=0; j<n2; ++j)
                RightArray[j] = arr[middle + 1+ j];


            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarry array
            int k = left;
            while (i < n1 && j < n2)
            {
                if (LeftArray[i] <= RightArray[j])
                {
                    arr[k] = LeftArray[i];
                    i++;
                }
                else
                {
                    arr[k] = RightArray[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1)
            {
                arr[k] = LeftArray[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2)
            {
                arr[k] = RightArray[j];
                j++;
                k++;
            }
        }

        void sort(int arr[], int left, int right)
        {
            if (left < right)
            {
                // Find the middle point
                int middle = (left+right)/2;

                // Sort first and second halves
                sort(arr, left, middle);
                sort(arr , middle+1, right);

                // Merge the sorted halves
                merge(arr, left, middle, right);
            }
        }
    }


}
