public class BowlingGame {

    static int maxFrame = 10;
    int totalScore = 0;
    int frameCount = 0;
    int frameScore = 0;
    int frameThrow = 0;
    int hitNumOrder = 0;
    int[] extraScoreFlag = {0, 0, 0};

    public int Bowling(int[] frameHitNum) {
        while (frameCount < maxFrame) {
            frameThrow += 1;
            extraScoreFlagSet();
            if (extraScoreFlag[0] != 0) {
                totalScore += frameHitNum[hitNumOrder] * extraScoreFlag[0];
            }
            totalScore += frameHitNum[hitNumOrder];
            frameScore += frameHitNum[hitNumOrder];
            if (frameCount + 1 != maxFrame) {
                if (frameThrow == 2) {
                    if (frameScore == 10) {
                        extraScoreFlag[1]++;
                    }
                    nextFrame();
                }
                else if (frameScore == 10) {
                    extraScoreFlag[1]++;
                    extraScoreFlag[2]++;
                    nextFrame();
                }
            }
            else {
                if (frameThrow == 3) {
                    frameCount++;
                }
            }
            hitNumOrder++;
        }
        return totalScore;
    }

    private int[] extraScoreFlagSet() {
        extraScoreFlag[0] = extraScoreFlag[1];
        extraScoreFlag[1] = extraScoreFlag[2];
        extraScoreFlag[2] = 0;
        return extraScoreFlag;
    }

    private void nextFrame(){
        frameCount++;
        frameScore = 0;
        frameThrow = 0;
    }

}
