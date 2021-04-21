/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n12bim;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Automaton {

    private List<Transition> transitions;
    private char[] finals;
    private String[] alphabet;
    private double degree;

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public char[] getFinals() {
        return this.finals;
    }

    public void setFinalChar(char[] finals) {
        this.finals = finals;
    }

    public void setAlphabet(String[] alphabet) {
        this.alphabet = alphabet;
    }

    public String[] getAlphabet() {
        return this.alphabet;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getDegree() {
        return this.degree;
    }
}
