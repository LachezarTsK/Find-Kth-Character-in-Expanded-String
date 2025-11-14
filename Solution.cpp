
#include <string>
using namespace std;

class Solution {

    static const char EMPTY_SPACE = ' ';

public:
    char kthCharacter(string input, long long targetExpandedIndex) const {
        long long expandedIndex = 0;
        long long expandedLetterInCurrentWord = 0;
        char letterAtTargetExpandedIndex = EMPTY_SPACE;

        for (const auto& letter : input) {
            if (letter == EMPTY_SPACE) {
                expandedLetterInCurrentWord = 0;
            }
            else {
                ++expandedLetterInCurrentWord;
            }

            long long lowerBoundary = expandedIndex;
            long long upperBoundary = expandedIndex;
            upperBoundary += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;

            if (targetExpandedIndex >= lowerBoundary && targetExpandedIndex < upperBoundary) {
                letterAtTargetExpandedIndex = letter;
                break;
            }
            expandedIndex += (expandedLetterInCurrentWord != 0) ? expandedLetterInCurrentWord : 1;
        }
        return letterAtTargetExpandedIndex;
    }
};
