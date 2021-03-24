/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltwojson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class XmlElement {

    private String _name = "";
    private List<XmlElement> _children;

    XmlElement() {
        super();
        this._children = new ArrayList<XmlElement>();
    }

    public XmlElement(String name) {
        this();
        this._name = name;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public List<XmlElement> getChildren() {
        return _children;
    }

    public void setChildren(List<XmlElement> _children) {
        this._children = _children;
    }

    public void addChild(XmlElement e) {
        this._children.add(e);
    }
}
