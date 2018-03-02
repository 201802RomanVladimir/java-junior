package com.acme.edu.helpers;

public class ArrayHelper {
    public static String arrayToString(int[] array) {
        StringBuilder resultSB = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                resultSB.append(", ");
            }
            resultSB.append(array[i]);
        }
        resultSB.append("}");

        return resultSB.toString();
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder resultSB = new StringBuilder("{");
        resultSB.append(System.lineSeparator());
        for (int[] aMatrix : matrix) {
            resultSB.append(arrayToString(aMatrix));
            resultSB.append(System.lineSeparator());
        }
        resultSB.append("}");

        return resultSB.toString();
    }
}
