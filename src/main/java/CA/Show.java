package CA;

public class Show {
    private String showName;
    private String showRunningTime;
    private String startDate;
    private String endDate;
    private String stallPrice;
    private String balconyPrice;
    private String circlePrice;
    private Show nextShow = null;

    public Show(String showName, String showRunningTime, String startDate, String endDate, String stallPrice, String circlePrice, String balconyPrice) {
        this.showName = showName;
        this.showRunningTime = showRunningTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stallPrice = stallPrice;
        this.circlePrice=circlePrice;
        this.balconyPrice=balconyPrice;
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
                ", endDate: " + endDate + ", stall ticket price: " + stallPrice + ", balcony ticket price: " + balconyPrice +
                ", circle ticket price: " + circlePrice;
    }

    public String getStallPrice() {
        return stallPrice;
    }

    public void setStallPrice(String stallPrice) {
        this.stallPrice = stallPrice;
    }

    public String getBalconyPrice() {
        return balconyPrice;
    }

    public void setBalconyPrice(String balconyPrice) {
        this.balconyPrice = balconyPrice;
    }

    public String getCirclePrice() {
        return circlePrice;
    }

    public void setCirclePrice(String circlePrice) {
        this.circlePrice = circlePrice;
    }
}
