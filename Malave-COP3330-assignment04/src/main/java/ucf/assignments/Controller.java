package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;

public class Controller
{


    @FXML
    Button addButton;
    @FXML
    Button removeButton;
    @FXML
    Button changeButton;
    @FXML
    Button saveButton;
    @FXML
    Button loadButton;
    @FXML
    Button deleteAll;
    @FXML
    Button displayIncom;
    @FXML
    Button displayComp;
    @FXML
    TextField itemFl;
    @FXML
    TextField itemRFl;
    @FXML
    TextField dateFl;
    @FXML
    TextField descFl;
    @FXML
    TextField compFl;
    @FXML
    ListView<todoList> todoListView;

    ObservableList<todoList> list = FXCollections.observableArrayList();



    @FXML
    private void addButton(ActionEvent event){
        list.add(new todoList(itemFl.getText(), dateFl.getText(),descFl.getText(), compFl.getText()));
        todoListView.setItems(list);
        refresh();
    }
    private void refresh(){
        itemFl.setText(null);
        dateFl.setText(null);
        descFl.setText(null);
        compFl.setText(null);
    }

    @FXML
    private void removeButton(ActionEvent ActionEvent){

        todoListView.getItems().remove(list.indexOf(itemRFl.getText()));

    }

    @FXML
    private void deleteAll(ActionEvent event){
        todoListView.getItems().clear();

    }

    public void changeButton(ActionEvent event) {
        int x = list.indexOf(itemRFl.getText());
        todoListView.getItems().set(x,new todoList(itemFl.getText(), dateFl.getText(),descFl.getText(), compFl.getText()));
    }

    @FXML
    private void saveButton(ActionEvent event){
        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter("output.txt")));
            for(int i = 0; i < todoListView.getHeight(); i++) {

                writer.write(todoListView.getItems().get(i).toString() + ",\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void loadButton(ActionEvent event){
        try {
            BufferedReader reader = new BufferedReader((new FileReader("output.txt")));
            String line;
            String[] itemsArr = new String[0];

            while ((line = reader.readLine()) != null) {
                itemsArr = line.split(",");
                todoList list = (new todoList((itemsArr[0]), (itemsArr[1]), (itemsArr[2]), (itemsArr[3])));
                todoListView.getItems().add(list);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void displayIncom(ActionEvent event) {
        if (todoListView != null) {
            for(int i = 0; i < todoListView.getHeight(); i++ )
            if(list.get(i).getComplete().contains("1"))
                System.out.println(todoListView.getItems());
        }

    }

    @FXML
    private void displayComp(ActionEvent event){
        if (todoListView != null) {
            for(int i = 0; i < todoListView.getHeight(); i++ )
                if(list.get(i).getComplete().contains("0"))
                    System.out.println(todoListView.getItems());
        }
    }

    public void addButton() {
        list.add(new todoList(itemFl.getText(), dateFl.getText(),descFl.getText(), compFl.getText()));
        todoListView.setItems(list);
        refresh();
    }


    public void removeButton() {
        todoListView.getItems().remove(list.indexOf(itemRFl.getText()));
    }

    public void saveButton() {
        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter("output.txt")));
            for(int i = 0; i < todoListView.getHeight(); i++) {

                writer.write(todoListView.getItems().get(i).toString() + ",\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadButton() {
        try {
            BufferedReader reader = new BufferedReader((new FileReader("output.txt")));
            String line;
            String[] itemsArr = new String[0];

            while ((line = reader.readLine()) != null) {
                itemsArr = line.split(",");
                todoList list = (new todoList((itemsArr[0]), (itemsArr[1]), (itemsArr[2]), (itemsArr[3])));
                todoListView.getItems().add(list);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayComp(){
        if (todoListView != null) {
            for(int i = 0; i < todoListView.getHeight(); i++ )
                if(list.get(i).getComplete().contains("0"))
                    System.out.println(todoListView.getItems());
        }
    }


    public void displayIncom() {
        if (todoListView != null) {
            for(int i = 0; i < todoListView.getHeight(); i++ )
                if(list.get(i).getComplete().contains("1"))
                    System.out.println(todoListView.getItems());
        }
    }

    public void deleteAll() {
        todoListView.getItems().clear();
    }
}
