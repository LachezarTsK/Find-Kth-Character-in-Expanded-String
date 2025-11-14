
using System;

public class Solution
{
    private static readonly char EMPTY_SPACE = ' ';

    public char KthCharacter(string input, long targetExpandedIndex)
    {
        long expandedIndex = 0;
        long expandedLetterInCurrentWord = 0;
        char letterAtTargetExpandedIndex = EMPTY_SPACE;

        foreach (char letter in input)
        {
            if (letter == EMPTY_SPACE)
            {
                expandedLetterInCurrentWord = 0;
            }
            else
            {
                ++expandedLetterInCurrentWord;
            }

            long lowerBoundary = expandedIndex;
            long upperBoundary = expandedIndex;
            upperBoundary += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;

            if (targetExpandedIndex >= lowerBoundary && targetExpandedIndex < upperBoundary)
            {
                letterAtTargetExpandedIndex = letter;
                break;
            }
            expandedIndex += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;
        }
        return letterAtTargetExpandedIndex;
    }
}
