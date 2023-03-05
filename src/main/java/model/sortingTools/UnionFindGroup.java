package model.sortingTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UnionFindGroup {
    public static Set<String> getCorrectSetStringLine(File file) {
        Set<String> SetLines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(".*\".*\".*")) {
                    line = line.replace("\"", "");
                    SetLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SetLines;
    }

    public static List<List<String>> getGroupsList(Set<String> lines) {
        List<Map<String, Integer>> groupingByWord = new ArrayList<>();
        List<List<String>> linesGroups = new ArrayList<>();
        Map<Integer, Integer> resultGroups = new HashMap<>();

        for (String line : lines) {
            var values = line.split(";");
            TreeSet<Integer> correctGroup = new TreeSet<>();
            List<VertexRecord> vertexRecords = new ArrayList<>();

            for (int i = 0; i < values.length; i++) {
                var currentValue = values[i];

                if (currentValue.isEmpty()) {
                    continue;
                } else if (groupingByWord.size() == i) {
                    groupingByWord.add(new HashMap<>());
                }

                Map<String, Integer> valuesByGroupNumber = groupingByWord.get(i);
                Integer wordGroupNumber = valuesByGroupNumber.get(currentValue);
                if (wordGroupNumber != null) {
                    while (resultGroups.containsKey(wordGroupNumber))
                        wordGroupNumber = resultGroups.get(wordGroupNumber);
                    correctGroup.add(wordGroupNumber);
                } else {
                    vertexRecords.add(new VertexRecord(currentValue, i));
                }
            }

            int groupNumber;
            if (correctGroup.isEmpty()) {
                groupNumber = linesGroups.size();
                linesGroups.add(new ArrayList<>());
            } else {
                groupNumber = correctGroup.first();
            }
            for (VertexRecord vertexRecord : vertexRecords) {
                if (vertexRecord.value().isEmpty()) {
                    continue;
                }
                groupingByWord.get(vertexRecord.rowNumber()).put(vertexRecord.value(), groupNumber);
            }
            for (int currentGroupNumber : correctGroup) {
                if (currentGroupNumber != groupNumber) {
                    resultGroups.put(currentGroupNumber, groupNumber);
                    linesGroups.get(groupNumber).addAll(linesGroups.get(currentGroupNumber));
                }
            }
            linesGroups.get(groupNumber).add(line);
        }

        return linesGroups.stream()
                .filter(e -> e.size() > 1)
                .sorted((e1, e2) -> e2.size() - e1.size())
                .toList();
    }
}
