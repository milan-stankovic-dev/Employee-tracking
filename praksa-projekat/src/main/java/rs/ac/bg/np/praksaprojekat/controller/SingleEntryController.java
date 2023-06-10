package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;

@RestController
@RequestMapping("/api/v1/single-entry")
public class SingleEntryController {

    @Autowired
    private SingleEntryService singleEntryService;
}
