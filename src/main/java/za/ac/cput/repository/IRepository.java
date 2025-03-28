package za.ac.cput.repository;


/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */

public interface IRepository <T, ID>{

    T create(T obj);
    T read(ID id);
    T update(T obj);
    boolean delete(ID id);
}
