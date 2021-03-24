/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltwojson;
/**
 *
 * @author Gustavo
 */
public class TextElement extends XmlElement {

    private String _content;

    public TextElement() {
        this("");
    }

    public TextElement(String s) {
        super("CDATA");
        _content = s;
    }

    public String getText() {
        return this._content;
    }
}
