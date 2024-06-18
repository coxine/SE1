import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Command {
    private int[] fieldsID;
    private int orderByFieldID;
    private int limit;

    public Command() {
        this.fieldsID = new int[0];
        this.orderByFieldID = -1;
        this.limit = 0;
    }

    public int[] getFieldsID() {
        return fieldsID;
    }

    public int getLimit() {
        return limit;
    }

    public int getOrderByFieldID() {
        return orderByFieldID;
    }

    public void setFieldsID(int[] fieldsID) {
        this.fieldsID = fieldsID;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOrderByFieldID(int orderByFieldID) {
        this.orderByFieldID = orderByFieldID;
    }
}

public class testCSVFile {
    static String[] FieldsofCsv = { "Last_name", "First_name", "Salary", "Department", "Employee_id" };

    private static String[][] getCsv(String filePath) {
        List<String[]> csvList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] row = line.split(",");
                csvList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0][0];
        }
        String[][] csv = new String[csvList.size()][];
        csv = csvList.toArray(csv);
        return csv;
    }

    private static Command parseCommand(String[][] csv) {
        Command command = new Command();

        // Read command
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        scanner.close();

        // Parse command
        for (int i = 0; i < parts.length; i++) {
            switch (parts[i]) {
                case "select":
                    String[] selectFields = parts[i + 1].split(",");
                    if (selectFields[0].equals("*")) {
                        int[] fieldsID = new int[csv[0].length];
                        for (int j = 0; j < csv[0].length; j++) {
                            fieldsID[j] = j;
                        }
                        command.setFieldsID(fieldsID);
                    } else {
                        int[] fieldsID = new int[selectFields.length];
                        for (int j = 0; j < selectFields.length; j++) {
                            fieldsID[j] = Arrays.asList(FieldsofCsv).indexOf(selectFields[j]);
                        }
                        command.setFieldsID(fieldsID);
                    }
                    i++;
                    break;
                case "order":
                    int orderByFieldID = Arrays.asList(FieldsofCsv).indexOf(parts[i + 2]);
                    command.setOrderByFieldID(orderByFieldID);
                    i += 2;
                    break;

                case "limit":
                    command.setLimit(Integer.parseInt(parts[i + 1]));
                    i++;
                    break;

                default:
                    break;
            }
        }
        if (command.getLimit() == 0) {
            command.setLimit(csv.length);
        }
        return command;
    }

    private static void printResult(String[][] csv, Command command) {
        if (command.getOrderByFieldID() != -1) {
            Arrays.sort(csv, new Comparator<String[]>() {
                public int compare(String[] a, String[] b) {
                    int valInA = Integer.parseInt(a[command.getOrderByFieldID()]);
                    int valInB = Integer.parseInt(b[command.getOrderByFieldID()]);
                    return valInB - valInA;
                }

            });
        }
        for (int i = 0; i < command.getFieldsID().length; i++) {
            System.out.printf("%s", FieldsofCsv[command.getFieldsID()[i]]);
            System.out.printf("%s", (i == command.getFieldsID().length - 1) ? "\n" : "    ");
        }
        for (int i = 0; i < command.getLimit(); i++) {
            for (int j = 0; j < command.getFieldsID().length; j++) {
                System.out.printf("%s", csv[i][command.getFieldsID()[j]]);
                System.out.printf("%s", (j == command.getFieldsID().length - 1) ? "\n" : "    ");
            }
        }
    }

    public static void main(String[] args) {
        String[][] csv = getCsv(args[0]);
        Command command = parseCommand(csv);
        printResult(csv, command);
    }

}
