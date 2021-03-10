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
public abstract class BaseConsole {

    protected int _option;

    public abstract boolean execute();

    public int getOption() {
        return this._option;
    }
}
