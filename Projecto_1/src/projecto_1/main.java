/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projecto_1;

import projecto_1.Classes.Matriz_de_adyacencia;
import projecto_1.Classes.stack;

/**
 * Este es el main donde se ejecuta todo el programa
 * @author RDG
 * @version 10/14/2023
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matriz_de_adyacencia test = new Matriz_de_adyacencia(6);
        test.agregar(0,1);
        test.agregar(0,5);
        test.agregar(1,0);
        test.agregar(1,2);
        test.agregar(1,3);
        test.agregar(2,1);
        test.agregar(2,4);
        test.agregar(2,5);
        test.agregar(3,4);
        test.agregar(4,2);
        
        test.imprimir();
        
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
