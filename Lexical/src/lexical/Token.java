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
public class Token {

    private int _column;
    private String _code;

    public int getColumn() {
        return _column;
    }

    public void setColumn(int _column) {
        this._column = _column;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public TokenType getType() {
        return _type;
    }

    public void setType(TokenType _type) {
        this._type = _type;
    }
    private TokenType _type;
}
