package Week5;

import java.util.Arrays;

public class SearchSortMiniTool {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 90, 66, 88, 95, 73};
        int target = 90;

        int foundIndex = -1; 
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                foundIndex = i;
                break;  
            }
        }

        if (foundIndex != -1) {
            System.out.println("Target " + target + " was found at index " + foundIndex);
        } else {
            System.out.println("Target " + target + " was not found");
        }

        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        // WHY SORT A COPY: sorting the original would rearrange its elements,
        // so the original order (and the index found by the search above)
        // would be lost. Sorting a copy keeps the original data unchanged
        // while still letting us see the sorted version.

        System.out.println("Original array: " + Arrays.toString(scores));
        System.out.println("Sorted copy:    " + Arrays.toString(sortedScores));
    }
}
