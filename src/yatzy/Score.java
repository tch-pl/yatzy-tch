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
class Score {
    int rating;

    public Score(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.rating;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Score other = (Score) obj;
        if (this.rating != other.rating) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Score{" + "rating=" + rating + '}';
    }   
}
