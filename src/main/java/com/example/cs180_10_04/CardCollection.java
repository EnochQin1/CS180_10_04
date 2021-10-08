package com.example.cs180_10_04;

import java.util.Locale;

/**
 * A class that displays a card collection and its properties.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Exam 1
 *
 * @author Enoch_Qin Purdue CS
 * @version October 4, 2021
 */
public class CardCollection
{
    private int numCommon;
    private int numUncommon;
    private int numSuper;
    private int numRare;
    private int numLegendary;

    public CardCollection(int numCommon, int numUncommon, int numSuper, int numRare, int numLegendary)
    {
        this.numCommon = numCommon;
        this.numUncommon = numUncommon;
        this.numSuper = numSuper;
        this.numRare = numRare;
        this.numLegendary = numLegendary;
    }

    public int getNumCommon()
    {
        return this.numCommon;
    }
    public int getNumUncommon()
    {
        return this.numUncommon;
    }
    public int getNumSuper()
    {
        return this.numSuper;
    }
    public int getNumRare()
    {
        return this.numRare;
    }
    public int getNumLegendary()
    {
        return this.numLegendary;
    }
    public void setNumCommon(int numCommon)
    {
        this.numCommon = numCommon;
    }
    public void setNumUncommon(int numUncommon)
    {
        this.numUncommon = numUncommon;
    }
    public void setNumSuper(int numSuper)
    {
        this.numSuper = numSuper;
    }
    public void setNumRare(int numRare)
    {
        this.numRare = numRare;
    }
    public void setNumLegendary(int numLegendary)
    {
        this.numLegendary = numLegendary;
    }
    public double calculatePercentageByRarity(String rarity1)
    {
        double percent;
        String common = "common";
        String uncommon = "uncommon";
        String super1 = "super";
        String rare = "rare";
        String legendary = "legendary";
        rarity1 = rarity1.toLowerCase();
        if (rarity1.equals(common))
        {
            percent = (double)numCommon / (numCommon + numUncommon + numSuper + numRare + numLegendary);
        } else if (rarity1.equals(uncommon))
        {
            percent = (double)numUncommon / (numCommon + numUncommon + numSuper + numRare + numLegendary);
        } else if (rarity1.equals(super1))
        {
            percent = (double)numSuper / (numCommon + numUncommon + numSuper + numRare + numLegendary);
        } else if (rarity1.equals(rare))
        {
            percent = (double)numRare / (numCommon + numUncommon + numSuper + numRare + numLegendary);
        } else if (rarity1.equals(legendary))
        {
            percent = (double)numLegendary / (numCommon + numUncommon + numSuper + numRare + numLegendary);
        }
        else
        {
            percent = 0.0;
        }
        return percent;
    }

    public double calculateTotalCollectionValue()
    {
        return (this.numCommon * 13 + this.numUncommon * 54 + this.numSuper * 133
                + this.numRare * 267 + this.numLegendary * 599);
    }

    public String toString()
    {
        return "CardCollection<numCommon=" + this.getNumCommon()
                + ",\nnumUncommon=" + this.getNumUncommon()
                + ",\nnumSuper=" + this.getNumSuper()
                + ",\nnumRare=" + this.getNumRare()
                + ",numLegendary=" + this.getNumLegendary() + ">";
    }
    public static void main(String[] args)
    {
        CardCollection test1 = new CardCollection(15, 10,
                5, 3, 4);
        System.out.println(test1.toString());
    }
}
