package yatzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chrult
 */
public class Yatzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiceThrower<Integer> thrower = new RandomDiceThrower();
        Dice[] dices = {Dice.classicDice(), Dice.classicDice(), Dice.classicDice(), Dice.classicDice(), Dice.classicDice()};

        ScoringCategory upperOneCategory = SixSideDiceScoringCategoryFactory.upperOneCategory();
        ScoringCategory upperTwoCategory = SixSideDiceScoringCategoryFactory.upperTwoCategory();
        ScoringCategory upperThreeCategory = SixSideDiceScoringCategoryFactory.upperThreeCategory();
        ScoringCategory upperFourCategory = SixSideDiceScoringCategoryFactory.upperFourCategory();
        ScoringCategory upperFiveCategory = SixSideDiceScoringCategoryFactory.upperFiveCategory();
        ScoringCategory upperSixCategory = SixSideDiceScoringCategoryFactory.upperSixCategory();

        List<ScoringCategory> categories = new ArrayList();
        categories.add(upperFiveCategory);
        categories.add(upperFourCategory);
        categories.add(upperOneCategory);
        categories.add(upperSixCategory);
        categories.add(upperThreeCategory);
        categories.add(upperTwoCategory);
//        categories.add(SixSideDiceScoringCategoryFactory.generalBigStreetCategory());
//        categories.add(SixSideDiceScoringCategoryFactory.generalChanceCategory());
        categories.add(SixSideDiceScoringCategoryFactory.generalTwoPairsCategory());
//        categories.add(SixSideDiceScoringCategoryFactory.generalFullCategory());
//        categories.add(SixSideDiceScoringCategoryFactory.generalLittleStreetCategory());
        categories.add(SixSideDiceScoringCategoryFactory.generalThreeOfAKindCategory());
//        categories.add(SixSideDiceScoringCategoryFactory.generalYahtzeeCategory());
//        categories.add(SixSideDiceScoringCategoryFactory.generalYahtzeePlusCategory());

        Score totalScore = new Score(0, "Total score");
//        while (!categories.isEmpty()) {
//            Random rn = new Random();
//            // player choose which category will be used to get score - each category can be used only once
//            ScoringCategory choosenCategory = categories.remove(rn.nextInt(categories.size()));
//            // player rolls dices
//            ThrowResult<Integer> result = thrower.rollDices(dices);
//            // we calculate score for chosen category and throw result
//            Score score = choosenCategory.calculateScore(result);
//
//            // prepare total score
//            if (score.getRating() > 0) {
//                totalScore = new Score(totalScore.getRating() + score.getRating(), totalScore.getDescription() + "\n\r" + score.getDescription());
//            }
//        }

        while (!categories.isEmpty()) {
            ThrowResult<Integer> result = thrower.rollDices(dices);
            Score score = new Score(0, "");
            ScoringCategory choosenCategory = null;
            for (ScoringCategory category : categories) {
                if (category.calculateScore(result).getRating() > score.getRating()) {
                    score = category.calculateScore(result);
                    choosenCategory = category;
                }
            }
            if (score.getRating() == 0) {
                continue;
            }
            System.out.println("+++++++++++++++");
            System.out.println("result= " + result);
            System.out.println("category= " + choosenCategory);
            System.out.println("score= " + score);
            System.out.println("+++++++++++++++");
            categories.remove(choosenCategory);
            // player choose which category will be used to get score - each category can be used only once
            // player rolls dices
            // we calculate score for chosen category and throw result
            // prepare total score

            totalScore = new Score(totalScore.getRating() + score.getRating(), totalScore.getDescription() + "\n\r" + score.getDescription());

        }

        System.out.println("" + totalScore);

    }

}
