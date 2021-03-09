
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class Dress {

    private int _code;
    private Date _entryDate;
    private String _buyLocal;
    private String _type;
    private String _brand;
    private String _description;
    private Size _size;
    private Color _color;
    private double _tagValue;
    private double _payValue;
    private double _calculatedValue;
    private double _suggestedPrice;

    public int getCode() {
        return _code;
    }

    public void setCode(int _code) {
        this._code = _code;
    }

    public Date getEntryDate() {
        return _entryDate;
    }

    public void setEntryDate(Date _entryDate) {
        this._entryDate = _entryDate;
    }

    public String getBuyLocal() {
        return _buyLocal;
    }

    public void setBuyLocal(String _buyLocal) {
        this._buyLocal = _buyLocal;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getBrand() {
        return _brand;
    }

    public void setBrand(String _brand) {
        this._brand = _brand;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public Size getSize() {
        return _size;
    }

    public void setSize(Size _size) {
        this._size = _size;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }

    public double getTagValue() {
        return _tagValue;
    }

    public void setTagValue(double _tagValue) {
        this._tagValue = _tagValue;
    }

    public double getPayValue() {
        return _payValue;
    }

    public void setPayValue(double _payValue) {
        this._payValue = _payValue;
    }

    public double getCalculatedValue() {
        return _calculatedValue;
    }

    public void setCalculatedValue(double _calculatedValue) {
        this._calculatedValue = _calculatedValue;
    }

    public double getSuggestedPrice() {
        return _suggestedPrice;
    }

    public void setSuggestedPrice(double _suggestedPrice) {
        this._suggestedPrice = _suggestedPrice;
    }
}
