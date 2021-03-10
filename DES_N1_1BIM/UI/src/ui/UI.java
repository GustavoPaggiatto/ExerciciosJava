/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import challenge.repository.DressRepository;
import challenge.repository.RepositoryFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("******************** Iniciando desafio N1 - 1º BIM ********************");

        boolean out = false;

        while (!out) {
            BaseConsole console = ConsoleFactory.getConsole(TipoConsole.INITIAL);
            out = console.execute();

            if (!out) {
                if (console.getOption() == 1) {
                    console = ConsoleFactory.getConsole(TipoConsole.LIST);
                    console.execute();
                } else if (console.getOption() == 2) {
                    console = ConsoleFactory.getConsole(TipoConsole.ADD);
                    console.execute();
                } else if (console.getOption() == 3) {
                    console = ConsoleFactory.getConsole(TipoConsole.UPD);
                    console.execute();
                } else if (console.getOption() == 4) {
                    console = ConsoleFactory.getConsole(TipoConsole.REMOVE);
                    console.execute();
                } else {
                    System.out.println("Opção inválida.");
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                //nothing...
            }
        }

        System.out.println("******************** Finalizando desafio N1 - 1º BIM ********************");
    }

}
