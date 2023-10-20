/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

import projecto_1.Classes.List;

/**
 * La clase AdjMatrix, ya esta validada
 * esta clase crea y usa Adjacent Matrix y en base a eso ejecuta Kosaraju
 * @author RDG
 * @version 10/20/2023
 * @param <T>
 */
public class AdjMatrix{
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
    static int size;
    static int[][] adjMatrix;
    static boolean[] visited;
    
    public AdjMatrix(int x){
        if (x > 0){
            this.size = x;
            adjMatrix = new int[this.size][this.size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    adjMatrix [i][j] = 0;
                }
            }
        }
        else{
            System.out.println("ERROR: Size must be greater than 0");
        }
    }
    
    public void resetMatrix(){
            adjMatrix = new int[this.size][this.size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    adjMatrix [i][j] = 0;
                }
            }
    }
    
    private boolean validateIJ(int i, int j){
        if ( (i > size) || (i < 0) ){
            System.out.println("ERROR: Values 1 must be between 0 and the matrix size(" + size + ")");
            return false;
        }
        else if((j >= size) || (j < 0)){
            System.out.println("ERROR: Values 2 must be between 0 and the matrix size(" + size + ")");
            return false;
        }
        else{
            return true;   
        }
    }
    
    public void addMatrixValue(int i, int j){
        if (validateIJ(i,j) == true){
            if(adjMatrix[i][j]<1){
                adjMatrix[i][j] = 1;
            }
            else{
                System.out.println("Value already 1");
            }
        }
    }
    
    public void deleteMatrixValue(int i, int j){
        if (validateIJ(i,j) == true){
            if(adjMatrix[i][j]>0){
                adjMatrix[i][j] = 0;
            }
            else{
                System.out.println("Value already 0");
            }
        }
    }
    
    public int getMatrixValue(int i, int j){
        if (validateIJ(i,j) == true){
            System.out.println(adjMatrix[i][j]);
            return adjMatrix[i][j];
        }
        else{
            System.out.println("ERROR: Matrix value -1");
            return -1;
        }
    }
    
    public void print(){
        System.out.println();
        for(int i=0; i< size; i++){
            for(int j=0; j< size; j++){
                System.out.print( adjMatrix[i][j] + "  " );        
            }
            System.out.println();
        }
    }
    
//    KOSARAJU
    public List kosaraju(String[] socialUsers, String[] aFollowB){
        String[] aB;
        size = socialUsers.length;
        this.resetMatrix();
        this.print();
        for (String x : aFollowB) {
            x = x.replaceAll(" ","");
            aB = x.split(",");
            int indexA = -1;
            int indexB = -1;
            for (int j = 0; j < size; j++) {
                if (aB[0].equals(socialUsers[j])){
                    indexA = j;
                }
                if (aB[1].equals(socialUsers[j])){
                    indexB = j;
                }
            }
            this.addMatrixValue(indexA, indexB);
        }
        this.print();
        return stronglyConnected();
    }
    
    static List stronglyConnected(){
        List stronglyConnected = new List();
        List posSC = new List();
        visited = new boolean[size];
        Stack stack = new Stack(size * size);
        
        //First DFS
        for(int vertex=0;vertex<size;vertex++){
            if(!visited[vertex]){
                findOrder(vertex,stack);
            }
        }
        
        //Reverse All edges
        //Now edge is represented by 2 insted of 1
        transpose();     
        
        //Second DFS
        visited = new boolean[size];
        
        //Printing all the strongly connected components
        while(!stack.isEmpty()){
            int vertex = (int) stack.pop();
            if(!visited[vertex]){
                dfs(vertex, stronglyConnected,posSC);
                System.out.println("");
            }
        }
        return stronglyConnected;
    }
    
    static void findOrder(int vertex,Stack pila){
        visited[vertex]=true;
        
        for(int v=0;v<size;v++){
            if(adjMatrix[vertex][v]==1 && !visited[v]){
                findOrder(v,pila);
            }
        }
        pila.push(vertex);
    }
    
    static void transpose(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(adjMatrix[i][j]==1){
                    adjMatrix[i][j]=0;
                    adjMatrix[j][i]=2;
                }
            }
        }
    }
    
    static List dfs(int vertex,List stronglyConnected, List posSC){
        visited[vertex] = true;
        System.out.print("UserIndex: "+vertex+" ");
        posSC.addEnd(vertex);
        if (!posSC.searchEnd().equals(vertex)){
            posSC.addEnd(vertex);
        }
        
        for(int v=0;v<size;v++){
            if(adjMatrix[vertex][v]==2 && !visited[v]){
                dfs(v,stronglyConnected,posSC);
            }
        }
        int[] posIndex = new int[posSC.isSize()];
        for (int i = 0; i < posSC.isSize(); i++) {
            int x = (int) posSC.searchPos(i);
            posIndex[i] = x;
        }
//        stronglyConnected.print();
        if ((stronglyConnected.isEmpty() == true)){
            if (posIndex.length != 0){
                stronglyConnected.addEnd(posIndex);
            }
        }
        else if(!posIndex.equals(stronglyConnected.searchEnd())){
            if (posIndex.length != 0){
                stronglyConnected.addEnd(posIndex);
            }
        }
        else{
        }
        posSC.empty();
        posIndex = null;
        return stronglyConnected;
    }
}