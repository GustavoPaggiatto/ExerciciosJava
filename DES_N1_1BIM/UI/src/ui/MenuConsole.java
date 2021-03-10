/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class MenuConsole extends BaseConsole {

    @Override
    public boolean execute() {
        boolean result = false;

        System.out.println("Menu de opções:\r\n");
        System.out.println("1 - Listar");
        System.out.println("2 - Inserir");
        System.out.println("3 - Alterar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Sair");

        //try clean screen...
        //Runtime.getRuntime().exec("cls");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            // Reading data using readLine
            this._option = Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return result;
        }

        if (this._option == 5) {
            result = true;
        }

        return result;
    }

}
