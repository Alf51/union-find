package view;

import java.util.List;

public class Display {
    public void writeResult(List<List<String>> listGroup) {

    }

    public static void printListGroup(List<List<String>> listGroup) {
        System.out.println("the number of groups with more than one element received: " + listGroup.size());
        System.out.println();
        for (int i = 0; i < listGroup.size(); i++) {
            List<String> groupss = listGroup.get(i);
            if (groupss.size() != 1) {
                System.out.println("Group number " + (i + 1));
                for (String s : groupss) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }
        System.out.println("the number of groups with more than one element received: " + listGroup.size());
    }
}
