package Controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.*;
import projectClasses.*;
import util.LoginDTO;


public class LoginController {



    private Main main;
    @FXML
    public TextField clubName;
    @FXML
    public TextField clubPass;
    @FXML
    public JFXButton loginButton;
    @FXML
    public JFXButton resetButton;


   @FXML
    public void resetAction(ActionEvent actionEvent) {
       clubName.setText(null);
       clubPass.setText(null);
    }

    @FXML
    public void loginAction(ActionEvent actionEvent) {


        String userName = clubName.getText();
        String password = clubPass.getText();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);
        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setMain(Main main) {
        this.main = main;
    }
}
