package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;
import rs.ac.bg.np.praksaprojekat.exception.WrongValueProvidedException;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeRepository;
import rs.ac.bg.np.praksaprojekat.repository.SingleEntryRepository;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;
import rs.ac.bg.np.praksaprojekat.userUtil.FromTo;

import java.time.*;
import java.util.List;
import java.util.Optional;

@Service
public class SingleEntryServiceImp implements SingleEntryService {

    @Autowired
    private SingleEntryRepository singleEntryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void checkIn(SingleEntry singleEntry){


//        Optional<SingleEntry> optionalSingleEntry = singleEntryRepository.findById(sid);

//        if(!optionalSingleEntry.isPresent()){
//            throw new WrongValueProvidedException("SIngle entry for this employee does not exist!");
//        }
        var localDateTime = LocalDateTime.now();
//        optionalSingleEntry.get().setTimeFrom(localDateTime.toInstant(ZoneOffset.UTC));
        singleEntry.setTimeFrom(localDateTime.toInstant(ZoneOffset.UTC));
//        singleEntryRepository.save(optionalSingleEntry.get());
        singleEntryRepository.save(singleEntry);

    }

    @Override
    public void checkOut(SingleEntry singleEntry){

//        Optional<SingleEntry> optionalSingleEntry = singleEntryRepository.findById(sid);

//        if(!optionalSingleEntry.isPresent()){
//            throw new WrongValueProvidedException("SIngle entry for this employee does not exist!");
//        }
        var localDateTime = LocalDateTime.now();
//        optionalSingleEntry.get().setTimeTo(localDateTime.toInstant(ZoneOffset.UTC));
        singleEntry.setTimeTo(localDateTime.toInstant(ZoneOffset.UTC));
//        singleEntryRepository.save(optionalSingleEntry.get());
        singleEntryRepository.save(singleEntry);

    }

    @Override
    public void checkInOut(SingleEntry singleEntry, FromTo inOrOut) {
    	
    	var localDateTime = LocalDateTime.now();
    	
    	switch (inOrOut) {
    	case FROM -> 
    		singleEntry.setTimeFrom(localDateTime.toInstant(ZoneOffset.UTC));
  
    	case TO -> {
    		long entryForCheckoutID = singleEntry.getId();
    		var singleEntryFromDBOptional = singleEntryRepository.findById(entryForCheckoutID);
    		
    		if(singleEntryFromDBOptional.isEmpty()) {
    			throw new EntityNotFoundException("Single entry provided in request not found in db.");
    		}
    		
    		var singleEntryFromDB = singleEntryFromDBOptional.get();
    		
    		singleEntryFromDB.setTimeTo(localDateTime.toInstant(ZoneOffset.UTC));
    		}
    	default -> throw new IllegalArgumentException("Inputted value is invalid for checking out or in. "
    			+ "Valid values are: Out, in.");
    	}
    	singleEntryRepository.save(singleEntry);
    }

    @Override
    public Integer numberOfHoursFromTo(Employee employee, LocalDate from, LocalDate to) {
        List<SingleEntry> singleEntries=singleEntryRepository.findAllByEmployeeEntryId(employee.getId());
        int hours=0;
        for(SingleEntry singleEntry:singleEntries){
            if(singleEntry.getTimeFrom().isAfter(Instant.from(from)) && singleEntry.getTimeFrom().isBefore(Instant.from(to))
            && singleEntry.getTimeTo().isAfter(Instant.from(from)) && singleEntry.getTimeTo().isBefore(Instant.from(to))){
                hours+=Duration.between(singleEntry.getTimeFrom(), singleEntry.getTimeTo()).toHours();
            }
        }
        return hours;
    }
}
