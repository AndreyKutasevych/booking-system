package CA;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PerformanceList implements Initializable {
    private Performance head=null;
    public Accordion container;

    @FXML
    private DatePicker dateOfPerformance;
    @FXML
    private ChoiceBox<String> timeChoice;

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
            head=new Performance(dateOfPerformance.getValue(),timeChoice.getValue());
        }
        else{
            Performance temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(new Performance(dateOfPerformance.getValue(),timeChoice.getValue()));
        }
        dateOfPerformance.setValue(null);
        timeChoice.setValue(null);
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
        container.getPanes().clear();
        if(head!=null) {
            Performance temp = head;
            do {
                Button newbutton2 = new Button("Delete");
                Button performanceListButton2 = new Button("Open Performance");
                container.getPanes().add(new TitledPane((temp.getDate()+" "+temp.getTime()), new FlowPane(new Label("View seat allocation"), performanceListButton2, newbutton2)));
                final Performance temp12 = temp;
                temp = temp.getNext();
                performanceListButton2.setOnAction(e->OpenPerformance(temp12));
                newbutton2.setOnAction(e -> DeletePerformance(temp12));
            }
            while (temp != null);
        }
    }
    public void OpenPerformance(Performance s){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        head=ShowList.selectedShow.getPerformanceList().head;
        ListPerformances();
    }
}
