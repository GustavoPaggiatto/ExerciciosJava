/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author Gustavo
 */
public class Lexical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lendo o arquivo...
        System.out.println("Executando...");

        try {
            File file = new File("C:\\Users\\Gustavo\\Desktop\\EC5\\Lexical\\ExerciciosJava\\Lexical\\jquery.txt");
            LexerClass lexerClass = new LexerClass(file);
            List<Token> tokens = lexerClass.generateTokens();

            writeFile(tokens);

            /* for tests...
            for (int i = 0; i < tokenList.size(); i++) {
                System.out.println(tokenList.get(i).toString());
            }
             */
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private static void writeFile(List<Token> tokens) throws IOException {
        FileWriter myWriter = new FileWriter("tokens.txt");

        for (int i = 0; i < tokens.size(); i++) {
            Token current = tokens.get(i);
            myWriter.write(current.toString() + "\r\n");
        }

        myWriter.close();
    }
}
