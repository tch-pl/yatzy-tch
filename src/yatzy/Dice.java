/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

/**
 *
 * @author chrult
 * @param <T>
 */
public class Dice<T>{

    private final int dimension;
    private final ValueGenerator<T> valueGenerator;

    private Dice(int dimension, ValueGenerator<T> valueGenerator) {        
        this.dimension = dimension;
        this.valueGenerator = valueGenerator;        
    }

    public int getDimension() {
        return dimension;
    }

    public T[] getValues() {
        return (T[])valueGenerator.getValues().toArray();
    }

    static Dice classicDice() {
        return new DiceBuilder().with(new IntValueGenerator(6)).withDimension(6).build();
    }

    static Dice RPGDice() {
        return new DiceBuilder().with(new IntValueGenerator(12)).withDimension(12).build();
    }
    
    static Dice PictureClassicDice() {
        return new DiceBuilder().with(new StringValueGenerator(6)).withDimension(6).build();
    }

    static class DiceBuilder {
        int dimension;
        ValueGenerator valueGenerator;
        public DiceBuilder withDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        
        public DiceBuilder with(ValueGenerator valueGenerator) {
            this.valueGenerator = valueGenerator;
            return this;
        }
        
        public Dice build() {
            return new Dice(dimension, valueGenerator);
        }
    }
}
