package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Display {
    private static final String NUMBER_GROUP_MESSAGE = "the number of groups with more than one element received: ";
    private static final String GROUP_NUMBER = "Group number ";

    public static void writeResult(List<List<String>> listGroup) {
        File outputFile = new File("result.txt");

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            System.out.println(NUMBER_GROUP_MESSAGE + listGroup.size());
            bufferedWriter.write(NUMBER_GROUP_MESSAGE + listGroup.size() + "\n");
            for (int i = 0; i < listGroup.size(); i++) {
                List<String> groupss = listGroup.get(i);
                if (groupss.size() != 1) {
                    bufferedWriter.write(GROUP_NUMBER + (i + 1) + "\n");
                    for (String s : groupss) {
                        bufferedWriter.write(s+ "\n");
                    }
                    bufferedWriter.write("\n");
                }
            }
            System.out.println("The result is located in the root of the program in a file named " + outputFile);
        } catch (IOException e) {
            System.out.println("Failed to create a file to record the result");
            printListGroup(listGroup);
        }
    }

    private static void printListGroup(List<List<String>> listGroup) {
        System.out.println(NUMBER_GROUP_MESSAGE + listGroup.size());
        System.out.println();
        for (int i = 0; i < listGroup.size(); i++) {
            List<String> groupss = listGroup.get(i);
            if (groupss.size() != 1) {
                System.out.println(GROUP_NUMBER + (i + 1));
                for (String s : groupss) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }
        System.out.println(NUMBER_GROUP_MESSAGE + listGroup.size());
    }
}
