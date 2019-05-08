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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class Tab_Form extends Application {
    
    BorderPane bdp;
    
    //Top
    Label lblKeyword, lblOption;
    TextField txtKeyword;
    ChoiceBox chbOption;
    HBox pnlSearch;
    
    //Center
    TabPane tbp;
    Tab tabSearch, tabEdit;
    //Tab Search
    TableView tbvSearch;
    //Tab Edit
    GridPane gridEdit;
    
    //Bottom
    Button btnNew, btnConfirm, btnEdit, btnCancel, btnDelete;
    HBox bottom;
        
    
    @Override
    public void start(Stage primaryStage) {
        
        //Contrução top
        
        lblKeyword = new Label("Keyword:");
        txtKeyword = new TextField();
        lblOption = new Label("Option:");
        chbOption = new ChoiceBox();
        chbOption.setItems(FXCollections.observableArrayList("Name"));
        pnlSearch = new HBox(5);
        pnlSearch.setAlignment(Pos.CENTER);
        pnlSearch.getChildren().addAll(lblKeyword, txtKeyword, lblOption, chbOption);
        pnlSearch.setPadding(new Insets(5));
        
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
        
        bottom = new HBox(5);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(btnNew, btnConfirm, btnEdit, btnCancel,btnDelete);
        bottom.setPadding(new Insets(5));
        
        
        //Table - Search
        tabSearch = new Tab();
        tbvSearch = new TableView();
        tbvSearch.getColumns().addAll(new TableColumn("Name"), new TableColumn("Type"), new TableColumn("Price"), new TableColumn("Qtty"), new TableColumn("Image"));
        
        //Table - Edit
        gridEdit = new GridPane();
        
        tabSearch = new Tab("Products");
        tabEdit = new Tab("Edit");
        
        tbp = new TabPane();
        tbp.getTabs().addAll(tabSearch, tabEdit);
        
        bdp = new BorderPane();
        Scene scene = new Scene(bdp, 500, 400);
        bdp.setTop(pnlSearch);
        bdp.setCenter(tbp);
        bdp.setBottom(bottom);
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
