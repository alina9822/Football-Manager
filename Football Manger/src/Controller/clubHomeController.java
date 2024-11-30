package Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import main.*;
import projectClasses.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class clubHomeController implements Initializable {
    private Main main;
    @FXML
    public JFXButton searchButton;
@FXML
    public Label caption;
@FXML
    public JFXButton logOut;
    @FXML
    public ImageView exitResultTable;
    @FXML
    public Pane tablePane;
    @FXML
    public TableColumn countCol;
    @FXML
    public TableColumn countryCol;
    @FXML
    public TableView resultTable;
    @FXML
    public JFXButton byNameButton;
    @FXML
    public JFXButton byCountryButton;
    @FXML
    public JFXButton byPositionButton;
    @FXML
    public JFXButton bySalaryRangeButton;
    @FXML
    public Pane byNamePane;
    @FXML
    public Pane byCountryPane;
    @FXML
    public Pane byPositionPane;
    @FXML
    public Pane bySalaryRangePane;
    @FXML
    public JFXButton CountryWisePlayerSearch;
    @FXML
    public ImageView exitSalaryImage;
    @FXML
    public AnchorPane totalSalaryPane;
    @FXML
    public Label totalSalaryResults;
    @FXML
    public JFXButton totalSalarySearch;
    @FXML
    public JFXButton maxHeightSearch;
    @FXML
    public JFXButton maxAgeSearch;
    @FXML
    public JFXButton maxSalarySearch;
    @FXML
    public JFXButton playerSalaryRangeSearch;
    @FXML
    public TextField lowerBoundText;
    @FXML
    public TextField upperBoundText;
    @FXML
    public JFXButton playerPositionSearch;
    @FXML
    public TextField playerPositionSearchText;
    @FXML
    public TextField playerCountrySearchText;
    @FXML
    public JFXButton playerCountrySearch;
    @FXML
    public JFXButton playerNameSearch;
    @FXML
    public TextField playerNameSearchText;
    @FXML
    public JFXButton homeButton;
    @FXML
    public HBox mySearchBox;
    @FXML
    public AnchorPane slider;
    @FXML
    public JFXHamburger hamBurger;
    @FXML
    private VBox chosenPlayerCard;
    @FXML
    private Label playerNameLabel;
    @FXML
    private Label playerCountryLabel;
    @FXML
    private Label playerAgeLabel;
    @FXML
    private Label playerHeightLabel;
    @FXML
    private Label playerClubLabel;
    @FXML
    private Label playerPositionLabel;
    @FXML
    private Label playerNumberLabel;
    @FXML
    private Label playerWSLabel;
    @FXML
    private Label clubHeading;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Player> players =new ArrayList<>();
    private MyListener myListener;
    //private Clubs club =new Clubs();

    public void init(List<Player> playersList) {

        this.players=playersList;
        clubHeading.setText(players.get(0).getClub());
    }

    private List<Player> getData()
    {
        return players;
    }

    private void setChosenPlayerCard(Player player)
    {
        playerNameLabel.setText(player.getName());
        playerNameLabel.setText(player.getName());
        playerAgeLabel.setText(player.getAge()+"");
        playerCountryLabel.setText(player.getCountry());
        playerHeightLabel.setText(player.getHeight()+"");
        playerClubLabel.setText(player.getClub());
        playerPositionLabel.setText(player.getPosition());
        playerNumberLabel.setText(player.getNumber()+"");
        playerWSLabel.setText(Main.CURRENCY+player.getWeeklySalary());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        players.addAll(getData());


        clubPlayerShow(players);
        searchOptionShow();
        exitSalaryImage.setOnMouseClicked(event -> {
            totalSalarySearch.setVisible(true);
            totalSalaryPane.setVisible(false);
        });
         exitResultTable.setOnMouseClicked(event -> {
            tablePane.setVisible(false);
            CountryWisePlayerSearch.setDisable(false);
        });

    }


    private void clubPlayerShow(List<Player> players)
    {
        //grid.setVisible(true);
        grid.getChildren().clear();
        if (players.size()>0)
        {
            setChosenPlayerCard(players.get(0));
            myListener=new MyListener() {
                @Override
                public void onClickListener(Player player) {
                    setChosenPlayerCard(player);
                }
            };
        }
        int column=0;
        int row=1;
        try {
            for (int i = 0; i < players.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/player.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                playerController PlayerController = fxmlLoader.getController();
                PlayerController.setData(players.get(i),myListener);

                if(PlayerController.sold)
                    players.remove(players.get(i));

                if(column==3)
                {
                    column=0;
                    row++;
                }
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                grid.add(anchorPane,column++,row);
                GridPane.setMargin(anchorPane,new Insets(10));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchOptionShow()
    {
        HamburgerBackArrowBasicTransition burgerTask =new HamburgerBackArrowBasicTransition(hamBurger);
        burgerTask.setRate(-1);
        slider.setTranslateX(-320);
        hamBurger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            burgerTask.setRate(burgerTask.getRate()*-1);
            burgerTask.play();

            if(mySearchBox.isVisible())
            {

                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(slider);

                slide.setToX(0);
                slide.play();

                slider.setTranslateX(-320);
                mySearchBox.setVisible(false);
            }
            else
            {
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(slider);

                slide.setToX(-320);
                slide.play();

                slider.setTranslateX(0);
                mySearchBox.setVisible(true);
            }
        });
    }

@FXML
    public void homeButtonAction(ActionEvent actionEvent) {
     showAllPlayers(getData(),"All Players");
    }
    private void showAllPlayers(List<Player> players,String s)
    {
        caption.setText(s);
        caption.setTextFill(Paint.valueOf("WHITE"));
        clubPlayerShow(players);
    }


    @FXML
    public void playerNameSearchAction(ActionEvent actionEvent) {
    String playerName=playerNameSearchText.getText();
    List<Player> ResultPlayers = searchPlayer.byPlayerName(getData(),playerName);
   if(ResultPlayers.isEmpty())
   {
       caption.setText("No such player with this name");
       caption.setTextFill(Paint.valueOf("#c8080f"));
       clubPlayerShow(ResultPlayers);
   }
    else
        showAllPlayers(ResultPlayers,"Players with given name");
    byNamePane.setVisible(false);
    }
    @FXML
    public void playerCountrySearchAction(ActionEvent actionEvent) {
    String countryName=playerCountrySearchText.getText();
    List<Player> ResultPlayers = searchPlayer.byCountry(getData(),countryName);
        if(ResultPlayers.isEmpty())
        {
            caption.setText("No such player with this country");
            caption.setTextFill(Paint.valueOf("#c8080f"));
            clubPlayerShow(ResultPlayers);
        }
        else
        showAllPlayers(ResultPlayers,"Players from "+countryName);
    byCountryPane.setVisible(false);
    }

    @FXML
    public void playerPositionSearchAction(ActionEvent actionEvent) {
        String positionName=playerPositionSearchText.getText();
        List<Player> ResultPlayers = searchPlayer.byPosition(getData(),positionName);
        if(ResultPlayers.isEmpty())
        {
            caption.setText("No such player with this position");
            caption.setTextFill(Paint.valueOf("#c8080f"));
            clubPlayerShow(ResultPlayers);
        }
        else
        showAllPlayers(ResultPlayers,positionName+"s");
        byPositionPane.setVisible(false);
    }

    @FXML
    public void playerSalaryRangeSearchAction(ActionEvent actionEvent) {
        double lower;
        double upper;
        if ((lowerBoundText.getText().equals("")))
            lower=0;
        else
        lower=Double.parseDouble(lowerBoundText.getText());
        if ((upperBoundText.getText().equals("")))
            upper=0;
        else
        upper=Double.parseDouble(upperBoundText.getText());
        List<Player> ResultPlayers = searchPlayer.bySalaryRange(getData(),upper,lower);
        if(ResultPlayers.isEmpty())
        {
            caption.setText("No such player with this weekly salary ragnge");
            caption.setTextFill(Paint.valueOf("#c8080f"));
            clubPlayerShow(ResultPlayers);
        }
        else
        showAllPlayers(ResultPlayers,"Players with given salary range");
        bySalaryRangePane.setVisible(false);
    }
@FXML
    public void maxSalarySearchAction(ActionEvent actionEvent) {
        List<Player> ResultPlayers = searchClubs.maxSalaryInClub(getData());//searchPlayer.byPosition(getData(),positionName);
        showAllPlayers(ResultPlayers,"Players with max salary");
    }

@FXML
    public void maxAgeSearchAction(ActionEvent actionEvent) {
        List<Player> ResultPlayers = searchClubs.maxAgeInClub(getData());//searchPlayer.byPosition(getData(),positionName);
        showAllPlayers(ResultPlayers,"Players with max age");
    }


    @FXML
    public void maxHeightSearchAction(ActionEvent actionEvent) {

        List<Player> ResultPlayers = searchClubs.maxHeightInClub(getData());//searchPlayer.byPosition(getData(),positionName);
        showAllPlayers(ResultPlayers,"Players with max height");
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void totalSalarySearchAction(ActionEvent actionEvent) {
        double total= searchClubs.TotalSalaryOfClub(getData());
        totalSalaryResults.setText(Main.CURRENCY+total);
        totalSalaryPane.setVisible(true);
        totalSalarySearch.setVisible(false);
        showAllPlayers(getData(),"All Players");
    }

    @FXML
    public void CountryWisePlayerSearchAction(ActionEvent actionEvent) {
        ObservableList list = FXCollections.observableArrayList();
        tablePane.setVisible(true);
        CountryWisePlayerSearch.setDisable(true);

        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        HashMap<String,Integer> map = searchPlayer.countryWisePlayerCount(getData());
        List<myTable> myList = new ArrayList<>();
            for (String keys : map.keySet())
            {
                System.out.println(keys + ": "+ map.get(keys));
                myList.add(new myTable(keys,map.get(keys)));
            }
        list.addAll(myList);
        resultTable.setEditable(true);
        resultTable.setItems(list);
        showAllPlayers(getData(),"All Players");
    }

    @FXML
    public void byNameButtonAction(ActionEvent actionEvent) {
        byNamePane.setVisible(true);
    }
    @FXML
    public void byCountryButtonAction(ActionEvent actionEvent) {
        byCountryPane.setVisible(true);
    }
    @FXML
    public void byPositionButtonAction(ActionEvent actionEvent) {
        byPositionPane.setVisible(true);
    }
    @FXML
    public void bySalaryRangeButtonAction(ActionEvent actionEvent) {
        bySalaryRangePane.setVisible(true);
    }
    @FXML
    public void logOutAction(ActionEvent actionEvent) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchButtonAction(ActionEvent actionEvent) {

    }


   /* @FXML
    public MenuItem tryButton;
@FXML
    public void tryButtonAction(ActionEvent actionEvent) {
    slider.setBackground(new Background(new BackgroundFill(Paint.valueOf("#0ed145"), CornerRadii.EMPTY, Insets.EMPTY)));
    }*/


}
