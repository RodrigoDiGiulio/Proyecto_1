/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 * La clase Nodo
 * @author RDG
 * @version 10/17/2023
 * @param <T>
 */
public class adjMatrix{
    //Atributos
    //Size un solo lado de la matriz
    
    //ejemplo size = 2
    //| x x |
    //| x x |
    
    //ejemplo size = 5
    //| x x x x x|
    //| x x x x x|
    //| x x x x x|
    //| x x x x x|
    //| x x x x x|
    private int size;
    private int[][] matrix;
    
    public adjMatrix(int x){
        this.size = x;
        matrix = new int[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix [i][j] = 0;
            }
        }
    }
    
    public void addMatrixValue(int i, int j){
        matrix[i][j] = 1;
    }
    
    public void deleteMatrixValue(int i, int j){
        if(matrix[i][j]>0){
            matrix[i][j] = 0;
        }
        System.out.println("Redundancia");
    }
    
    public void print(){
        System.out.println();
        for(int i=0; i< size; i++){
            for(int j=0; j< size; j++){
                System.out.print( matrix[i][j] + "  " );        
            }
            System.out.println();
        }
    }
}
