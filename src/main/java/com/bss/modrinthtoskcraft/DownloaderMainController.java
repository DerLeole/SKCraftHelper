package com.bss.modrinthtoskcraft;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.controlsfx.tools.Utils;

import java.io.File;

public class DownloaderMainController
{
    //UI Variables
    @FXML
    private TextField urlField;
    @FXML
    private TextField downloadPathField;
    @FXML
    private ProgressBar downloadProgressBar;
    @FXML
    private Button chooseButton;
    @FXML
    private TextArea logArea;

    //Other Variables

    //Button Actions
    @FXML
    protected void onChooseButtonClick()
    {
        String home = System.getProperty("user.home");
        File initialDir = new File(home+"/Downloads/");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Folder to download mod into:");
        directoryChooser.setInitialDirectory(initialDir);
        File downloadPath = directoryChooser.showDialog(chooseButton.getScene().getWindow());

        downloadPathField.setText(downloadPath.getAbsolutePath());

        DownloaderMain.getInstance().setDownloadPath(downloadPath);
    }

    @FXML
    protected void onDownloadButtonClick()
    {
        downloadProgressBar.setProgress(0);
        DownloaderMain.getInstance().startDownload(urlField.getText());
    }

    @FXML
    protected void onPasteAndLoadButtonClick()
    {
        String url = Clipboard.getSystemClipboard().getString();
        urlField.setText(url);
        DownloaderMain.getInstance().startDownload(url);
    }

    //Getters and Setters
    public TextField getUrlField()
    {
        return urlField;
    }

    public TextField getDownloadPathField()
    {
        return downloadPathField;
    }

    public ProgressBar getDownloadProgressBar()
    {
        return downloadProgressBar;
    }

    public Button getChooseButton()
    {
        return chooseButton;
    }

    public TextArea getLogArea()
    {
        return logArea;
    }

}
