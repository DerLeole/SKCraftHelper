package com.bss.modrinthtoskcraft;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class DownloaderMain extends Application
{
    //UI Variables
    DownloaderMainController controller;

    //Variables
    private static DownloaderMain instance;
    private static Stage stage;
    private File downloadPath;

    //Constructor
    public DownloaderMain()
    {
        //Saves instance
        instance = this;
    }

    //Functions
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        //Starts up the JavaFX Window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("downloader-main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("SKCraft Helper");
        stage.setScene(scene);
        stage.show();

        //Save Controller
        controller = ((DownloaderMainController) fxmlLoader.getController());

        //Gets Default Download Folder
        String home = System.getProperty("user.home");
        controller.getDownloadPathField().setText(home+"\\Downloads");
    }

    public void startDownload(String url)
    {
        URL downloadURL;

        //Tries to convert the url string into URL
        try
        {
             downloadURL = new URL(url);

        } catch (MalformedURLException e)
        {
            //TODO: Throw visual exception
            controller.getUrlField().setText("Invalid URL");
            return;
        }

        //Downloads the file
        try
        {
            FileUtils.copyURLToFile(downloadURL, new File(downloadPath, FilenameUtils.getName(url)));
            File linkTextFile = new File(downloadPath, FilenameUtils.getName(url) + ".url.txt");
            controller.getDownloadProgressBar().setProgress(0.5f);
            FileUtils.writeStringToFile(linkTextFile, url, "UTF-8");
            controller.getDownloadProgressBar().setProgress(1.0f);
            controller.getLogArea().appendText("Downloaded: " + FilenameUtils.getName(url) + "\n");
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        System.out.println("Downloading: "+FilenameUtils.getName(downloadURL.getPath()));
    }

    //Getters and Setters
    public static DownloaderMain getInstance()
    {
        return instance;
    }

    public static Stage getStage()
    {
        return stage;
    }

    public File getDownloadPath()
    {
        return downloadPath;
    }

    public void setDownloadPath(File downloadPath)
    {
        this.downloadPath = downloadPath;
    }
}
