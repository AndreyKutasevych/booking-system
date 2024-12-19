package CA;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class ShowList {
   public Show head=null;
   @FXML
   private TextField showTitle;
   @FXML
    private TextField runningTime;
   @FXML
    private DatePicker startingDate;
   @FXML
    private DatePicker endDate;
   @FXML
    private TextField ticketStallPrice;
    @FXML
    private TextField ticketBalconyPrice;
    @FXML
    private TextField ticketCirclePrice;
   @FXML
   public Accordion container;
   public void AddShow(){
       if(head==null){
          head = new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketStallPrice.getText(),ticketCirclePrice.getText(),ticketBalconyPrice.getText());
       }
       else{
          Show temp = head;
          while(temp.getNextShow()!=null){
             temp=temp.getNextShow();
          }
          temp.setNextShow(new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketStallPrice.getText(),ticketCirclePrice.getText(),ticketBalconyPrice.getText()));
       }
       showTitle.clear();
       runningTime.clear();
       startingDate.setValue(null);
       endDate.setValue(null);
       ticketStallPrice.clear();
       ticketBalconyPrice.clear();
       ticketCirclePrice.clear();
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
               Button deleteButton = new Button("Delete");
               container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()), deleteButton)));
              final Show temp12 = temp;
               temp = temp.getNextShow();
               deleteButton.setOnAction(e -> Delete(temp12));
           }
          while (temp != null);
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