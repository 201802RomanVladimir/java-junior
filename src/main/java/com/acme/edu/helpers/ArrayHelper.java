package com.acme.edu.helpers;

/**
 * Вспомогательные методы для массивов
 */
public class ArrayHelper {
    /**
     * Перевод одномерного массива int {@code array} в строку
     * @param array одномерный массив
     * @return строка с данными из массива
     */
    public static String intArrayToString(int[] array) {
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

    /**
     * Перевод двухмерного массива int {@code array} в строку
     * @param matrix двухмерный массив
     * @return строка с данными из массива
     */
    public static String intMatrixToString(int[][] matrix) {
        StringBuilder resultSB = new StringBuilder("{");
        resultSB.append(System.lineSeparator());
        for (int[] aMatrix : matrix) {
            resultSB.append(intArrayToString(aMatrix));
            resultSB.append(System.lineSeparator());
        }
        resultSB.append("}");

        return resultSB.toString();
    }
}
