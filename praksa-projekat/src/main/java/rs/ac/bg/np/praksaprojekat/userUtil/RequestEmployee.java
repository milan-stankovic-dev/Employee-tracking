package rs.ac.bg.np.praksaprojekat.userUtil;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import rs.ac.bg.np.praksaprojekat.domain.Employee;

import java.time.Instant;
import java.time.LocalDate;

@RequiredArgsConstructor
@Data
public class RequestEmployee {
    private final Employee employee;
    private final LocalDate from;
    private final LocalDate to;
}
