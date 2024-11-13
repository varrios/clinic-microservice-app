package lg.pg.aui.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E, K> {

    /**
     * Find entity object using its primary key.
     *
     * @param id object primary key
     * @return container (can be empty) with entity object
     */
    Optional<E> findById(K id);

    /**
     * Find all entities.
     *
     * @return list (can be empty) with all objects
     */
    List<E> findAll();

    /**
     * Save new object in the data store.
     *
     * @param entity object to be saved
     * @return saved entity
     */
    E save(E entity);

    /**
     * Delete object from the data store.
     *
     * @param entity object to be deleted
     */
    void delete(E entity);


}
