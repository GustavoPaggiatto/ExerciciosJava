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
public class XmlParser {

    public XmlElement parse(String s) throws Exception {
        //without init/final spaces...
        s = s.trim();

        if (!s.startsWith("<")) {
            return new TextElement(s);
        }

        int closing_index = s.indexOf(">");

        if (closing_index < 0) {
            throw new Exception("Stream sem tag de fechamento...");
        }

        String eStr = s.substring(1, closing_index);

        if (!s.endsWith("</" + eStr + ">")) {
            throw new Exception("Fechamento para o nó " + eStr + " não encontrado...");
        }

        //root...
        XmlElement root = new XmlElement(eStr);
        String inside = s.substring(closing_index + 1, s.length() - (eStr.length() + 3));
        parse(root, inside.trim());

        return root;
    }

    /**
     * Creates an XML document from a string
     *
     * @param root The root of the current document
     * @param s The string to read
     * @throws XmlParseException If parsing resulted in an error
     */
    private void parse(XmlElement root, String s) throws Exception {
        while (!s.isEmpty()) {
            int consumed = 0;
            XmlElement new_element = null;

            if (!s.startsWith("<")) {
                int begin_index = s.indexOf("<");

                if (begin_index < 0) {
                    new_element = new TextElement(s);
                    consumed = s.length();
                } else {
                    new_element = new TextElement(s.substring(0, begin_index));
                    consumed = begin_index;
                }
            } else {
                int closing_index = s.indexOf(">");

                if (closing_index < 0) {
                    throw new Exception("Tag de fechamento não encontrada para um subitem, verifique...");
                }

                String eStr = s.substring(1, closing_index);
                int closing_pos = s.indexOf("</" + eStr + ">");

                if (closing_pos < 0) {
                    throw new Exception("Fechamento para o nó " + eStr + " não encontrado, verifique...");
                }

                new_element = new XmlElement(eStr);
                String inside = s.substring(closing_index + 1, closing_pos);

                parse(new_element, inside.trim());
                consumed = closing_pos + eStr.length() + 3;
            }

            root.addChild(new_element);
            s = s.substring(consumed).trim();
        }
    }
}
