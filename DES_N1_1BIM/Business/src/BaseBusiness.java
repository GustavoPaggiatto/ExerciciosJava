/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
public abstract class BaseBusiness<T> {

    private Class<T> _class;

    public T getInstance() throws InstantiationException, IllegalAccessException {
        return _class.newInstance();
    }
}
