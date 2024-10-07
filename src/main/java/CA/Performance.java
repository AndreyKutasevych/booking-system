package CA;

public class Performance {
    private String date;
    private String time;

    public Performance(String date, String time) {
        this.date = date;
        this.time = time;
    }
    private Performance next=null;

    public void setTime(String time) {
        if(time.equals("matinee")||time.equals("evening")||time.equals("Matinee")||time.equals("Evening")){
            this.time=time;
        }
    }

    @Override
    public String toString() {
        return "Performance: " +
                "date: " + date+
                ", time: " + time;
    }
}
