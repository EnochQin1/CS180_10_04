package com.example.cs180_10_04;


/**
 * Homework 7 - Channel
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 */
public class Channel {
    /**
     * Name of the channel
     */
    private final String channelName;
    /**
     * Number of subscribers of this channel
     */
    private int channelSubscribers;
    /**
     * Number of videos uploaded by this channel. This may be of use when iterating through the videos array.
     */
    private int numUploads;
    /**
     * An array containing videos uploaded by this creator.
     */
    private Video[] videos;

    public Channel(String channelName1)
    {
        this.channelName = channelName1;
        this.channelSubscribers = 0;
        this.numUploads = 0;
        this.videos = new Video[100];
    }

    public Channel(String channelName1, int channelSubscribers1, int numUploads1, Video[] videos1)
    {
        this.channelName = channelName1;
        this.channelSubscribers = channelSubscribers1;
        this.numUploads = numUploads1;
        this.videos = videos1;
    }

    public void addChannelSubscriber() { channelSubscribers++; }
    public Video findVideo(String videoName)
    {
        for (int i = 0; i < this.videos.length; i++)
        {
            if (videoName.equals(this.videos[i].getVideoName()))
            {
                return this.videos[i];
            }
        }
        return null;
    }
    public String getChannelName() { return this.channelName; }
    public int getChannelSubscribers() { return this.channelSubscribers; }
    public int getNumUploads() { return this.numUploads; }
    public int getTotalViews()
    {
        int totalViews = 0;
        for (int i = 0; i < this.videos.length; i++)
        {
            if (this.videos[i] != null)
            {
                totalViews += this.videos[i].getViews();
            }
        }
        return totalViews;
    }
    public Video[] getVideos() { return this.videos; }
    public void setChannelSubscribers(int channelSubscribers) { this.channelSubscribers = channelSubscribers; }
    public void setVideos(Video[] videos1, int numUploads1)
    {
        this.videos = videos1;
        this.numUploads = numUploads1;
    }
    public String toString()
    {
        return String.format("Channel[%s,%d,%d]", this.channelName,
                this.channelSubscribers, this.numUploads);
    }
    public boolean uploadVideo(Video video)
    {
        if (this.videos[99] != null)
        {
            return false;
        } else
        {
            for (int i = 0; i < this.videos.length; i++)
            {
                if (this.videos[i] == null)
                {
                    this.videos[i] = video;
                    this.numUploads++;
                    return true;
                }
                if (this.videos[i].equals(video))
                {
                    return false;
                }
            }
        }
        return false;
    }
}