package yatzy;

/**
 *
 * @author chrult
 */
public interface ScoringCategory<T> {
    default Score calculateScore(ThrowResult<T> throwResult) {
        return new Score(0, "Default score calculation");
    }   
}
