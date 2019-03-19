package four;

import java.time.LocalDateTime;
import java.util.Date;

public class GuardStatus {

    public LocalDateTime date;
    public int id;
    public String status;

    public GuardStatus(LocalDateTime date, int id) {
        this.date = date;
        this.id = id;
    }

    public GuardStatus(LocalDateTime date, String status) {
        this.date = date;
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "GuardStatus{" +
                "date=" + date +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}' + '\n';
    }
}
