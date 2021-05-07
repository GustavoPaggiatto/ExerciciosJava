/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Gustavo
 */
public class Server {

    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RESET = "\u001B[0m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(TEXT_PURPLE + "*************** Server Socket ***************" + TEXT_RESET);
        System.out.print(TEXT_PURPLE + "Initialising thread listener" + TEXT_RESET);
    }

}
