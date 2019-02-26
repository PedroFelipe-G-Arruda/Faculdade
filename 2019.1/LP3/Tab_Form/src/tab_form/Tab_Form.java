/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tab_form;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class Tab_Form extends Application {
    
    BorderPane bdp;
    
    //Top
    Label ldlKeyword, ldlOption;
    TextField txtKeyword;
    ChoiceBox chbOption;
    
    //Center
    TabPane tbp;
    Tab tabSearch, tabEdit;
    //Tab Search
    TableView tbvSearch;
    //Tab Edit
    
    //Bottom
    Button btnNew, btnConfirm, btnEdit, btnCancel, btnDelete;
        
    
    @Override
    public void start(Stage primaryStage) {
        
        //Contrução top
        
        ldlKeyword = new Label("Keyword:");
        txtKeyword = new TextField();
        ldlOption = new Label("Option:");
        chbOption = new ChoiceBox();
        chbOption.setItems(FXCollections.observableArrayList("Name"));
        
        //Contrução Bottom
        btnNew = new Button("New");
        btnNew.setOnAction(e -> { btnNew_onAction(e);});
        btnConfirm = new Button("Confirm");
        btnConfirm.setOnAction(e -> {btnConfirm_onAction(e);});
        btnEdit = new Button("Edit");
        btnEdit.setOnAction(e -> {btnEdit_onAction(e);});
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e -> {btnCancel_onAction(e);});
        btnDelete = new Button("Delete");
        btnDelete.setOnAction(e -> {btnDelete_onAction(e);});

        //Tabel
        tabSearch = new Tab();
        tbvSearch = new TableView();
        tbvSearch.getColumns().addAll(new TableColumn("Name"), new TableColumn("Type"), new TableColumn("Price"), new TableColumn("Qtty"), new TableColumn("Image"));
        
        
        bdp = new BorderPane();
        bdp.getTop()
        Scene scene = new Scene(bdp, 500, 400);
        primaryStage.setTitle("Tab Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void btnNew_onAction(ActionEvent e) {
        
    }

    private void btnConfirm_onAction(ActionEvent e) {
        
    }

    private void btnEdit_onAction(ActionEvent e) {
        
    }

    private void btnCancel_onAction(ActionEvent e) {
        
    }

    private void btnDelete_onAction(ActionEvent e) {
        
    }
    
}
