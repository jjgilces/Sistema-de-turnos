/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.fxml.FXML;
import javafx.scene.media.MediaView;
import TDA.CircularSimplyLinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author user
 */
public class VisorVideos {
    private MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;

    
    
    public VisorVideos(MediaView mediaVideo){
        this.mediaView = mediaVideo;
    }

    
    public void initMediaPlayer(){
        String file = this.getClass().getResource("/recursos/videos/video1.mp4").toExternalForm();
          Media media = new Media(file);
          mediaPlayer = new MediaPlayer(media);
          mediaPlayer.setAutoPlay(true);
          mediaView.setMediaPlayer(mediaPlayer);
       
    }
    private void initMediaPlayer(final MediaView mediaView, final Iterator<String> urls) {
//            MediaPlayer mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(urlsVideos.next()).toExternalForm()));
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    initMediaPlayer(mediaView, (Iterator<String>) urls);
                }
            });
            mediaView.setMediaPlayer(mediaPlayer);
        

    }
   
}
