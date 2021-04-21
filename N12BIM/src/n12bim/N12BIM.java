/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n12bim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Linguagem:
 *
 * I:D D:d OL:ol OR:or OT:ot OB:ob
 *
 * Non Terminals: I -> Init D -> Draw OL -> Origin for left OR -> Origin for
 * right OT -> Origin for top OB -> Origin for bottom
 *
 * Terminals: ol -> Origin for left or -> Origin for right ob -> Origin for
 * bottom ot -> Origin for top d -> Draw
 *
 * Final: d
 */
public class N12BIM {

    /**
     * @param args the command line arguments
     */
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RED = "\u001B[31m";

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(TEXT_PURPLE + "*************** N1 - 2BIM ***************" + TEXT_RESET);

        System.out.println();
        System.out.println(TEXT_PURPLE + "Lendo o arquivo..." + TEXT_PURPLE);

        List<String> lines = null;

        try {
            lines = readFile();
        } catch (Exception ex) {
            System.out.println();
            System.out.println(TEXT_RED + "Ocorreu um erro durante a leitura do arquivo. "
                    + "Verifique permissões, caminho válido, arquivo existente etc.");

            System.out.println();
            System.out.println(TEXT_GREEN + "Terminando a execução do programa" + TEXT_RESET);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //Nothing...
            }

            return;
        }

        Automaton automaton = null;

        System.out.println();
        System.out.println(TEXT_PURPLE + "Preparando autômato..." + TEXT_RESET);

        try {
            automaton = buildAutomaton(lines);
        } catch (Exception ex) {
            System.out.println();
            System.out.println(TEXT_RED + ex.getMessage() + TEXT_RESET);

            System.out.println();
            System.out.println(TEXT_GREEN + "Terminando a execução do programa" + TEXT_RESET);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //Nothing...
            }

            return;
        }

        System.out.println();
        System.out.println(TEXT_PURPLE + "Aplicando regras de derivação..." + TEXT_RESET);

        String result = null;

        try {
            result = applyRules(automaton);
        } catch (Exception ex) {
            System.out.println();
            System.out.println(TEXT_RED + ex.getMessage() + TEXT_RESET);

            System.out.println();
            System.out.println(TEXT_GREEN + "Terminando a execução do programa" + TEXT_RESET);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //Nothing...
            }

            return;
        }

        //write .SVG...
        System.out.println();
        System.out.println(TEXT_GREEN + "Terminando a execução do programa" + TEXT_RESET);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            //Nothing...
        }
    }

    private static Automaton buildAutomaton(List<String> lines) throws Exception {
        if (lines == null || lines.size() == 0) {
            throw new Exception("Arquivo de gramática vazio, verifique!");
        }

        Automaton automaton = new Automaton();
        List<Transition> transitions = new ArrayList<Transition>();

        for (String line : lines) {
            if (line.charAt(0) == 'E') {
                automaton.setAlphabet(line.substring(line.indexOf(":") + 1).split("[|]"));
                continue;
            }

            if (line.charAt(0) == 'G') {
                String degree = line.substring(line.indexOf(":") + 1);

                if (degree.matches("[^\\d,]")) {
                    throw new Exception("O ângulo deve conter apenas números");
                }

                automaton.setDegree(Double.parseDouble(degree));
            }

            if (line.indexOf(":") <= 0) {
                throw new Exception("Regra de derivação inválida (sem \":\").");
            }

            transitions.add(new Transition(line.substring(0, line.indexOf(":")), line.substring(line.indexOf(":")), line.substring(0) == "W"));
        }

        boolean findFirst = false;

        for (Transition t : transitions) {
            if (t.getIsInitial()) {
                findFirst = true;
                break;
            }
        }

        if (!findFirst) {
            throw new Exception("Regra de derivação inicial não encontrada, verifique.");
        }

        if (automaton.getAlphabet() == null || automaton.getAlphabet().length == 0) {
            throw new Exception("Alfabeto não foi informado, verifique");
        }

        automaton.setTransitions(transitions);
        automaton.setFinalChar(new char[]{'d', 'o', 'l', 'r', 't', 'b'});

        return automaton;
    }

    private static List<String> readFile() throws FileNotFoundException {
        Scanner reader = null;

        try {
            File file = new File("C:\\Users\\Gustavo\\Desktop\\EC5\\Java\\Exercicios\\ExerciciosJava\\N12BIM\\chars.txt");
            List<String> lines = new ArrayList<String>();

            reader = new Scanner(file);

            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }

            return lines;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static String applyRules(Automaton automaton) {
        String result = null;
        Transition firstTr = null;

        for (Transition t : automaton.getTransitions()) {
            if (t.getIsInitial()) {
                firstTr = t;
                break;
            }
        }

        result = firstTr.getAfter();

        for (Transition t : automaton.getTransitions()) {
            if (t.getIsInitial()) {
                continue;
            }

            while (result.contains(t.getBefore())) {
                int ix = result.indexOf(t.getBefore());

                result = result.substring(0, ix - 1)
                        + t.getAfter()
                        + result.substring(ix + t.getBefore().length());

            }
        }

        return result;
    }
}
