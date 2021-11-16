package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jose Malave
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application  {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Todo List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}



class todoList {
    private String item;
    private String dueDate;
    private String description;
    private String complete;

    public todoList(String item, String dueDate, String description, String complete){
        this.setitem(item);
        this.setdueDate(dueDate);
        this.setDescription(description);
        this.setcomplete(complete);
    }

    // here is where we ask the user to create a todo list
    //after ask if they want to add, remove, edit, display, or



    public void setitem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }


    public String getdueDate() {
        return this.dueDate;
    }

    public void setdueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    public String getComplete() {
        return this.complete;
    }

    public void setcomplete(String complete) {
        this.complete = complete;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString(){
        return this.getItem() + " " + this.getdueDate() + " " + this.getDescription() + " " + this.getComplete();
    }

}



