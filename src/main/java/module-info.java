module com.iaroslaveremeev.usersfx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.iaroslaveremeev.usersfx to javafx.fxml;
    exports com.iaroslaveremeev.usersfx;
}