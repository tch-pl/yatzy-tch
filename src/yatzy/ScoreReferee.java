package yatzy;

/**
 *
 * @author chrult
 */
public class ScoreReferee<T> {

    private ScoringCategory[] scoringCategories = new ScoringCategory[]{};

    public ScoreReferee(ScoringCategory[] scoringCategories) {
        this.scoringCategories = scoringCategories;
    }   
    
    
//    private ScoringCategory threeOfAKind() {
////        ScoringCategory threeOfKind = (ScoringCategory) (ThrowResult<T> throwResult) -> {
////            for (T value : throwResult.getValues()) {
////                if (Collections.frequency(throwResult.getValues(), value) >= 3) {
////                    int result = 0;
////                    for (Integer dice : throwResult.getValues()) {
////                        result += dice;
////                    }
////                    return new Score(result);
////                }
////            }
////            return new Score(0);
////        };
////       return threeOfKind;
//    }

    /**
     *
     * @param throwResult
     * @return
     */
    public Score getThrowScore(ThrowResult throwResult) {
        Score overallScore = new Score(0, "No score categories used!");
        for (ScoringCategory category : scoringCategories) {
            // TODO create and use independent aggregator which is able to decide how to count overall score (it could be dependent of game rules)
            // the way shown below is just simple example of score accumulation
            Score categoryScore = category.calculateScore(throwResult);
            overallScore = new Score(overallScore.getRating() + categoryScore.getRating(), categoryScore.getDescription());
        }
        return overallScore;
    }

}
