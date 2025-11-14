
package main
const EMPTY_SPACE byte = ' '

func kthCharacter(input string, targetExpandedIndex int64) byte {
    var expandedIndex int64 = 0
    var expandedLetterInCurrentWord int64 = 0
    letterAtTargetExpandedIndex := EMPTY_SPACE

    for i := range input {
        if input[i] == EMPTY_SPACE {
            expandedLetterInCurrentWord = 0
        } else {
            expandedLetterInCurrentWord++
        }

        lowerBoundary := expandedIndex
        upperBoundary := expandedIndex
        upperBoundary += Ternary(expandedLetterInCurrentWord != 0, expandedLetterInCurrentWord, 1)

        if targetExpandedIndex >= lowerBoundary && targetExpandedIndex < upperBoundary {
            letterAtTargetExpandedIndex = input[i]
            break
        }
        expandedIndex += Ternary(expandedLetterInCurrentWord != 0, expandedLetterInCurrentWord, 1)
    }
    return letterAtTargetExpandedIndex
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
