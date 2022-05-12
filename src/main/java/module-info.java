module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.login.view ;
    opens com.example.login.view to javafx.fxml;
}