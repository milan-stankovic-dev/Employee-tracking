package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;

@RestController
@RequestMapping("/api/single-entry")
public class SingleEntryController {

    @Autowired
    private SingleEntryService singleEntryService;

    @PostMapping("/check-in/{sid}")
    public void checkIn(@PathVariable long sid) throws Exception {
         singleEntryService.checkIn(sid);
    }

    @PostMapping("/check-out/{sid}")
    public void checkOut(@PathVariable long sid) throws Exception {
        singleEntryService.checkOut(sid);
    }
}
