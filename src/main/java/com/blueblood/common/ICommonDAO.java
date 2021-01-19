
package com.blueblood.common;

import java.util.List;


public interface ICommonDAO<T> {
    
    public T save(T t);

    public T update(T t);

    public T delete(int id);

    public List<T> getAll();

    public T getById(int id);
}
