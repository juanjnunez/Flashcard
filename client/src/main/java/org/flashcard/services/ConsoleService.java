package org.flashcard.services;

import org.flashcard.model.Card;

import java.util.Scanner;

public class ConsoleService {
    private final String EXIT = "Exit Program";
    private final String RETURN_MAIN_MENU = "Back To Main Menu";
    private final String MENU_ITEM_FORMAT = "(%d) %s";

    //Main Menu
    private final String MAIN_MENU_SEARCH = "Search Flash Cards";
    private final String MAIN_MENU_UPDATE = "Update Flash Cards";
    private final String MAIN_MENU_ADD = "Add A Flash Card";
    private final String[] mainMenu = new String[]{MAIN_MENU_SEARCH, MAIN_MENU_UPDATE, MAIN_MENU_ADD, EXIT};

    //Search Menu
    private final String SEARCH_MENU_BY_TOPIC = "Search Cards By Topic";
    private final String SEARCH_MENU_BY_ID = "Search Cards By ID Number";
    private final String SEARCH_MENU_BY_QUESTION = "Search Cards By Question Keyword";
    private final String SEARCH_MENU_BY_ANSWER = "Search Cards By Answer Keyword";
    private final String[] searchMenu = new String[]{SEARCH_MENU_BY_TOPIC, SEARCH_MENU_BY_ID, SEARCH_MENU_BY_QUESTION, SEARCH_MENU_BY_ANSWER, EXIT};

    // Topic Menu
    private final String TOPIC_MENU_JAVA = "Relate Question to Java";
    private final String TOPIC_MENU_DATABASE = "Relate Question to Databases";
    private final String TOPIC_MENU_API = "Relate Question to API";
    private final String TOPIC_MENU_NETWORKING = "Relate Question to Networking";
    private final String[] topicMenu = new String[]{TOPIC_MENU_JAVA, TOPIC_MENU_DATABASE, TOPIC_MENU_API, TOPIC_MENU_NETWORKING, RETURN_MAIN_MENU};
    private String[] currentMenu = mainMenu;
    private final int selectionOffSetToIndex = 1;
    Scanner userInput = new Scanner(System.in);

    //Setters and Getters
    public String[] getCurrentMenu(){
        return currentMenu;
    }
    public void setCurrentMenu(String[] currentMenu){
        this.currentMenu = currentMenu;
    }
    public String[] getTopicMenu(){
        return topicMenu;
    }

    //Methods
    public boolean isCurrentMenuMain (){
        boolean results = false;

        if (currentMenu == mainMenu){
            results = true;
        }
        return results;
    }
    public boolean isCurrentMenuSearch (){
        boolean results = false;

        if (currentMenu == searchMenu){
            results = true;
        }
        return results;
    }

    public boolean isCurrentMenuTopic (){
        boolean results = false;

        if (currentMenu == topicMenu){
            results = true;
        }
        return results;
    }
    public void printMenu(String[] menu){
        System.out.println("*************************\n");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(MENU_ITEM_FORMAT, i + 1, menu[i] + "\n");
        }
        System.out.println("\n*************************");
    }
    public int promptForInt(String prompt, Boolean isOffSetNeeded){
        System.out.print(prompt);
        int input = isOffSetNeeded ? userInput.nextInt() - selectionOffSetToIndex : userInput.nextInt();
        userInput.nextLine();
        return input;
    }
    public String promptForString(String prompt){
        System.out.println(prompt);
        return userInput.nextLine();
    }
    public String[] mainMenuSelection(int userSelection) {
        String menuOption = currentMenu[userSelection];
        switch (menuOption) {
            case MAIN_MENU_SEARCH -> currentMenu = searchMenu;
            case MAIN_MENU_UPDATE, MAIN_MENU_ADD -> currentMenu = mainMenu;
        }
        return currentMenu;
    }
    public String[] searchMenuSelection(int userSelection){
        String menuOption = currentMenu[userSelection];
        if (menuOption.equals(SEARCH_MENU_BY_TOPIC)) {
            currentMenu = topicMenu;
        }
        return currentMenu;
    }
    public String[] topicMenuSelection(int userSelection){
        String menuOption = currentMenu[userSelection];
        if (menuOption.equals(TOPIC_MENU_JAVA)) {
            //Todo: Add Java Question List
            System.out.println("This is the list of Java questions");
            currentMenu = mainMenu;
        }
        return currentMenu;
    }


}
