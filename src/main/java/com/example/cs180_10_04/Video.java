package com.example.cs180_10_04;

/**
 * Homework 7 - Video
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 */
public class Video{
    /**
     * Name of the video.
     */
    private final String videoName;
    /**
     * Channel which created the video.
     */
    private final Channel channel;
    /**
     * Length of video in seconds
     */
    private final int duration;
    /**
     * Number of views for the video, initialized at zero.
     */
    private int numViews;

    public Video(String videoName1, Channel channel1, int minutes, int seconds)
    {
        this.channel = channel1;
        this.videoName = videoName1;
        numViews = 0;
        duration = (minutes * 60 + seconds);
    }

    public void addView() {numViews++;}
    public Channel getChannel() {return this.channel;}
    public String getDuration() {return duration / 60 + ":" + duration % 60;}
    public String getVideoName() {return this.videoName;}
    public int getViews() {return this.numViews;}
    public void setViews(int numViews) {this.numViews = numViews;}
    public String toString()
    {
        return String.format("Video[%s,%s,%s,%d]", this.videoName,
            this.channel.getChannelName(), this.getDuration(), this.numViews);
    }
}
