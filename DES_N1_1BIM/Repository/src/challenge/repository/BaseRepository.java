/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository;

/**
 *
 * @author Gustavo
 */
public abstract class BaseRepository<T> {

    Class<T> _class;

    public BaseRepository(Class<T> classType) {
        this._class = classType;
    }

    public T getInstance() throws InstantiationException, IllegalAccessException {
        return _class.newInstance();
    }
}
