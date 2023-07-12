package rs.ac.bg.np.praksaprojekat.service;

import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;
import rs.ac.bg.np.praksaprojekat.userUtil.FromTo;

public interface SingleEntryService {
    void checkIn(SingleEntry singleEntry) ;

    void checkOut(SingleEntry singleEntry) ;
    
    void checkInOut(SingleEntry singleEntry, FromTo fromTo) ;
}
