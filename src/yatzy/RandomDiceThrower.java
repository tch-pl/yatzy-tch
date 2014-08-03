/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chrult
 */
class RandomDiceThrower<T> implements DiceThrower<T> {

    public RandomDiceThrower() {
    }

    @Override
    public ThrowResult<T> rollDices(Dice<T>... dices) {
        List<T> values = new ArrayList<T>();
        for (Dice dice : dices) {
            values.add((T) rollDice(dice));
        }
        return new ThrowResult(values);
    }

    T rollDice(Dice<T> dice) {
        T[] values = dice.getValues();
        Random rn = new Random();
        return values[rn.nextInt(values.length)];

    }

}
