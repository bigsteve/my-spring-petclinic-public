package stefan.spring.petclinicdata.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created Stefan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    
    
    public Person(Long id, String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}