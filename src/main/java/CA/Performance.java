package CA;
import java.time.LocalDate;

public class Performance {
    private LocalDate date;
    private String time;
    private Performance next=null;
    private String showName;

    public Performance(LocalDate date, String time, String showName) {
        this.date = date;
        this.time = time;
        this.showName=showName;
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

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Override
    public String toString() {
        return "Performance for the show: " + showName + ", for the " + time +" time, at the date: " + date;
    }
}
