package backend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    private String firstName;
    private String lastName;
    private String email; 

}
