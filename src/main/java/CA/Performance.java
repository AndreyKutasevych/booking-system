package CA;
import java.time.LocalDate;

public class Performance {
    private LocalDate date;
    private String time;
    private Performance next=null;

    public Performance(LocalDate date, String time) {
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Performance getNext() {
        return next;
    }

    public void setNext(Performance next) {
        this.next = next;
    }
}
