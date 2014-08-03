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
interface ValueGenerator<T> {
    List<T> getValues();
}
