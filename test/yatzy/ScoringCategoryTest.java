/*
 * Copyright 2014 chrult.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yatzy;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrult
 */
public class ScoringCategoryTest {

    public ScoringCategoryTest() {
    }

    @Test
    public void six_side_dice_throw_result_score_is_full() {
        ScoringCategory fullCategory = SixSideDiceScoringCategoryFactory.generalFullCategory();
        Score score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 2, 4, 5, 5)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 1, 3, 3, 3)));
        assertEquals(new Score(25, "descrition").getRating(), score.getRating());
    }
    
    @Test
    public void six_side_dice_throw_result_score_is_two_pairs() {
        ScoringCategory fullCategory = SixSideDiceScoringCategoryFactory.generalTwoPairsCategory();
        Score score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 2, 4, 5, 5)));
        assertEquals(new Score(14, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 1, 3, 3, 3)));
        assertEquals(new Score(25, "descrition").getRating(), score.getRating());
    }
    
    
    @Test
    public void six_side_dice_throw_result_score_is_little_street() {
        ScoringCategory fullCategory = SixSideDiceScoringCategoryFactory.generalLittleStreetCategory();
        Score score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(new Score(30, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(3, 2, 4, 5, 6)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 1, 3, 3, 3)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
    }
    
        @Test
    public void six_side_dice_throw_result_score_is_big_street() {
        ScoringCategory fullCategory = SixSideDiceScoringCategoryFactory.generalBigStreetCategory();
        Score score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(3, 2, 4, 5, 6)));
        assertEquals(new Score(40, "descrition").getRating(), score.getRating());
        
        score = fullCategory.calculateScore(new ThrowResult(Arrays.asList(1, 1, 3, 3, 3)));
        assertEquals(new Score(0, "descrition").getRating(), score.getRating());
    }

}
