/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projecto_1;

import projecto_1.Classes.stack;
import projecto_1.Classes.adjMatrix;

/**
 * Este es el main donde se ejecuta todo el programa
 * @author RDG
 * @version 10/16/2023
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        adjMatrix test = new adjMatrix(3);
        test.addMatrixValue(0, 0);
        test.addMatrixValue(1, 0);
        test.addMatrixValue(0, 1);
        test.addMatrixValue(1, 1); 
        
        test.print();
        
        stack test2 = new stack();
        test2.push(0);
        test2.push(1);
        test2.push(2);
        test2.push(3);
        test2.push(4);
        System.out.println("PRINT 1");
        test2.print();
        System.out.println("COPY");
        stack<String> test3 = test2.copyStack();
        System.out.println("POP");
        test3.pop();
        System.out.println("PRINT 2");
        test3.print();
        System.out.println("FIN");
    }
    
}
