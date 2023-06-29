package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.repository.TimeOffTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.TimeOffTypeService;

@Service
public class TimeOffTypeServiceImp implements TimeOffTypeService {

    @Autowired
    private TimeOffTypeRepository timeOffTypeRepository;

}
