package za.ac.cput.repository;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

public interface IRepository <T,ID>{

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
