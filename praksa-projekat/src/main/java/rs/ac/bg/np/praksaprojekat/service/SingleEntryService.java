package rs.ac.bg.np.praksaprojekat.service;

public interface SingleEntryService {
    void checkIn(long sid) throws Exception;

    void checkOut(long sid) throws Exception;
}
