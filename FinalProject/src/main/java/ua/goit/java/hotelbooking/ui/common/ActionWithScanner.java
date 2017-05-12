package ua.goit.java.hotelbooking.ui.common;

import org.apache.commons.lang3.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public abstract class ActionWithScanner implements Action, Closeable {
    protected Scanner scanner;
    protected CommandLine commandLine;

    public ActionWithScanner() {
        scanner = new Scanner(System.in);
    }

    public String getValidString() {
        String result = scanner.nextLine();
        if (StringUtils.isNotBlank(result)) {
            return result;
        }
        System.out.println("Please input not empty string.");
        return getValidString();
    }

    @Override
    public void execute(CommandLine commandLine) {
        this.commandLine = commandLine;
        try {
            execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            execute();
        }
    }

    public abstract void execute();

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
