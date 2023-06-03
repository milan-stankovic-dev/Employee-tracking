package rs.ac.bg.np.praksaprojekat.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeType {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeType")
	@JsonIgnore
	private Set<Employee> employeesOfType;
}
