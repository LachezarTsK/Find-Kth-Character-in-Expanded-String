
class Solution {

    private companion object {
        const val EMPTY_SPACE = ' '
    }

    fun kthCharacter(input: String, targetExpandedIndex: Long): Char {
        var expandedIndex: Long = 0
        var expandedLetterInCurrentWord: Long = 0
        var letterAtTargetExpandedIndex = EMPTY_SPACE

        for (letter in input) {
            if (letter == EMPTY_SPACE) {
                expandedLetterInCurrentWord = 0
            } else {
                ++expandedLetterInCurrentWord
            }

            val lowerBoundary: Long = expandedIndex
            var upperBoundary = expandedIndex
            upperBoundary += if (expandedLetterInCurrentWord != 0.toLong()) expandedLetterInCurrentWord else 1

            if (targetExpandedIndex in lowerBoundary..<upperBoundary) {
                letterAtTargetExpandedIndex = letter
                break
            }
            expandedIndex += if (expandedLetterInCurrentWord != 0.toLong()) expandedLetterInCurrentWord else 1
        }
        return letterAtTargetExpandedIndex
    }
}
