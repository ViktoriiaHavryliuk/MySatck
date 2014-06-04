/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.kiev.pkg;

import java.util.EmptyStackException;

/**
 *
 * @author Andrii_Rodionov
 */
public class MyStack {
    private Integer[] arr;    
    public int position;
    private final int MAX_STACK_SIZE;
    
    public MyStack(){
       this(10);
    }
    
    public MyStack(int stack_size){
        MAX_STACK_SIZE = stack_size;
        arr = new Integer[MAX_STACK_SIZE];
    }
    
    public Integer push(Integer item){
        if(position == MAX_STACK_SIZE){
            throw new IndexOutOfBoundsException();
        }
        
        arr[position++] = item;
        return item;
    }  
    
    public Integer peek(){
        if(empty()){
            throw new EmptyStackException();
        }
            
        return arr[position-1];
    }
    
    public Integer pop(){
        if(empty()){
            throw new EmptyStackException();
        }
        arr[position]=null;
        return arr[position--];
    }
    
    public boolean empty(){
        return (position == 0);
    }
}
