package com.example.cs180_10_04;
import java.util.Scanner;

public class CardTool1
{
    private static String welcomeMessage = "Welcome to the Trading Card Tool!";
    private static String initialPrompt = "Would you like to add a card?";
    private static String menu = "(1) Common\n" +
            "(2) Uncommon\n" +
            "(3) Super\n" +
            "(4) Rare\n" +
            "(5) Legendary\n" +
            "(6) Exit";
    private static String rarityPrompt = "Enter the card rarity you would like to place in the deck.";
    private static String cardNamePromptOne = "What is the name of the ";
    private static String cardNamePromptTwo = " trading card?";
    private static String anotherPrompt = "Would you like to add another card?";
    private static String totalCostMessage = "The total cost for all the cards you collected today is ";
    private static String receiptMessage = "After collecting the cards, here's your receipt: ";
    private static String collectionMessageOne = "You collected ";
    private static String collectionMessageCommon = " Common card(s).";
    private static String collectionMessageUncommon = " Uncommon card(s).";
    private static String collectionMessageSuper = " Super card(s).";
    private static String collectionnMessageRare = " Rare card(s).";
    private static String collectionMessageLegendary = " Legendary card(s).";
    private static String exitMessage = "Thank you for using the Trading Card Tool!";
    private static String invalidInputMessage = "You chose an invalid menu choice, try again!";

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int common = 0;
        int uncommon = 0;
        int superC = 0;
        int rare = 0;
        int legendary = 0;
        int addRarity;
        String receipt = "";
        boolean printR = true;
        boolean cont = true;
        while(cont = true)
        {
            System.out.println(welcomeMessage);
            System.out.println(initialPrompt);
            String addCard = s.nextLine();
            if (addCard.equals("Yes") || addCard.equals("yes")) {
                System.out.println(menu);
                System.out.println(rarityPrompt);
                addRarity = s.nextInt();
                s.nextLine();
                boolean goAgain = false;
                if (addRarity > 6 || addRarity < 1) {
                    goAgain = true;
                }
                while (goAgain) {
                    System.out.println(invalidInputMessage);
                    System.out.println(menu);
                    System.out.println(rarityPrompt);
                    addRarity = s.nextInt();
                    s.nextLine();
                }
                switch (addRarity) {
                    case 1:
                        common++;
                        System.out.println(cardNamePromptOne + "Common" + cardNamePromptTwo);
                        String addName = s.nextLine();
                        receipt += ("C:" + addName + ';');
                        System.out.println(anotherPrompt);
                        break;
                    case 2:
                        uncommon++;
                        System.out.println(cardNamePromptOne + "Uncommon" + cardNamePromptTwo);
                        String addName1 = s.nextLine();
                        receipt += ("U:" + addName1 + ';');
                        System.out.println(anotherPrompt);
                        break;
                    case 3:
                        superC++;
                        System.out.println(cardNamePromptOne + "Super" + cardNamePromptTwo);
                        String addName2 = s.nextLine();
                        receipt += ("S:" + addName2 + ';');
                        System.out.println(anotherPrompt);
                        String cont3 = s.nextLine();
                        break;
                    case 4:
                        rare++;
                        System.out.println(cardNamePromptOne + "Rare" + cardNamePromptTwo);
                        String addName3 = s.nextLine();
                        receipt += ("R:" + addName3 + ';');
                        System.out.println(anotherPrompt);
                        String cont4 = s.nextLine();
                        break;
                    case 5:
                        legendary++;
                        System.out.println(cardNamePromptOne + "Legendary" + cardNamePromptTwo);
                        String addName4 = s.nextLine();
                        receipt += ("L:" + addName4 + ';');
                        System.out.println(anotherPrompt);
                        break;
                    case 6:
                        System.out.println(exitMessage);
                        cont = false;
                        break;
                }
                String cont1 = s.nextLine();
                if (cont1.equals("Yes") || cont1.equals("yes"))
                {
                    cont = true;
                } else
                {
                    cont = false;
                }
            }
            else
            {
                System.out.println(exitMessage);
                printR = false;
            }
        }
        if(printR)
        {
            receipt = receipt.substring(0,receipt.length()-1);
            double totalCost = (common * 13 + uncommon * 54 + superC * 133
                    + rare * 267 + legendary * 599);
            totalCost = Math.round(totalCost * 100.0) / 100.0;
            System.out.println(totalCostMessage + totalCost + ".");
            System.out.println(receiptMessage + receipt);
            System.out.println(collectionMessageOne + common + collectionMessageCommon);
            System.out.println(collectionMessageOne + uncommon + collectionMessageUncommon);
            System.out.println(collectionMessageOne + superC + collectionMessageSuper);
            System.out.println(collectionMessageOne + rare + collectionnMessageRare);
            System.out.println(collectionMessageOne + legendary + collectionMessageLegendary);
            System.out.println(exitMessage);
        }
    }
}
