package stefan.spring.petclinicdata.service;

import java.util.Set;

/**
 * 
 * @author stefan
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudService<T, ID> {
    
    Set<T> findAll();
    
    T findById(Long id);
    
    T save(T object);
    
    void delete(T object);
    
    void deleteById(Long id);
    
    

}
