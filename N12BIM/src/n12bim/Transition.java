/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n12bim;

/**
 *
 * @author Gustavo
 */
public class Transition {

    private String before;
    private String after;
    private boolean isInitial;

    public Transition(String before, String after, boolean isInitial) {
        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }

    public boolean getIsInitial() {
        return this.isInitial;
    }
}
