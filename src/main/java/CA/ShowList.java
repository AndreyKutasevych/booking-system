package CA;

import Utilities.CustomList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

import java.io.*;

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
    private ListView<String> showListTitles;
   @FXML
   public Accordion container;
    private CustomList<Show> showList = new CustomList<>();

    @FXML
    public void initialize() {
        load();
    }
   public void AddShow() throws Exception {
       Show show = new Show(showTitle.getText(),runningTime.getText(),startingDate.getValue().toString(),endDate.getValue().toString(),ticketStallPrice.getText(),ticketCirclePrice.getText(),ticketBalconyPrice.getText());
       ListShows();
       showList.add(show);
       showTitle.clear();
       runningTime.clear();
       startingDate.setValue(null);
       endDate.setValue(null);
       ticketStallPrice.clear();
       ticketBalconyPrice.clear();
       ticketCirclePrice.clear();
   }
   public void Reset(){
      head=null;
      container.getPanes().clear();
   }
   public void ListShows() throws Exception {
       container.getPanes().clear();
       if(head!=null) {
           Show temp = head;
          do {
               Button deleteButton = new Button("Delete");
               container.getPanes().add(new TitledPane(temp.getShowName(), new FlowPane(new Label(temp.toString()), deleteButton)));
              final Show temp12 = temp;
               temp = temp.getNextShow();
               deleteButton.setOnAction(e -> {
                   try {
                       Delete(temp12);
                   } catch (Exception ex) {
                       throw new RuntimeException(ex);
                   }
               });
           }
          while (temp != null);
       }
       save();
   }
    public void Delete(Show s) throws Exception {
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
    private File file = new File("src/main/resources/com/example/Shows.xml");
    public void save() throws Exception {
        XStream  xstream = new XStream(new DomDriver());
        xstream.allowTypeHierarchy(Show.class);
        xstream.allowTypeHierarchy(CustomList.class);
        ObjectOutputStream os = xstream.createObjectOutputStream(new FileWriter(file));
        os.writeObject(showList);
        System.out.println ("shows saved to xml");
        os.close();

    }


    public void load() {
        //security
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        //list of classes for  serialisation
        xstream.allowTypeHierarchy(Show.class);
        xstream.allowTypeHierarchy(CustomList.class);
        try {

            ObjectInputStream in = xstream.createObjectInputStream(new FileReader(file));
            //load the xml data into showsList
            showList = (Utilities.CustomList<CA.Show>) in.readObject();
            System.out.println("shows loaded.");//debug
            for (int i = 0; i < showList.getSize(); i++) {
                showListTitles.getItems().add(showList.getIndex(i).toString());
            }
            in.close();
        } catch (Exception error) {
            error.printStackTrace();
            System.err.println("error loading from xml: " + error.getMessage());
        }

    }

}