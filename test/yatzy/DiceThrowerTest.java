package yatzy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrult
 */
public class DiceThrowerTest {

    @Test
    public void throwing_three_dices_produce_three_values_as_result() {
        RandomDiceThrower thrower = new RandomDiceThrower();
        Dice[] dices = {Dice.classicDice(), Dice.RPGDice(), Dice.PictureClassicDice()};
        ThrowResult result = thrower.rollDices(dices);
        assertTrue(result.getValues().size() == 3);
    }

    @Test
    public void throw_random_number_from_1_to_6() {
        RandomDiceThrower<Integer> thrower = new RandomDiceThrower();
        int[] occurences = new int[Dice.classicDice().getDimension()];
        for (int i = 0; i < 100; i++) {
            occurences[thrower.rollDice(Dice.classicDice()) - 1]++;            
        }

        for (int i = 0; i < Dice.classicDice().getDimension(); i++) {
            assertTrue(occurences[i] >=1);
            System.out.println("classicDice side [" + (i+1) +"] occured " + occurences[i] + " times.");
        }
    }

    @Test
    public void throw_random_number_from_1_to_12() {
        RandomDiceThrower<Integer> thrower = new RandomDiceThrower();
        int[] occurences = new int[Dice.RPGDice().getDimension()];
        for (int i = 0; i < 100; i++) {
            occurences[thrower.rollDice(Dice.RPGDice())- 1]++;            
        }

        for (int i = 0; i < Dice.RPGDice().getDimension(); i++) {
            assertTrue(occurences[i] >=1);
            System.out.println("RPGDice side [" + (i+1) +"] occured " + occurences[i] + " times.");
        }
    }
}
