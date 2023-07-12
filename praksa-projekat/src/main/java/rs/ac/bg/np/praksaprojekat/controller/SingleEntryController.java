package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;
import rs.ac.bg.np.praksaprojekat.service.SingleEntryService;
import rs.ac.bg.np.praksaprojekat.userUtil.FromTo;
import rs.ac.bg.np.praksaprojekat.userUtil.RequestEmployee;

@RestController
@RequestMapping("/api/single-entry")
public class SingleEntryController {

    @Autowired
    private SingleEntryService singleEntryService;

    @PostMapping("/check-in")
    public void checkIn(@RequestBody SingleEntry singleEntry){
         singleEntryService.checkInOut(singleEntry, FromTo.FROM);
    }

    @PostMapping("/check-out")
    public void checkOut(@RequestBody SingleEntry singleEntry) {
        singleEntryService.checkInOut(singleEntry, FromTo.TO);
    }
    @PostMapping("/number-of-hours")
    public ResponseEntity<Integer> numberOfHoursFromTo(@RequestBody RequestEmployee requestEmployee){
        return ResponseEntity.ok(singleEntryService.numberOfHoursFromTo(requestEmployee.getEmployee(),requestEmployee.getFrom(),requestEmployee.getTo()));
    }
}
