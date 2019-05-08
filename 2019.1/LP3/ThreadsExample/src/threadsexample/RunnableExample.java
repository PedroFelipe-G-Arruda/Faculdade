/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsexample;

/**
 *
 * @author pedro
 */
public class RunnableExample implements Runnable{
    
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.print("*");
        }
    }
    
}
