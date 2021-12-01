/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.database;

import java.util.List;

public interface ICrud<T>{
    public Boolean create(T t);
    public List<T> read();
    public Boolean update(T t);
    public Boolean delete(T t);
}
