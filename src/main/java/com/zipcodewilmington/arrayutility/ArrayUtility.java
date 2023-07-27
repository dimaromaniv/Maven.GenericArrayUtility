package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<Thing> {
    private Thing[] array;

    public ArrayUtility(Thing[] inputArray) {
        this.array = inputArray;
    }

    public Integer countDuplicatesInMerge(Thing[] arrayToMerge, Thing valueToEvaluate) {

//        Thing[] newArr = (Thing[]) Array.newInstance(valueToEvaluate.getClass(), array.length + arrayToMerge.length);
//
//        int counter = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            newArr[i] = array[i];
//        }
//        for (int i = array.length; i < arrayToMerge.length + array.length; i++) {
//            newArr[i] = arrayToMerge[counter];
//            counter++;
//        }

        Thing[] newArr = mergeArray(arrayToMerge);

        this.array = newArr;
        int duplicate = getNumberOfOccurrences(valueToEvaluate);

        return duplicate;
    }

    public Thing[] mergeArray(Thing[] arrayToMerge) {
        Thing[] newArr = (Thing[]) Array.newInstance(arrayToMerge[0].getClass(), array.length + arrayToMerge.length);

        // Copy elements from the original array to the new array
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }

        // Copy elements from the arrayToMerge into the new array
        for (int i = array.length; i < array.length + arrayToMerge.length; i++) {
            newArr[i] = arrayToMerge[i - array.length];
        }

        this.array = newArr;
        return array;
    }


    public Thing getMostCommonFromMerge(Thing[] arrayToMerge) {

        Thing[] newArr = mergeArray(arrayToMerge);

        int mostCommonCounter = 0 ;
        Thing mostCommonObject = null;

        for (int  i = 0 ; i < newArr.length ; i++ ) {
            int counter = 0;
            for (int j = 0; j < newArr.length - 1; j++) {
                if (newArr[i] == newArr[j]) {
                    counter++;
                }
            }
            if (counter > mostCommonCounter) {
                mostCommonCounter = counter;
                mostCommonObject = newArr[i];
            }
        }
        return mostCommonObject;

//
//        Thing[] newArr = (Thing[]) Array.newInstance(arrayToMerge.getClass(), array.length);
//
//        int counter = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            newArr[i] = array[i];
//        }
//        for (int i = array.length; i < arrayToMerge.length + array.length; i++) {
//            newArr[i] = arrayToMerge[counter];
//            counter++;
//        }
//        this.array = newArr;
//
//
//        int maxCounter = 0;
//        Thing maxFreq = null;
//        ArrayList<Object> arrOfCommon = new ArrayList<>(asList(array));
//
//        Integer n = arrOfCommon.size();
//        for (int i = 0; i < n - 1; i++) {
//            int count = 0;
//            for (int j = 0; j < n - 1; j++) {
//                if (arrOfCommon.get(i).equals(arrOfCommon.get(j))) {
//                    count++;
//                }
//            }
//            if (count > maxCounter) {
//                maxCounter = count;
//                maxFreq = (Thing) arrOfCommon.get(i);
//            }
//        }
//
//        return maxFreq;
    }

    public Integer getNumberOfOccurrences(Thing valueToEvaluate) {
        Integer counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public Thing[] removeValue(Thing valueToRemove) {

        Integer removeElement = getNumberOfOccurrences(valueToRemove);
        Thing[] newArr = (Thing[]) Array.newInstance(valueToRemove.getClass(), array.length - removeElement);

        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                newArr[counter] = array[i];
                counter++;
            }
            // counter++;
        }
        return newArr;
    }
}
