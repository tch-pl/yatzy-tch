/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrult
 */
public class DiceTest {

    public DiceTest() {
    }

    @Test
    public void dice_range_is_6() {
        Dice dice = Dice.classicDice();
        assertTrue(dice.getValues().length == 6);
        assertTrue(dice.getValues().length == dice.getDimension());
    }

    @Test
    public void dice_range_is_12() {
        Dice dice = Dice.RPGDice();
        assertTrue(dice.getValues().length == 12);
        assertTrue(dice.getValues().length == dice.getDimension());
    }

    @Test
    public void dice_values_are_different_and_in_range() {
        Integer[] expected_values = {1, 2, 3, 4, 5, 6};
        Dice dice = Dice.classicDice();
        assertArrayEquals(expected_values, dice.getValues());

        Integer[] expected_values2 = {1, 2};
        dice = new Dice.DiceBuilder().withDimension(2).with(new IntValueGenerator(2)).build();
        assertArrayEquals(expected_values2, dice.getValues());
    }

}
