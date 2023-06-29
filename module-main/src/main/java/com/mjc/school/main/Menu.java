package com.mjc.school.main;

import com.mjc.school.controller.impl.command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Menu {

    private static final String MENU_TEXT =
            """
                    Enter the number of operation:
                    1 - Create news.
                    2 - Create author.
                    3 - Create tag.
                    4 - Get all news.
                    5 - Get all authors.
                    6 - Get all tags.
                    7 - Get news by id.
                    8 - Get author by id.
                    9 - Get tag by id.
                    10 - Update news.
                    11 - Update author.
                    12 - Update tag.
                    13 - Delete news by id.
                    14 - Delete author by id.
                    15 - Delete tag by id.
                    16 - Get author by news id.
                    17 - Get tags by news id.
                    18 - Get news by various parameter.
                    0 - Exit.
                    """;


    @Autowired
    private final CommandFactory commandFactory;

    private int chosenNumber = -1;

    public Menu(CommandFactory commandFactory) {
        this.commandFactory=commandFactory;
    }

    public void mainController() throws IOException {

        try {
            while (chosenNumber != 0) {
                System.out.println(MENU_TEXT);
                chosenNumber = this.takeNumberFromKeyboard();
                commandFactory.mainController(chosenNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int takeNumberFromKeyboard() throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedreader.readLine());
    }

}
