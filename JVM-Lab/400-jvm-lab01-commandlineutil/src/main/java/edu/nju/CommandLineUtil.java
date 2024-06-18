package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {
    private static CommandLine commandLine;
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();
    private boolean sideEffect;
    public static final String WRONG_MESSAGE = "Invalid input.";

    public void initOption() {
        CommandLineUtil.options.addOption("h", "help", false, "display all defined options");
        Option print = Option.builder("p").longOpt("print").hasArg().argName("print").desc("print the input string")
                .build();
        CommandLineUtil.options.addOption(print);
        CommandLineUtil.options.addOption("s", false, "set side effect");
    }

    public void setSideEffect(boolean sideEffect) {
        this.sideEffect = sideEffect;
    }

    static {
    }

    public void main(String[] args) {
        initOption();
        this.parseInput(args);
        this.handleOptions();

    }

    /**
     * Print the usage of all options
     */
    private static void printHelpMessage() {
        System.out.println("help");
    }

    /**
     * Parse the input and handle exception
     * 
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException exp) {
            System.err.println(exp.getMessage());
            System.exit(-1);
        }
    }

    public void handleOptions() {
        if (commandLine.getArgList().size() == 0) {
            System.out.println(WRONG_MESSAGE);
            return;
        }
        if (commandLine.hasOption("h")) {
            printHelpMessage();
            return;
        }
        if (commandLine.hasOption("p")) {
            String optionVal = commandLine.getOptionValue("p");
            if (optionVal == null) {
                System.out.println("Missing argument for option: p");
                System.exit(-1);
            } else {
                System.out.println(optionVal);
            }
        }
        if (commandLine.hasOption("s")) {
            setSideEffect(true);
        }

    }

    public boolean getSideEffectFlag() {
        return this.sideEffect;
    }

}
