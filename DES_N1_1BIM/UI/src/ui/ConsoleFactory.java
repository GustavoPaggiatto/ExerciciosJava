/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Gustavo
 */
public class ConsoleFactory {

    public static BaseConsole getConsole(TipoConsole type) {
        if (type == TipoConsole.INITIAL) {
            return new MenuConsole();
        } else if (type == TipoConsole.ADD) {
            return new ConsoleInsercao();
        } else if (type == TipoConsole.UPD) {
            return new ConsoleAlteracao();
        } else if (type == TipoConsole.LIST) {
            return new ConsoleList();
        } else if (type == TipoConsole.REMOVE) {
            return new ConsoleRemocao();
        } else {
            return null;
        }
    }
}
