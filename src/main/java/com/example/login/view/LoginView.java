package com.example.login.view;
import com.example.login.manage.ManageAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginView implements Initializable {
    protected static Stage stage;
    @FXML
    private TextField tFUsername;
    @FXML
    private TextField tFPassword;
    @FXML
    private Label lStatus;
    @FXML
    private Button bLogin;

    public static void setStage(Stage stage1) {
        stage = stage1;
    }

    private void ResetValue() {
        lStatus.setText("");
        tFPassword.setText("");
        tFUsername.setText("");
    }

    @FXML
    protected void onLoginButtonClick() throws FileNotFoundException {
        ManageAccount manageAccount = new ManageAccount();
        if (manageAccount.login(tFUsername.getText(), tFPassword.getText())) {
            lStatus.setText("ĐĂNG NHAP THÀNH CÔNG");
        } else {
            lStatus.setText("SAI TÊN ĐĂNG NHẬP HOẶC MẬT KHẨU");
            tFPassword.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResetValue();
    }
}