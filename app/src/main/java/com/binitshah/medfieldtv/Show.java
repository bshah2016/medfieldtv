package com.binitshah.medfieldtv;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Binit on 7/10/15.
 */
public class Show {
    private String title, thumbnailUrl, description, times, fulltimes;
    private Date stime, etime;
    private ArrayList<String> genre;
    private String videoID, publishedAtTime, videoTitle, videoDescription, videoThumbnailURL;


    private static final String TAG = Show.class.getSimpleName();

    public Show() {
    }

    public Show(String name, String thumbnaillUrl, String descriptionn, Date starttimes, Date endtimes,
                 ArrayList<String> genre) {
        this.title = name;
        this.thumbnailUrl = thumbnaillUrl;
        this.description = descriptionn;
        this.stime = starttimes;
        this.etime = endtimes;
        this.genre = genre;
    }

    public Show(String vidID,String name, String thumbnaillUrl, String descriptionn, String pubTime) {
        this.videoID = vidID;
        this.videoThumbnailURL = thumbnaillUrl;
        this.videoDescription = descriptionn;
        this.videoTitle = name;
        this.publishedAtTime = pubTime;
    }

    public String getVideoTitle() { return videoTitle; }

    public void setVideoTitle(String vidName) { this.videoTitle = vidName; }

    public String getVideoDescription() { return videoDescription; }

    public void setVideoDescription(String vidDescrip) { this.videoDescription = vidDescrip; }

    public String getVideoID() { return videoID; }

    public void setVideoID(String tempvidID) { this.videoID = tempvidID; }

    public String getVideoThumbnailURL() { return videoThumbnailURL; }

    public void setVideoThumbnailURL(String tempThumbnailURL) { this.videoThumbnailURL = tempThumbnailURL; }

    public String getPublishedAtTime() { return publishedAtTime; }

    public void setPublishedAtTime(String tempTime) { this.publishedAtTime = tempTime; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String tempDescription) {
        this.description = tempDescription;
    }

    public String getTimes() {
        if(times != null){
            return times;
        }
        else{
            return "Times not found";
        }
    }

    public String getFullTimes() {
        if(times != null){
            return fulltimes;
        }
        else{
            return "Times not found";
        }
    }

    public void setStartandEndTime(String startTime, String endTime) {
        DateFormat df = new SimpleDateFormat("MM dd yyyy kk:mm:ss", Locale.ENGLISH);
        DateFormat simpleFormat0 = new SimpleDateFormat("MMMM dd, hh:mm aa", Locale.ENGLISH);
        DateFormat simpleFormat1 = new SimpleDateFormat("EEE hh:mm aa", Locale.ENGLISH);
        DateFormat simpleFormat2 = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);

        try {
            stime = df.parse(startTime);
            etime = df.parse(endTime);

            this.times = simpleFormat1.format(stime) + " - " + simpleFormat2.format(etime);
            this.fulltimes = simpleFormat0.format(stime) + " - " + simpleFormat2.format(etime);
        }
        catch(ParseException e){
            this.times = "Error parsing time..";
            Log.e(TAG, "setStartandEndTime error");
        }
    }

    public Boolean isCurrentShow(){
        Date currentTime = new Date();

        try {
            if (currentTime.after(stime) && currentTime.before(etime)) {
                //Log.w(TAG, "true - " + title + " - Current: " + currentTime + "start: " + stime + "end: " + etime);
                return true;
            } else {
                //Log.w(TAG, "false - " + title + " - Current: " + currentTime + "start: " + stime + "end: " + etime);
                return false;
            }
        }
        catch(NullPointerException e){
            Log.e(TAG, "isCurrentShow has empty stime and etime");
            return false;
        }
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

}