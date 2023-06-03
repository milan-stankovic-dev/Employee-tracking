package rs.ac.bg.np.praksaprojekat.domain;

import java.time.Instant;
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
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;
	private int age;
	private Instant timeJoined;
	private boolean active;
	private String publicKeySsh;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeTimesOff")
	@JsonIgnore
	private Set<TimeOff> timesOff;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeEntry")
	@JsonIgnore
	private Set<SingleEntry> singleEntries;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_type_id")
	private EmployeeType employeeType;
}
