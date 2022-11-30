package rodeo.password.cli;

import picocli.CommandLine;

import java.io.PrintStream;

class Console {

    private static final PrintStream OUT = System.err;
    private static final String OK = "green";

    private static void println(String message, String color) {
        OUT.println(ansiFormat(message, color));
    }

    private static String ansiFormat(String message, String color) {
        return CommandLine.Help.Ansi.AUTO.string("@|fg(" + color + "),bold " + message + "|@");
    }

    static void ok(String message) {
        println(message, OK);
    }

}
