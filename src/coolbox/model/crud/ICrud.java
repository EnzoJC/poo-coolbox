/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.crud;

import java.util.List;

public interface ICrud<T>{
    public Boolean create(T objeto);
    public List<T> read();
    public Boolean update(T objeto);
    public Boolean delete(T objeto);
}
