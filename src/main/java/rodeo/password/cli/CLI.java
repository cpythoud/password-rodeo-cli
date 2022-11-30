package rodeo.password.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.Option;

import picocli.jansi.graalvm.AnsiConsole;

import java.util.concurrent.Callable;

import static rodeo.password.pgencheck.CharacterGroups.*;

@Command(
        name = "pwdmk",
        version = "Password Rodeo CLI V1.0-SNAPSHOT",
        mixinStandardHelpOptions = true
)
public class CLI implements Callable<Integer> {

    private static final String ESCAPED_SYMBOLS = "!@#$%%&*-_=+|?{}[]()/'\",.;:<>";
    private static final String UNAMBIGUOUS_ESCAPED_SYMBOLS = "!@#$%%&*-_=+|?";

    @Option(names = { "-s", "--symbols" }, defaultValue = "false", description = "Include symbols in password: " + ESCAPED_SYMBOLS)
    private boolean symbols;

    @Option(names = "--min-digits", paramLabel = "<minimum-number-of-digits>", defaultValue = "1", description = "Minimum number of digits the generated password will contain.")
    private int minDigits;

    @Option(names = "--max-digits", paramLabel = "<maximum-number-of-digits>", defaultValue = "3", description = "Maximum number of digits the generated password will contain.")
    private int maxDigits;

    @Option(names = "--min-symbols", paramLabel = "<minimum-number-of-symbols>", defaultValue = "1", description = "Minimum number of symbols the generated password will contain.")
    private int minSymbols;

    @Option(names = "--max-symbols", paramLabel = "<maximum-number-of-symbols>", defaultValue = "2", description = "Maximum number of symbols the generated password will contain.")
    private int maxSymbols;

    @Option(names = { "-l", "--length" }, paramLabel = "<password-length>", defaultValue = "16", description = "Length of generated password.")
    private int length;

    @Option(names = { "--na", "--non-ambiguous" }, defaultValue = "false", description = "Create a password containing only 'non-ambiguous' characters: "
            + UNAMBIGUOUS_LOWER_CASE + UNAMBIGUOUS_UPPER_CASE + UNAMBIGUOUS_DIGITS + UNAMBIGUOUS_ESCAPED_SYMBOLS)
    private boolean unambiguous;

    @Option(names = { "-c", "--count" }, paramLabel = "<count>", defaultValue = "1", description = "How many passwords will be generated (1-1000).")
    private int count;

    @Option(names = { "-q", "--quiet" }, defaultValue = "false", description = "Do not emit anything on the standard output except the password(s) unless an error needs to be reported.")
    private boolean quiet;

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
