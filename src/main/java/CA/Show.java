package CA;

public class Show {
    private String showName;
    private String showRunningTime;
    private String startDate;
    private String endDate;
    private String price;
    private Show nextShow = null;

    public Show(String showName, String showRunningTime, String startDate, String endDate, String price) {
        this.showName = showName;
        this.showRunningTime = showRunningTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getShowName() {
        return showName;
    }

    public Show getNextShow() {
        return nextShow;
    }

    public void setNextShow(Show nextShow) {
        this.nextShow = nextShow;
    }

    @Override
    public String toString() {
        return "Show: " +
                "showName: " + showName  +
                ", showRunningTime: " + showRunningTime +
                ", startDate: " + startDate +
                ", endDate: " + endDate +
                ", price: " + price;
    }
}
