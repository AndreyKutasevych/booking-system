package CA;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class PerformanceList{
    public Performance head=null;
    public Accordion performanceContainer;
    @FXML
    private DatePicker dateOfPerformance;
    @FXML
    private ChoiceBox<String> timeChoice;
    @FXML
    private TextField showName;

    public DatePicker getDateOfPerformance() {
        return dateOfPerformance;
    }

    public void setDateOfPerformance(DatePicker dateOfPerformance) {
        this.dateOfPerformance = dateOfPerformance;
    }

    public ChoiceBox<String> getTimeChoice() {
        return timeChoice;
    }

    public void setTimeChoice(ChoiceBox<String> timeChoice) {
        this.timeChoice = timeChoice;
    }
    public void AddPerformance(){
        if(head==null){
            head=new Performance(dateOfPerformance.getValue(),timeChoice.getValue(),showName.getText());
        }
        else{
            Performance temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(new Performance(dateOfPerformance.getValue(),timeChoice.getValue(),showName.getText()));
        }
        dateOfPerformance.setValue(null);
        timeChoice.setValue(null);
        showName.clear();
        ListPerformances();
    };
    public void Reset(){
        head=null;
        ListPerformances();
    }
    public void DeletePerformance(Performance s){
        Performance temp=head, prev =null;
        while(temp!=null && !temp.equals(s)){
            prev=temp;
            temp=temp.getNext();
        }
        if(temp!=null){
            if(temp==head){
                head=head.getNext();
            }
            else{
                prev.setNext(temp.getNext());
            }
        }
        ListPerformances();
    }
    public void ListPerformances(){
        performanceContainer.getPanes().clear();
        if(head!=null){
            Performance temp=head;
            do {
                Button deleteButton = new Button("Delete");
                performanceContainer.getPanes().add(new TitledPane(temp.getShowName()+temp.getTime(), new FlowPane(new Label(temp.toString()), deleteButton)));
                final Performance temp12 = temp;
                temp=temp.getNext();
                deleteButton.setOnAction(e -> DeletePerformance(temp12));
            }
            while (temp != null);
        }
    }
}
