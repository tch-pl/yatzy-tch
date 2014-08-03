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
public class IntValueGenerator implements ValueGenerator<Integer> {

    private int dimension = 0;

    public IntValueGenerator(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public List<Integer> getValues() {
        List<Integer> values = new ArrayList();
        for (int i = 0; i < dimension; i++) {
            values.add(i + 1);
        }
        return values;
    }

}
