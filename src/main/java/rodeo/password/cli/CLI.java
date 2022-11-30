package rodeo.password.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;

import picocli.jansi.graalvm.AnsiConsole;


import java.util.concurrent.Callable;

@Command(
        name = "nutrimenu-json",
        version = "RESCO Nutrimenu JSON Retriever"
)
public class CLI implements Callable<Integer> {

    public static void main(String[] args) {
        int exitCode;
        try (AnsiConsole ansi = AnsiConsole.windowsInstall()) {
            exitCode = new CommandLine(new CLI()).execute(args);
        }
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        Console.ok("*** Password Rodeo CLI ***");
        return ExitCode.OK;
    }

}
