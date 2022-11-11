module com.iaroslaveremeev.usersfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.iaroslaveremeev.usersfx to javafx.fxml;
    exports com.iaroslaveremeev.usersfx;
    exports com.iaroslaveremeev.usersfx.model;
    opens com.iaroslaveremeev.usersfx.model to javafx.fxml;
    exports com.iaroslaveremeev.usersfx.Repository;
    opens com.iaroslaveremeev.usersfx.Repository to javafx.fxml;
}