package base.repository;

import base.entity.BaseEntity;
import org.glassfish.jaxb.core.v2.model.core.ID;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>,ID extends Serializable> {
    E save(E entity);
    E update(E entity);
    void remove(E entity);
    Collection<E> load();
    Optional<E> findById(ID id);
    Optional<E> findByEntity(E entity);
    Session getSession();
}
