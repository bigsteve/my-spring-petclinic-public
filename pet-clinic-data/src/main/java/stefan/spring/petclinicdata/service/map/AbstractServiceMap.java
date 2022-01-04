package stefan.spring.petclinicdata.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import stefan.spring.petclinicdata.model.BaseEntity;

/**
 * 
 * @author stefan
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractServiceMap<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {

        if (object != null) {

            if (object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null.");
        }

        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(Entry -> Entry.getValue().equals(object));
    }

    private Long getNextId() {
        
        return map.keySet().isEmpty() ? 1L : Collections.max(map.keySet()) + 1;


    }

}
