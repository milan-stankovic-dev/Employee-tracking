package rs.ac.bg.np.praksaprojekat.domain;

import java.time.Instant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TimeOff {
	@Id
	@GeneratedValue
	private long id;
	private Instant timeFrom;
	private Instant timeTo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_off_id")
	private TimeOffType timeOffType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Employee employeeTimesOff;
	
}
