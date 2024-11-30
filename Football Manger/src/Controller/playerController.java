package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import projectClasses.Player;

public class playerController {

    public Button sellButton;
    @FXML
    private Label nameLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private void click(MouseEvent mouseEvent)
    {
        myListener.onClickListener(player);
    }

    private Player player;
    private MyListener myListener;
    public static boolean sold=false;

    public void setData(Player player, MyListener myListener)
    {
        this.player = player;
        this.myListener=myListener;
        this.player=player;
        nameLabel.setText(player.getName());
        salaryLabel.setText(Main.CURRENCY+player.getWeeklySalary());
    }

    public void sellButtonAction(ActionEvent actionEvent) {
        sold=true;
    }
}
