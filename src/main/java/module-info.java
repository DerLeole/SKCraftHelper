module com.bss.modrinthtoskcraft {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.bss.modrinthtoskcraft to javafx.fxml;
    exports com.bss.modrinthtoskcraft;
}