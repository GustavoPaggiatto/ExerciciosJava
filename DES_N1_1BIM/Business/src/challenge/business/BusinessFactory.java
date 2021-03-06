package challenge.business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class BusinessFactory<T extends BaseBusiness> {

    Class<T> _class;

    public BusinessFactory(Class<T> typeClass) {
        this._class = typeClass;
    }

    public T getInstante() throws InstantiationException, IllegalAccessException {
        return this._class.newInstance();
    }
}
