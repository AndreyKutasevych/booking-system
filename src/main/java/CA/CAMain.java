package CA;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

import java.io.IOException;

public class CAMain extends Application {
    Scanner scanner = new Scanner(System.in);
    ShowList showList =new ShowList();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CAMain.class.getResource("ShowView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        Choice();
    }
    private void Choice(){
        System.out.println("Enter a number (1, 2, or 3): ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1->AddShow();
            case 2 -> ListShows();
            case 3-> ClearShows();
        }
    }
    private void AddShow(){
        System.out.println("Enter show name:");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Enter show number:");
        int number=scanner.nextInt();
        showList.addShow(name,number);
        System.out.println("Show was added successfully");
        scanner.nextLine();
        Choice();
    }
    private void ListShows(){
        System.out.println("List of shows:");
        showList.ListShows();
        scanner.nextLine();
        Choice();
    }
    private void ClearShows(){
        showList.clearShows();
        System.out.println("All the shows are cleared");
        scanner.nextLine();
        Choice();
    }


    public static void main(String[] args) {
        launch();
    }
}