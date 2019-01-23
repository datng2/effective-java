import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

class Person {
    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
               birthDate.compareTo(BOOM_END)   <  0;
    }

    // Bad
    // public boolean isBabyBoomer() {
    //     // Unncessary allocation of expensive objects!!
    //     Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    //     gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
    //     Date boom_start = gmtCal.getTime();
        
    //     gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
    //     Date boom_end = gmtCal.getTime();   
        
    //     return birthDate.compareTo(boom_start) >= 0 &&
    //            birthDate.compareTo(boom_end)   <  0;
    // }
}