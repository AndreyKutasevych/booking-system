package CA;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowList {
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
       }
       else{
          Show temp = head;
          while(temp.getNextShow()!=null){
             temp=temp.getNextShow();
          }
          temp.setNextShow(new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketPrice.getText()));
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
           Button newbutton = new Button("Delete");
           Button performanceListButton = new Button("List Of Performances");
           container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()),performanceListButton , newbutton)));
           final Show temp1 = temp;
           newbutton.setOnAction(e -> {
               Delete(temp1);
           });
           performanceListButton.setOnAction(e->OpenPerformanceList(temp1));
           while (temp.getNextShow() != null) {
               temp = temp.getNextShow();
               Button newbutton2 = new Button("Delete");
               Button performanceListButton2 = new Button("List Of Performances");
               performanceListButton2.setOnAction(e->OpenPerformanceList(temp1));
               container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()), performanceListButton2, newbutton2)));
               final Show temp12 = temp;
               newbutton2.setOnAction(e -> Delete(temp12));
           }
       }
       else{
           System.out.println("List is empty");
       }
   }
    private void OpenPerformanceList (Show show) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PerformanceView.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setTitle("New FXML Window");
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