package za.ac.cput.repository;

import za.ac.cput.domain.BorrowTransaction;

public interface IRepository<T , ID> {
    T create(T t);
    T read(ID id);
    T update(T T);
    boolean delete(ID id);
}
