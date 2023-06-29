package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.repository.SingleEntryRepository;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;

@Service
public class SingleEntryServiceImp implements SingleEntryService {

    @Autowired
    private SingleEntryRepository singleEntryRepository;
}
