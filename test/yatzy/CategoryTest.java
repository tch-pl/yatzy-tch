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
public class CategoryTest {
    @Test
    public void throw_result_match_category_requirements() {       
        Category category = CategoryFactory.threeOfAKind();
        Score score = category.getScore(new ThrowResult(Arrays.asList(1,1,1,5,1,2)));
        assertEquals(score.getRating(), new Score(11).getRating());
        score = category.getScore(new ThrowResult(Arrays.asList(1,1,7,5,1,2)));
        assertEquals(score.getRating(), new Score(0).getRating());
    }
}
