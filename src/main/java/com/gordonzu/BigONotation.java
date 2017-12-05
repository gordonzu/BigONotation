package com.gordonzu;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class BigONotation {

    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    private static long startTime;
    private static long endTime;

    BigONotation() {}

    BigONotation(int size) {
        this.arraySize = size;
        this.theArray = new int[size];
        generateRandomArray();
    }

    public int[] getTheArray() {
        return theArray;
    }

    public int getArraySize() {
        return arraySize;
    }

    public int getItemsInArray() {
        return itemsInArray;
    }

    private void setItemsInArray(int itemsInArray) {
        this.itemsInArray = itemsInArray;
    }

    private void generateRandomArray() {
        IntStream.range(0, arraySize).forEach((int x) ->
            theArray[x] = (int) (Math.random() * 1000) + 10);

        itemsInArray = arraySize - 1;
    }

    // O(1) -- order of one: executes in the same amount of time regardless of data

    public void addItemToArray(int item) {
        theArray[itemsInArray++] = item;
    }

    // O(n) -- order of n: linear search... time grows in direct proportion to the amount of data

    public boolean linearSearch(int value) {
        boolean valueInArray = false;
        String indexesWithValue = "";
        startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
                indexesWithValue += i + " ";
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Linear Search Took " + (endTime - startTime));
        return valueInArray;
    }

    // O(n^2) -- order of n squared... time is proportional to the data squared... bubble sort
    // for every element in the structure you must loop again through the entire structure. n^2

    public void bubbleSort() {
        startTime = System.currentTimeMillis();

        for (int i = arraySize - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    swapValues(j, j + 1);
                }
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Took " + (endTime - startTime));
    }

    public void swapValues(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    // O(log n) -- data length decreases by 50% each iteration
    // binary search

    public void binarySearch(int value) {
        startTime = System.currentTimeMillis();

        int lowIndex = 0;
        int highIndex = arraySize -1;
        int timesThrough = 0;

        while (lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) / 2;

            if (theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else if (theArray[middleIndex] > value)
                highIndex = middleIndex - 1;
            else {
                System.out.println("\nFound a match for " + value
                    + " at index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            timesThrough++;
        }

        endTime = System.currentTimeMillis();
        System.out.println("Binary search took " + (endTime - startTime));
        System.out.println("Times through: " + timesThrough);
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);
        }
    }

    public int partitionArray(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (theArray[++leftPointer] < pivot)
                ;

            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            if (leftPointer >= rightPointer) {
                break;
            } else {
                swapValues(leftPointer, rightPointer);
            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }

}

















