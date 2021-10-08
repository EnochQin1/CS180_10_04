package com.example.cs180_10_04;
/**
 * A class that displays a card and its properties.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Exam 1
 *
 * @author Enoch_Qin Purdue CS
 * @version October 4, 2021
 */
public class Card
{
    private String rarity;
    private String name;
    private String brand;
    private boolean isLimited;
    private double basePrice;

    public Card(String rarity, String name, String brand, boolean isLimited, double basePrice)
    {
        this.rarity = rarity;
        this.name = name;
        this.brand = brand;
        this.isLimited = isLimited;
        this.basePrice = basePrice;
    }
    public String getName()
    {
        return this.name;
    }
    public String getBrand()
    {
        return this.brand;
    }
    public String getRarity()
    {
        return this.rarity;
    }
    public boolean getLimited()
    {
        return this.isLimited;
    }
    public double getBasePrice()
    {
        return this.basePrice;
    }
    public void setRarity(String rarity)
    {
        this.rarity = rarity;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public void setLimited(boolean limited)
    {
        this.isLimited = limited;
    }
    public void setBasePrice(double basePrice)
    {
        this.basePrice = basePrice;
    }
    public double calculateModifiedPrice()
    {
        double modPrice = 0;
        if (this.rarity.equals("Common"))
        {
            modPrice = basePrice * 13;
        }
        else if (this.rarity.equals("Uncommon"))
        {
            modPrice = basePrice * 54;
        }
        else if (this.rarity.equals("Super"))
        {
            modPrice = basePrice * 133;
        }
        else if (this.rarity.equals("Rare"))
        {
            modPrice = basePrice * 267;
        }
        else if (this.rarity.equals("Legendary"))
        {
            modPrice = basePrice * 599;
        }
        modPrice = Math.round(modPrice * 100.00) / 100.00;
        return modPrice;
    }
    public String toString()
    {
        return "Card<rarity=" + this.getRarity() +
                ", name=" + this.getName() +
                ", brand=" + this.getBrand() +
                ", isLimited=" + this.getLimited() +
                ", basePrice=" + String.format("%.2f", this.getBasePrice()) +
                ">";
    }
    public static void main(String[] args)
    {
    }
}
