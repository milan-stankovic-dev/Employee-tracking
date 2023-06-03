package rs.ac.bg.np.praksaprojekat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private Employee employee;
}
