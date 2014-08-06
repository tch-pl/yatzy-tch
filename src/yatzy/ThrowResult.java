/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

import java.util.List;

/**
 *
 * @author chrult
 */
public class ThrowResult<T> {
    
    private final List<T> values;

    public ThrowResult(List<T> values) {
        this.values = values;
    }

    public List<T> getValues() {
        return values;
    }
    
    @Override
    public String toString() {
        return values.toString(); 
    }

}
