package com.tw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputHandle {
    private final Scanner scanner;
    public final PrintStream out;

    public InputHandle(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String message) {
        out.println(message);
        return scanner.nextLine();
    }
}
