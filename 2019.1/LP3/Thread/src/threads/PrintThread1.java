/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static java.lang.Thread.sleep;

/**
 *
 * @author pedro
 */
public class PrintThread1 extends Thread{
    String name;
    
    public PrintThread1 (String name){
        this.name = name;
    }
    public  void run(){
        for(int i=1; i<1000; i++){
            try {
                sleep((long)(Math.random()*100));
            } catch (InterruptedException ie) { }
            System.out.println("name");
        }
    }
}
