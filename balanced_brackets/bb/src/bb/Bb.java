/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

/**
 *
 * @author Gustavo
 */
public class Bb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*************** Challenge BB ***************");

        if (args == null || args.length == 0) {
            System.out.println("Informe um caminho de arquivo válido...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bb.class.getName()).log(Level.SEVERE, null, ex);
            }

            return;
        }

        File entry = new File(args[0]);

        if (!entry.exists()) {
            System.out.println("Arquivo inexistente, verifique...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bb.class.getName()).log(Level.SEVERE, null, ex);
            }

            return;
        }

        List<String> lines = null;
        System.out.println("Lendo o arquivo...");

        try {
            lines = readFile(entry);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro durante a leitura do arquivo. "
                    + "Isso é comum em permissões de pastas, arquivo em uso etc...");

            return;
        }

        //call stack resolver method bellow...
        System.out.println("Processando as linhas...");
        List<ResultBb> result = stackBBResolver(lines);

        try {
            writeFile(result, args[0]);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo. "
                    + "Isso é comum em permissões de pastas, arquivo em uso etc...");

            return;
        }

        System.out.println("Processando e saída gerada...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<ResultBb> stackBBResolver(List<String> lines) {
        List<ResultBb> result = new ArrayList<ResultBb>();

        for (String line : lines) {
            Stack stack = new Stack();
            boolean isPreviousEmpty = false;

            for (int i = 0; i < line.length(); i++) {
                //with strings is faster... otherwise we need to use ASCII hex codes...
                String item = Character.toString(line.charAt(i));

                if (item.equals("{")
                        || item.equals("(")
                        || item.equals("[")
                        || item.equals("<")) {
                    stack.push(item);
                    continue;
                }

                if (stack.isEmpty()) {
                    isPreviousEmpty = true;

                    ResultBb rItem = new ResultBb();

                    rItem.setLine(line);
                    rItem.setStatus(false);
                    result.add(rItem);

                    break;
                }

                String top = stack.peek().toString();

                if (item.equals("}") && top.equals("{")) {
                    stack.pop(); //removing from top...
                } else if (item.equals("]") && top.equals("[")) {
                    stack.pop();
                } else if (item.equals(">") && top.equals("<")) {
                    stack.pop();
                } else if (item.equals(")") && top.equals("(")) {
                    stack.pop();
                }
            }

            if (!isPreviousEmpty) {
                ResultBb rItem = new ResultBb();
                rItem.setLine(line);

                if (stack.empty()) {
                    rItem.setStatus(true);
                } else {
                    rItem.setStatus(false);
                }

                result.add(rItem);
            }
        }

        return result;
    }

    private static List<String> readFile(File file) throws FileNotFoundException {
        Scanner reader = null;

        try {
            reader = new Scanner(file);
            List<String> result = new ArrayList<String>();

            while (reader.hasNextLine()) {
                result.add(reader.nextLine());
            }

            return result;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void writeFile(List<ResultBb> result, String path) throws IOException {
        String[] pathParts = path.split("\\\\");
        String newPath = "";

        for (int i = 0; i < pathParts.length - 1; i++) {
            newPath += pathParts[i] + "\\";
        }

        newPath += "out.txt";

        FileWriter writer = new FileWriter(newPath);

        for (ResultBb item : result) {
            writer.write(item.getLine()
                    + " - "
                    + (item.isStatus() ? "OK" : "INVÁLIDO")
                    + "\r\n");
        }

        writer.flush();
        writer.close();
    }
}
