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
public class Yatzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dice dice = Dice.classicDice();
        DiceThrower<Integer> thrower = new RandomDiceThrower();
        Dice[] dices = {dice, dice, dice};   
        Category threeOfAKind = CategoryFactory.threeOfAKind();
        boolean success = false;
        while (!success) {
            ThrowResult<Integer> result = thrower.rollDices(dices);            
            Score score = threeOfAKind.getScore(result);
            System.out.println(""+result );
            System.out.println(""+score );
            success = score.getRating() > 0;
        }
        
        
    }
    
    
    
}
