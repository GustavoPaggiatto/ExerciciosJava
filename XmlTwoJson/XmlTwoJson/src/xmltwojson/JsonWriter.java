/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltwojson;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public class JsonWriter {

    public String convert(XmlElement root) {
        StringBuffer json = new StringBuffer();

        json.append("{");
        json.append(
                "\""
                + root.getName()
                + "\":{");

        //private call...
        this.convert(root, json);

        json = json.delete(json.length() - 1, json.length());
        json.append("}");

        return json.toString();
    }

    private void convert(XmlElement root, StringBuffer json) {
        List<XmlElement> children = root.getChildren();

        if (children.size() == 1 && children.get(0) instanceof TextElement) {
            json.append(
                    "\""
                    + root.getName()
                    + "\":\""
                    + ((TextElement) children.get(0)).getText()
                    + "\",");
        } else {

            boolean aux = true;

            if (children.size() > 1) {
                for (int i = 0; i < children.size() - 1; i++) {
                    if (!children.get(i).getName().equals(children.get(i + 1).getName())) {
                        aux = false;
                        break;
                    }
                }

                if (aux) {
                    json.append(
                            "\""
                            + children.get(0).getName()
                            + "\":[");
                } else {
                    json.append("{");
                }
            } else {
                json.append("{");
            }

            for (XmlElement child : children) {
                convert(child, json);
            }

            json = json.delete(json.length() - 1, json.length()); //removing last comma...
            //json.replace(json.length() - 1, json.length(), ""); 

            if (aux) {
                //json.append("}");
                json.append("]");
            }

            json.append("},");
        }
    }
}
