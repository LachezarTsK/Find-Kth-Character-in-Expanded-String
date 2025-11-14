
public class Solution {

    private static final char EMPTY_SPACE = ' ';

    public char kthCharacter(String input, long targetExpandedIndex) {
        long expandedIndex = 0;
        long expandedLetterInCurrentWord = 0;
        char letterAtTargetExpandedIndex = EMPTY_SPACE;

        for (char letter : input.toCharArray()) {
            if (letter == EMPTY_SPACE) {
                expandedLetterInCurrentWord = 0;
            } else {
                ++expandedLetterInCurrentWord;
            }

            long lowerBoundary = expandedIndex;
            long upperBoundary = expandedIndex;
            upperBoundary += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;

            if (targetExpandedIndex >= lowerBoundary && targetExpandedIndex < upperBoundary) {
                letterAtTargetExpandedIndex = letter;
                break;
            }
            expandedIndex += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;
        }
        return letterAtTargetExpandedIndex;
    }
}
