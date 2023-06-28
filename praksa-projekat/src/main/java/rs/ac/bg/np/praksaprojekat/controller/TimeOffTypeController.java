package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.service.TimeOffTypeService;

@RestController
@RequestMapping("/api/time-off-type")
public class TimeOffTypeController {

    @Autowired
    private TimeOffTypeService timeOffTypeService;
}
