package CA;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

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
   }
   public void Reset(){
      head=null;
      container.getPanes().clear();
   }
   public void ListShows(){
       container.getPanes().clear();
       if(head!=null) {
           Show temp = head;
            container.getPanes().add(new TitledPane(head.getShowName(), new FlowPane(new Label(head.toString()),new Button("List Of Performances"))));
           while (temp.getNextShow() != null) {
               temp = temp.getNextShow();
               container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()),new Button("List Of Performances"))));
           }
       }
       else{
           System.out.println("List is empty");
       }
   }
}