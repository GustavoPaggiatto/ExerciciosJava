/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical;

/**
 *
 * @author Gustavo
 */
/**
 * Created by Mohammed Salah on 29/12/2016.
 */
public class Token {

    String token;
    String lexeme;

    public Token(String token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
    }

    public String toString() {
        String format = "[" + lexeme;
        int initLength = format.length();

        for (int i = 0; i <= 50 - initLength; i++) {
            format += " ";
        }

        format += token + "]";

        return format;
    }
}
