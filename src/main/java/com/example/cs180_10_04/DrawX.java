package com.example.cs180_10_04;

import java.util.Arrays;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class DrawX {
    private int size;
    public DrawX(int size) {
        this.size = size;
    }
    public char[][] generateArray() {

        char[][] xArray = new char[size][size];
        for(int i = 0; i < xArray.length; i++)
        {
            for(int j = 0; j < xArray.length; j++)
            {
                xArray[i][j] = ' ';
            }
        }
        for(int i = 0; i < xArray.length; i++)
        {
            for(int j = 0; j < xArray.length; j++)
            {
                if (i == j || (i + j) == this.size - 1)
                {
                    xArray[i][j] = '*';
                }
            }
        }
        return xArray;
    }
    public static void main(String[] args) {

        DrawX sample = new DrawX(10);

        char[][] testArray = sample.generateArray();

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(Arrays.toString(testArray[i]));
        }
    }
}