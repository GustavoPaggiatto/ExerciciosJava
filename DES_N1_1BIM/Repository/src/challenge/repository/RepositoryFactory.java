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
public class RepositoryFactory<T extends BaseRepository> {

    Class<T> _class;

    public RepositoryFactory(Class<T> typeClass) {
        this._class = typeClass;
    }

    public T getInstante() throws InstantiationException, IllegalAccessException {
        return this._class.newInstance();
    }
}
