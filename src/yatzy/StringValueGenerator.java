/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chrult
 */
public class StringValueGenerator implements ValueGenerator<String> {

    private int dimension = 0;

    public StringValueGenerator(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public List<String> getValues() {
        List<String> values = new ArrayList();
        for (int i = 0; i < dimension; i++) {
            values.add(Integer.toString(i + 1));
        }
        return values;
    }
    
}
