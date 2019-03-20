package four;

import java.time.LocalDate;

public class MinutesAsleep {

    public int id;
    public LocalDate date;
    public int minutes;

    public MinutesAsleep(int id, LocalDate date, int minutes) {
        this.id = id;
        this.date = date;
        this.minutes = minutes;
    }
}
