/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import java.util.Collections;

/**
 *
 * @author chrult
 */
public class CategoryFactory {

    static public Category threeOfAKind() {

        Category threeOfKind = (Category<Integer>) (ThrowResult<Integer> throwResult) -> {
            for (Integer value : throwResult.getValues()) {
                if (Collections.frequency(throwResult.getValues(), value) >= 3) {                    
                    int result = 0;
                    for (Integer dice : throwResult.getValues()) {
                        result += dice;
                    }
                    return new Score(result);
                }
            }
            return new Score(0);
        };
       return threeOfKind;

    }

}
