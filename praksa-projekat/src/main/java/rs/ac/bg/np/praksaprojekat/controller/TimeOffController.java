package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.service.TimeOffService;

@RestController
@RequestMapping("/api/time-off")
public class TimeOffController {

    @Autowired
    private TimeOffService timeOffService;
}
