package org.flashcard;


import org.flashcard.model.Card;
import org.flashcard.services.CardService;
import org.flashcard.services.ConsoleService;

import java.util.Scanner;

public class FlashCardCLI {
    ConsoleService consoleService = new ConsoleService();
    CardService cardService = new CardService();
    boolean offSetNeeded = true;
    boolean noOffSet = false;

    public FlashCardCLI() {
        Scanner userInput;
    }

    public void run() {
        String[] currentMenu;
        boolean runMenu = true;

        while (runMenu) {
            currentMenu = consoleService.getCurrentMenu();
            consoleService.printMenu(currentMenu);
            int userSelection;

            try {
                if (consoleService.isCurrentMenuMain()) {
                    userSelection = consoleService.promptForInt("Please make a selection: ", offSetNeeded);
                    String menuOption = consoleService.getCurrentMenu()[userSelection];
                    consoleService.setCurrentMenu(consoleService.mainMenuSelection(userSelection));

                    switch (menuOption){
                        case "Search Flash Cards": {
                            System.out.println("search");
                            break;
                        }
                        case "Update Flash Cards":{
                            System.out.println("update");
                            break;
                        }
                        case "Add A Flash Card": {
                            consoleService.printMenu(consoleService.getTopicMenu());
                            int userTopic = consoleService.promptForInt("Please select a topic related to your new card: ", noOffSet);
                            String userQuestion = consoleService.promptForString("Please enter the question for your new card: ");
                            String userAnswer = consoleService.promptForString("Please enter the answer for your new card: ");
                            Card returnedCard = cardService.addCard(new Card(0, userQuestion, userAnswer, userTopic));
                            System.out.println("New card id: " + returnedCard.getId() + " has been created");
                            break;
                        }
                        case "Exit Program": {
                            System.exit(0);
                        }
                    }

                } else if (consoleService.isCurrentMenuSearch()) {
                    userSelection = consoleService.promptForInt("Please make a selection: ", offSetNeeded);
                    consoleService.setCurrentMenu(consoleService.searchMenuSelection(userSelection));
                } else if (consoleService.isCurrentMenuTopic()) {
                    userSelection = consoleService.promptForInt("Please make a selection: ", offSetNeeded);
                    consoleService.setCurrentMenu(consoleService.topicMenuSelection(userSelection));
                }
            } catch (Exception e) {
                System.out.println("Sorry, you did not make a valid selection. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        FlashCardCLI cli = new FlashCardCLI();
        cli.run();
    }
}