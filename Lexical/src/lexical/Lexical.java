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
        System.out.println("Leitura do arquivo...");

        try {
            String stream = readFile();

            //without spaces and identation...
            String[] clsSpaceTab = stream.split("\\s+|\\t+");

            //removing comments and breaking lines...
            for (int i = 0; i < clsSpaceTab.length; i++) {
                clsSpaceTab[i] = clsSpaceTab[i].replaceAll("(?:/\\\\*(?:[^*]|(?:\\\\*+[^*/]))*\\\\*+/)|(?://.*)", "");
                clsSpaceTab[i] = clsSpaceTab[i].replaceAll("(\r|\n)+", "");
            }

            //Reserved js words...
            String reserved = "abstract|arguments|boolean|break|byte|case|catch|char|class|const|continue|debugger|default|delete|do|double|else|enum|eval|export|extends|false|final|finally|float|for|function|goto|if|implements|import|in|instanceof|int|interface|let|long|native|new|null|package|private|protected|public|return|short|static|super|switch|synchronized|this|throw|throws|transient|true|try|typeof|var|void|volatile|while|with|yield";
            String operators = "+|-|*|/|^|%";
            String variables = "/(var)(.*?)(;|,)/g";
            String method = "[a-zA-Z]+\\(.+\\)\\{.+\\}";

            ArrayList<Token> tokens = new ArrayList<Token>();
            String analiser = "";
            String analiserGroup = "";

            for (int i = 0; i < clsSpaceTab.length; i++) {
                for (int j = 0; j < clsSpaceTab[i].length(); j++) {
                    analiser += clsSpaceTab[i].charAt(j);
                    analiserGroup += clsSpaceTab[i].charAt(j);

                    if (analiser.matches(reserved)) {
                        Token token = new Token();
                        token.setCode(analiser);
                        token.setColumn(j);
                        token.setType(TokenType.Reserved);

                        tokens.add(token);
                        analiser = "";
                    } else if (analiser.matches(operators)) {
                        Token token = new Token();
                        token.setCode(analiser);
                        token.setColumn(j);
                        token.setType(TokenType.Operator);

                        tokens.add(token);
                        analiser = "";
                    } else if (analiser.matches(variables)) {
                        Token token = new Token();
                        token.setCode(analiser);
                        token.setColumn(j);
                        token.setType(TokenType.Var);

                        tokens.add(token);
                        analiser = "";
                    } else if (analiserGroup.matches(method)) {
                        Token token = new Token();
                        token.setCode(analiserGroup);
                        token.setColumn(j);
                        token.setType(TokenType.Method);

                        analiserGroup = "";
                    }
                }
            }

            System.out.println("Writing file...");
            writeFile(tokens);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private static String readFile() throws FileNotFoundException {
        String stream = null;

        File myObj = new File("C:\\Users\\Gustavo\\Desktop\\EC5\\Lexical\\Lexical\\jquery.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            stream += myReader.nextLine();
        }
        myReader.close();

        return stream;
    }

    private static void writeFile(ArrayList<Token> tokens) throws IOException {
        FileWriter myWriter = new FileWriter("tokens.txt");

        for (int i = 0; i < tokens.size(); i++) {
            Token current = tokens.get(i);
            myWriter.write(current.getColumn() + "|" + current.getCode() + "|" + current.getType().name());
        }

        myWriter.close();
    }
}
