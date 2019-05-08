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
public class ThreadsStartExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new ThreadExample().start();
        //new Thread(new RunnableExample()).start();
        new PrintThread1("Pedro").start();
        new PrintThread1("Nicolas").start();
    }
    
}
