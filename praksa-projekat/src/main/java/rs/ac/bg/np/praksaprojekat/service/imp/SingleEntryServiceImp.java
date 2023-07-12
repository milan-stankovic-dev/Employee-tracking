package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeRepository;
import rs.ac.bg.np.praksaprojekat.repository.SingleEntryRepository;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class SingleEntryServiceImp implements SingleEntryService {

    @Autowired
    private SingleEntryRepository singleEntryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void checkIn(long sid) throws Exception {


        Optional<SingleEntry> optionalSingleEntry = singleEntryRepository.findById(sid);

        if(!optionalSingleEntry.isPresent()){
            throw new Exception("SIngle entry for this employee does not exist!");
        }
        var localDateTime = LocalDateTime.now();
        optionalSingleEntry.get().setTimeFrom(localDateTime.toInstant(ZoneOffset.UTC));

        singleEntryRepository.save(optionalSingleEntry.get());

    }

    @Override
    public void checkOut(long sid) throws Exception {

        Optional<SingleEntry> optionalSingleEntry = singleEntryRepository.findById(sid);

        if(!optionalSingleEntry.isPresent()){
            throw new Exception("SIngle entry for this employee does not exist!");
        }
        var localDateTime = LocalDateTime.now();
        optionalSingleEntry.get().setTimeTo(localDateTime.toInstant(ZoneOffset.UTC));

        singleEntryRepository.save(optionalSingleEntry.get());

    }


}
