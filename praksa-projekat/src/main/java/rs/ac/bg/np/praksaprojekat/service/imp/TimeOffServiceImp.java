package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.repository.TimeOffRepository;
import rs.ac.bg.np.praksaprojekat.service.TimeOffService;

@Service
public class TimeOffServiceImp implements TimeOffService {
    @Autowired
    private TimeOffRepository timeOffRepository;
}
