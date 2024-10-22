package CA;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowList {
    public static Show selectedShow;
   private Show head=null;
   @FXML
   private TextField showTitle;
   @FXML
    private TextField runningTime;
   @FXML
    private DatePicker startingDate;
   @FXML
    private DatePicker endDate;
   @FXML
    private TextField ticketPrice;
   @FXML
   public Accordion container;
   public void AddShow(){
       if(head==null){
          head = new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketPrice.getText());
           head.setPerformanceList(new PerformanceList());
       }
       else{
          Show temp = head;
          while(temp.getNextShow()!=null){
             temp=temp.getNextShow();
          }
          temp.setNextShow(new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketPrice.getText()));
           temp.setPerformanceList(new PerformanceList());
       }
       showTitle.clear();
       runningTime.clear();
       startingDate.setValue(null);
       endDate.setValue(null);
       ticketPrice.clear();
       ListShows();
   }
   public void Reset(){
      head=null;
      container.getPanes().clear();
   }
   public void ListShows(){
       container.getPanes().clear();
       if(head!=null) {
           Show temp = head;
          do {
               Button newbutton2 = new Button("Delete");
               Button performanceListButton2 = new Button("List Of Performances");
               container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()), performanceListButton2, newbutton2)));
              final Show temp12 = temp;
              performanceListButton2.setOnAction(e->OpenPerformanceList(temp12));
               temp = temp.getNextShow();
               newbutton2.setOnAction(e -> Delete(temp12));
           }
          while (temp != null);
       }
   }
    private void OpenPerformanceList (Show show) {
       selectedShow=show;
        System.out.println(selectedShow.getPerformanceList().getDateOfPerformance());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PerformanceView.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setTitle(show.getShowName());
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Delete(Show s) {
        Show temp=head,prev=null;
        while(temp!=null && !temp.equals(s)) {
            prev=temp;
            temp=temp.getNextShow();
        }
        if(temp!=null){
            if(temp==head) head=head.getNextShow();
            else prev.setNextShow(temp.getNextShow());
        }
        ListShows();
    }
}