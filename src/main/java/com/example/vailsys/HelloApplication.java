package com.example.vailsys;

import java.util.Arrays;

public class HelloApplication {


    public static void main(String[] args) throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        rotate(numbers, 8);
        System.out.println(Arrays.toString(numbers));
    }

    /*
    This function to rotate array of size by given rotate number
     */
    public static int[] rotate(int[] arr, int rotateNumber) throws Exception {
        if (rotateNumber < 1) {
            /*
            I wasn't sure what it's mean on throwing an error
            which the code example should handle gracefully.
            But hopefully throwing Exception with right message is enough :)
            */
            throw new Exception("Rotating number: " + rotateNumber + "should be positive number");
        } else {
            if (arr.length == 1 | rotateNumber == 1) return arr;
            else {

                /* in case rotate number bigger than array length */
                rotateNumber = rotateNumber % arr.length;
                reverseArray(arr, 0, rotateNumber - 1);
                reverseArray(arr, rotateNumber, arr.length - 1);
                reverseArray(arr, 0, arr.length - 1);
                return arr;
            }
        }
    }

    /*
    This function will help us to reverse arr[] from index start to end
     */
    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}