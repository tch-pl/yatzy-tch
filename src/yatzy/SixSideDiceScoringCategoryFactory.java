/*
 * Copyright 2014 chrult.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yatzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author chrult
 */
public class SixSideDiceScoringCategoryFactory {

    static enum Number {

        ONE(1, "One"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six");

        int number;
        String description;

        Number(int number, String description) {
            this.number = number;
            this.description = description;
        }

    }

    static private class XTimesCategory<Integer> implements ScoringCategory<Integer> {

        private final Number diceSideValue;

        private XTimesCategory(Number diceSideValue) {
            this.diceSideValue = diceSideValue;
        }

        @Override
        public Score calculateScore(ThrowResult<Integer> throwResult) {
            int occurences = Collections.frequency(throwResult.getValues(), diceSideValue.number);
            return new Score(occurences * diceSideValue.number, String.format("%s for %s times.", diceSideValue.description, occurences));
        }

        @Override
        public String toString() {
            return "XTimesCategory{" + "diceSideValue=" + diceSideValue + '}';
        }

    }

    public static ScoringCategory<Integer> upperOneCategory() {
        return new XTimesCategory(Number.ONE);
    }

    public static ScoringCategory<Integer> upperTwoCategory() {
        return new XTimesCategory(Number.TWO);
    }

    public static ScoringCategory<Integer> upperThreeCategory() {
        return new XTimesCategory(Number.THREE);
    }

    public static ScoringCategory<Integer> upperFourCategory() {
        return new XTimesCategory(Number.FOUR);
    }

    public static ScoringCategory<Integer> upperFiveCategory() {
        return new XTimesCategory(Number.FIVE);
    }

    public static ScoringCategory<Integer> upperSixCategory() {
        return new XTimesCategory(Number.SIX);
    }

    static private class GeneralSameValues implements ScoringCategory<Integer> {

        private final Number expectedOccurences;

        private GeneralSameValues(Number expectedOccurences) {
            this.expectedOccurences = expectedOccurences;
        }

        @Override
        public Score calculateScore(ThrowResult<Integer> throwResult) {
            int repeatedSameValues = value(throwResult.getValues());
            return new Score(repeatedSameValues * expectedOccurences.number, String.format("%s for %s times.", repeatedSameValues, expectedOccurences.number));
        }

        private Integer value(List<Integer> values) {
            Integer result = 0;
            for (Integer value : values) {
                int occurences = Collections.frequency(values, value);
                if (occurences == expectedOccurences.number) {
                    result = value;
                    break;
                }
            }

            return result;
        }

        @Override
        public String toString() {
            return "GeneralSameValues{" + "expectedOccurences=" + expectedOccurences + '}';
        }
    }

    public static ScoringCategory<Integer> generalPairCategory() {
        //SUM
        return new GeneralSameValues(Number.TWO);
    }

    public static ScoringCategory<Integer> generalTwoPairsCategory() {
        //SUM
        return new GeneralSameValues(Number.FOUR);
    }

    public static ScoringCategory<Integer> generalThreeOfAKindCategory() {
        //SUM
        return new GeneralSameValues(Number.THREE);
    }

    public static ScoringCategory<Integer> generalFourOfAKindCategory() {
        //SUM
        return new GeneralSameValues(Number.FOUR);
    }

    public static ScoringCategory<Integer> generalFullCategory() {
        // 25pts
        return new ScoringCategory<Integer>() {

            @Override
            public Score calculateScore(ThrowResult<Integer> throwResult) {
                Score score = new Score(0, "Full Category Score=0");
                boolean two = false;
                boolean three = false;
                for (Integer value : throwResult.getValues()) {
                    int occurences = Collections.frequency(throwResult.getValues(), value);
                    if (occurences == 3) {
                        three = true;
                        continue;
                    }
                    if (occurences == 2) {
                        two = true;
                    }
                }

                if (two && three) {
                    return new Score(25, String.format("Full for result %s", throwResult));
                }

                return score;
            }

        };
    }

    public static ScoringCategory<Integer> generalLittleStreetCategory() {
        // 30pts
        return new StreetScoringCategory(new Integer[]{1, 2, 3, 4, 5}, 30);
    }

    public static ScoringCategory<Integer> generalBigStreetCategory() {
        // 40pts
       return new StreetScoringCategory(new Integer[]{6, 2, 3, 4, 5}, 40);
    }

    public static ScoringCategory<Integer> generalYahtzeeCategory() {
        //50pts
        return new GeneralSameValues(Number.FOUR);
    }

    public static ScoringCategory<Integer> generalChanceCategory() {
        // SUM ALL
        return new GeneralSameValues(Number.FOUR);
    }

    public static ScoringCategory<Integer> generalYahtzeePlusCategory() {
        // 100pts
        return new GeneralSameValues(Number.FOUR);
    }

    private static class StreetScoringCategory implements ScoringCategory<Integer> {

        private final Integer[] streetRange;
        private final int scoreValue;

        private StreetScoringCategory(Integer[] streetRange, int scoreValue) {
            if (streetRange == null || streetRange.length != 5) {
                throw new IllegalArgumentException(String.format("Street category init error, street range should be 5 element integer array, but is: %s", streetRange));
            }
            this.streetRange = streetRange;
            this.scoreValue = scoreValue;
        }

        @Override
        public Score calculateScore(ThrowResult<Integer> throwResult) {
            Score score = new Score(0, "Street Category Score=0");
            Set<Integer> ints = new HashSet(Arrays.asList(streetRange));

            throwResult.getValues().stream().forEach((value) -> {
                ints.remove(value);
            });

            if (ints.isEmpty()) {
                return new Score(scoreValue, String.format("Street for result %s", throwResult));
            }

            return score;
        }

    }

}
