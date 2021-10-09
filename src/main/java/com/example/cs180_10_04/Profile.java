package com.example.cs180_10_04;


/**
 * Homework 7 - Profile
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 */
public class Profile {
    /**
     * Username of the user
     */
    private final String username;
    /**
     * An array containing channels subscribed to by this user.
     */
    private Channel[] subscribed;
    /**
     * Number of channels subscribed to by this user
     */
    private int numSubscribed;

    public Profile(String username1)
    {
        this.username = username1;
        this.numSubscribed = 0;
        this.subscribed = new Channel[100];
    }
    public Channel findChannel(String username1)
    {
        for (int i = 0; i < this.subscribed.length; i++)
        {
            if (username1.equals(this.subscribed[i].getChannelName()))
            {
                return this.subscribed[i];
            }
        }
        return null;
    }
    public Channel[] getSubscribed() { return this.subscribed; }
    public String getUsername() { return this.username; }
    public void setSubscribed(Channel[] subscribed1, int numSubscribed1)
    {
        this.subscribed = subscribed1;
        this.numSubscribed = numSubscribed1;
    }
    public boolean subscribeToChannel(Channel channel)
    {
        this.numSubscribed++;
        channel.addChannelSubscriber();
        if (this.subscribed[99] != null)
        {
            return false;
        } else
        {
            for (int i = 0; i < this.subscribed.length; i++)
            {
                if (this.subscribed[i] == null)
                {
                    this.subscribed[i] = channel;
                    return true;
                }
                if (this.subscribed[i].equals(channel))
                {
                    return false;
                }
            }
        }
        return false;
    }
    public String toString()
    {
        return String.format("Profile[%s]", this.username);
    }
}
