package com.bss.modrinthtoskcraft;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

public class DownloaderMainController
{
    @FXML
    private TextField urlField;
    @FXML
    private TextField downloadPathField;
    @FXML
    private ProgressBar downloadProgressBar;
    @FXML
    private Button chooseButton;

    @FXML
    protected void onChooseButtonClick()
    {
        String home = System.getProperty("user.home");
        File initialDir = new File(home+"/Downloads/");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Folder to download mod into:");
        directoryChooser.setInitialDirectory(initialDir);
        File chosenDirectory = directoryChooser.showDialog(chooseButton.getScene().getWindow());
        System.out.println(chosenDirectory);
    }

    @FXML
    protected void onDownloadButtonClick()
    {

    }
}
