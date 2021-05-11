/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.List;

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

        List<Printer> printers = new ArrayList<Printer>();
        printers.add(new Printer("192.168.0.1", "ONE"));
        printers.add(new Printer("192.168.0.2", "TWO"));
        printers.add(new Printer("192.168.0.3", "TREE"));
        printers.add(new Printer("192.168.0.4", "FOUR"));
        printers.add(new Printer("192.168.0.5", "FIVE"));

        SocketListener listener = new SocketListener(5000, printers);
        listener.start();

        while (true) {
            //nothing...
        }
        /*while (!printerOne.getError()) {
            System.out.println(ANSI_YELLOW + "Estado do listener: "
                    + listener.getState().name()
                    + "."
                    + TEXT_RESET);
        }
        System.out.println(ANSI_BLUE + "Finalizando o listener..." + TEXT_RESET);*/
    }

}
