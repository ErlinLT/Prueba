module com.pmp.fxquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.pmp.fxquiz to javafx.fxml;
    opens com.pmp.dao to javafx.base;
    exports com.pmp.fxquiz;
}
