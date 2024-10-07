package CA;

public class Show {
    private String showName;
    private int showNumber;
    private Show nextShow = null;

    public Show(String showName, int showNumber) {
        this.showName = showName;
        this.showNumber = showNumber;
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
                "showName: '" + showName + '\'' +
                ", showNumber: " + showNumber;
    }
}
