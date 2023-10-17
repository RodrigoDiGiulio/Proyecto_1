/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

import java.util.Set;

/**
 * La clase stack y sus primitivas
 * @author RDG
 * @param <T>
 * @version 10/16/2023
 */
public class stack<T> {
    //Atributos
    private Node<T> head;
    private Node<T> tail;
    private Node<T> temp;
    private int size;
    private int maxStackValue;

    public stack() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxStackValue = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int isSize(){
        return size;
    }
    
    public void empty(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxStackValue = 0;
    }
    
    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T data = head.getData();
            return data;
        }
    }
    
    public void push(T data){
        Node<T> newData = new Node(data);
        if(this.isEmpty()){
            newData.setData(data);
            head = newData;
        }else{
            newData.setData(data);
            newData.setNext(head);
            head = newData;
        }
        size++;
    }
    
    public T pop(){
        if(this.isEmpty()){
            return null;
        }else{
            temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
        size--;
        return temp.getData();
    }
    
//    public stack<T> copyStack() {
//        stack<T> tempStack = new stack<T>();
//        stack<T> copyStack = new stack<T>();
//        if(this.isEmpty()) {
//            System.out.println("Stack Vacio");
//            return null;
//        } else {
//            int tempSize = this.size;
//            for (int i = 0; i < tempSize; i++) {
//                T tempData = this.pop();
//                copyStack.push(tempData);
//                tempStack.push(tempData);
//            }
//            // Restore the original stack
//            while(!tempStack.isEmpty()) {
//                this.push(tempStack.pop());
//            }
//        }
//        return copyStack;
//    }    
//    
    public stack<T> copyStack(){
        stack<T> tempStack = new stack<T>();
        stack<T> copyStack = new stack<T>();
        if(this.isEmpty()){
            System.out.println("Stack Vacio");
            return null;
        }else{
            int tempSize = this.size;
            for (int i = 0; i < tempSize; i++) {
                T tempData = this.pop();
                System.out.println(tempData);
                tempStack.push(tempData);
            }
            while(!tempStack.isEmpty()) {
                T tempData = tempStack.pop();
                this.push(tempData);
                copyStack.push(tempData);
            }
        }
        return copyStack;
    }
    
    public void print() {
        stack<T> tempStack = new stack<T>();
        if(this.isEmpty()) {
            System.out.println("Stack Vacio");
        } else {
            int tempSize = this.size;
            for (int i = 0; i < tempSize; i++) {
                T tempData = this.pop();
                System.out.println(tempData);
                tempStack.push(tempData);
            }
            // Restore the original stack
            while(!tempStack.isEmpty()) {
                this.push(tempStack.pop());
            }
        }
}
}
