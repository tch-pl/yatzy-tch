/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

/**
 *
 * @author chrult
 */
public interface Category<T> {
    Score getScore(ThrowResult<T> throwResult);
}
