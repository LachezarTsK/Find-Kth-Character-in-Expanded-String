
function kthCharacter(input: string, targetExpandedIndex: number): string {
    const EMPTY_SPACE = ' ';
    let expandedIndex = 0;
    let expandedLetterInCurrentWord = 0;
    let letterAtTargetExpandedIndex = EMPTY_SPACE;

    for (let letter of input) {
        if (letter === EMPTY_SPACE) {
            expandedLetterInCurrentWord = 0;
        } else {
            ++expandedLetterInCurrentWord;
        }

        let lowerBoundary = expandedIndex;
        let upperBoundary = expandedIndex;
        upperBoundary += (expandedLetterInCurrentWord !== 0) ? expandedLetterInCurrentWord : 1;

        if (targetExpandedIndex >= lowerBoundary && targetExpandedIndex < upperBoundary) {
            letterAtTargetExpandedIndex = letter;
            break;
        }
        expandedIndex += (expandedLetterInCurrentWord !== 0) ? expandedLetterInCurrentWord : 1;
    }
    return letterAtTargetExpandedIndex;
};
