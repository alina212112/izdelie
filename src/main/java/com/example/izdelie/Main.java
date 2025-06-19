package com.example.izdelie;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TableView<JewelryItem> table;
    private TextField searchField;
    private JewelryStorage storage;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Поиск ювелирных изделий");
        storage = new JewelryStorage();
        searchField = new TextField();
        
        searchField.setPromptText("Введите название");

        Button searchButton = new Button("Поиск");
        searchButton.setOnAction(e -> searchJewelry());

        table = new TableView<>();
        initTableColumns();
        table.setItems(storage.getAllItems());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(searchField, searchButton, table);

        Scene scene = new Scene(layout, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTableColumns() {
        TableColumn<JewelryItem, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<JewelryItem, String> nameCol = new TableColumn<>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<JewelryItem, String> materialCol = new TableColumn<>("Материал");
        materialCol.setCellValueFactory(new PropertyValueFactory<>("material"));

        TableColumn<JewelryItem, String> sampleCol = new TableColumn<>("Проба");
        sampleCol.setCellValueFactory(new PropertyValueFactory<>("sample"));

        TableColumn<JewelryItem, String> typeCol = new TableColumn<>("Тип");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<JewelryItem, String> statusCol = new TableColumn<>("Статус");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<JewelryItem, Integer> priceCol = new TableColumn<>("Цена");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(idCol, nameCol, materialCol, sampleCol, typeCol, statusCol, priceCol);
    }

    private void searchJewelry() {
        String keyword = searchField.getText();
        ObservableList<JewelryItem> result = storage.searchByName(keyword);
        table.setItems(result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}