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
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(TEXT_PURPLE + "*************** Server Socket ***************" + TEXT_RESET);
        System.out.println(TEXT_PURPLE + "Initialising thread listener" + TEXT_RESET);

        SocketListener printerOne = new SocketListener(5000);
        printerOne.start();

        SocketListener printerTwo = new SocketListener(5001);
        printerTwo.start();

        SocketListener printerTree = new SocketListener(5002);
        printerTree.start();

        SocketListener printerFour = new SocketListener(5003);
        printerFour.start();

        SocketListener printerFive = new SocketListener(5004);
        printerFive.start();

        /*while (!printerOne.getError()) {
            System.out.println(ANSI_YELLOW + "Estado do listener: "
                    + listener.getState().name()
                    + "."
                    + TEXT_RESET);
        }*/
        System.out.println(ANSI_BLUE + "Finalizando o listener..." + TEXT_RESET);
    }

}
