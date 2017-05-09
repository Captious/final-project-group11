package ua.goit.java.hotelbooking.ui.common;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public abstract class ActionWithScanner implements Action, Closeable {
    protected Scanner scanner;

    public ActionWithScanner() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
