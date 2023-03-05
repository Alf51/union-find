package controlers;

import model.sortingTools.UnionFindGroup;
import view.Display;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class UserInputHandlerController {
    public static void parseUserArgument(String[] userArguments) {
        List<String> userInputArgument = new ArrayList<>(Arrays.asList(userArguments));

        if (userInputArgument.size() < 1) {
            System.out.println("The required file name argument is missing");
            System.exit(1);
        }

        String outPutFile = userInputArgument.get(0);

        File file = new File(outPutFile);
        if (!file.canRead()) {
            System.out.println("Unable to read the file");
            System.exit(1);
        }

        try {
            Set<String> setString = UnionFindGroup.getCorrectSetStringLine(file);
            List<List<String>> resultGroup = UnionFindGroup.getGroupsList(setString);
            Display.writeResult(resultGroup);
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Error during sorting");
            System.exit(1);
        }
    }
}