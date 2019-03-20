package four;

import java.time.LocalDateTime;

public class GuardStatus implements Comparable<GuardStatus>{

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

    @Override
    public int compareTo(GuardStatus compareDate) {
        LocalDateTime date=(compareDate).getDate();

        return this.date.compareTo(date);
    }
}
