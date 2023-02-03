package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] arr2D = {
                {1, 2, 3},
                {4, 5, 6}
        };
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print(arr2D[i][j]);
            }
            System.out.println();
        }
        int[][] arr2 = new int[2][4];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[j].length; j++) {
                arr2[i][j] = 1;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
    }
}