/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author chrult
 */
public class ScoreRefereeTest {
//    @Test
//    public void throw_result_match_category_requirements() {       
//        ScoringCategory category = ScoreReferee.threeOfAKind();
//        Score score = category.getScore(new ThrowResult(Arrays.asList(1,1,1,5,1,2)));
//        assertEquals(score.getRating(), new Score(11).getRating());
//        score = category.getScore(new ThrowResult(Arrays.asList(1,1,7,5,1,2)));
//        assertEquals(new Score(0).getRating(), score.getRating());
//    }
//    

    @Test
    public void referee_produce_expectect_score_for_throw_result_has() {
        ScoreReferee scoreReferee = new ScoreReferee(new ScoringCategory[]{});
        Score score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(1, 1, 1, 5, 1, 2)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());

        ScoringCategory defaultScoringCategory = new ScoringCategory<Integer>() {
        };
        scoreReferee = new ScoreReferee(new ScoringCategory[]{defaultScoringCategory});
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(1, 1, 1, 5, 4, 2)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());

        scoreReferee = new ScoreReferee(new ScoringCategory[]{
            SixSideDiceScoringCategoryFactory.upperOneCategory()
        });
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(2, 3, 4, 5, 4, 2)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertEquals(new Score(1, "descrition").getRating(), score.getRating());
        
        scoreReferee = new ScoreReferee(new ScoringCategory[]{
            SixSideDiceScoringCategoryFactory.upperTwoCategory()
        });
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertEquals(new Score(2, "descrition").getRating(), score.getRating());
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(2, 2, 3, 4, 5, 6)));
        assertEquals(new Score(4, "descrition").getRating(), score.getRating());
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(2, 2, 2, 2, 2, 2)));
        
        assertEquals(new Score(12, "descrition").getRating(), score.getRating());
        
        
        scoreReferee = new ScoreReferee(new ScoringCategory[]{
            SixSideDiceScoringCategoryFactory.generalThreeOfAKindCategory()
        });
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(3, 3, 3, 4, 5, 6)));
        assertEquals(new Score(9, "descrition").getRating(), score.getRating());
        System.out.println(score);
        
        score = scoreReferee.getThrowScore(new ThrowResult(Arrays.asList(1, 3, 3, 4, 5, 6)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        System.out.println(score);

    }
}
