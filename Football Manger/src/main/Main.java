package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projectClasses.*;
import Controller.*;
import util.*;
import server.*;

public class Main extends Application{

    public static final String CURRENCY = "$";
//    public static List<Player> playerList;
//    public static Scanner scn = new Scanner(System.in);
//    public static List<Clubs> clubList = new ArrayList();
//    public static Clubs theClub =new Clubs();
    private Stage stage;

    private NetworkUtil networkUtil;

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        connectToServer();
        stage = primaryStage;
        showLoginPage();
    }
    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }

//    public List<Player> getPlayerList() {
//        return playerList;
//    }
//
//    public List<Clubs> getClubList() {
//        return clubList;
//    }


    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 900, 650));
        stage.show();
    }

    public void showHomePage(List<Player> players) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/clubHome.fxml"));
        Parent root = loader.load();


        // Loading the controller
        clubHomeController controller = loader.getController();
        controller.setMain(this);
        controller.init(players);

        //controller.initialize();
        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 900, 650));
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        //playerList = PlayerDatabase.readFromFile();
        //InitializeClubs();
        launch(args);
    }
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }


}
