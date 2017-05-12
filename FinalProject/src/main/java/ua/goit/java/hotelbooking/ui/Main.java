package ua.goit.java.hotelbooking.ui;

import ua.goit.java.hotelbooking.ui.common.*;

public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        MainAction mainAction = new MainAction();

        while (true){
            mainAction.execute(commandLine);
        }

    }
}
