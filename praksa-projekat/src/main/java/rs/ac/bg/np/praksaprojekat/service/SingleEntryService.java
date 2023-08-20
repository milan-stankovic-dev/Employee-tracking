package rs.ac.bg.np.praksaprojekat.service;

import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;

import java.time.LocalDate;

public interface SingleEntryService {
    void checkIn(SingleEntry singleEntry) ;

    void checkOut(SingleEntry singleEntry) ;
    
    void checkInOut(SingleEntry singleEntry) ;

    Integer numberOfHoursFromTo(Employee employee, LocalDate from, LocalDate to);
}
