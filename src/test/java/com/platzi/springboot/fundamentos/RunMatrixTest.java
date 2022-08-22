package com.platzi.springboot.fundamentos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RunMatrixTest {

    static int[][] matrix;
    @BeforeAll
    public static void loadMatrix(){
        //[fila] [column]
        matrix = new int[2][3];
        matrix [0][0] = 0;
        matrix [0][1] = 1;
        matrix [0][2] = 2;

        matrix [1][0] = 10;
        matrix [1][1] = 11;
        matrix [1][2] = 12;
    }

    @Test
    public void runMatrixByRowsOrder(){

        System.out.println("test 1 por rows" );
        System.out.println("tamaño matrix y filas rows " + matrix.length);
        System.out.println("tamaño columns " + matrix[0].length);
        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println( "posicion row " + i + " column " + j + " = " + matrix[i][j] );
            }
            System.out.println("finish column");
        }
    }

    @Test
    public void runMatrixByColumnOrder(){
        System.out.println("test 2 por columnss" );

        System.out.println("tamaño filas rows " + matrix.length);
        System.out.println("tamaño columns " + matrix[0].length);
        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < column ; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.println( "posicion row " + j + " column " + i + " = " + matrix[j][i] );
            }
            System.out.println("finish rows");

        }
    }

    @Test
    public void runMatrixReverseForm() {
        System.out.println("test 3 reversa" );

        System.out.println("tamaño filas rows " + matrix.length);
        System.out.println("tamaño columns " + matrix[0].length);
        int rows = matrix.length-1;
        int column = matrix[0].length-1;
        for (int i = rows;  i >= 0 ; i--) {
            for (int j = column; j >= 0; j--) {
                System.out.println( "posicion row " +i + " column " + j + " = " + matrix[i][j] );
            }
            System.out.println("finish rows");

        }

    }
}
