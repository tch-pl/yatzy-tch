package yatzy;

import java.util.Objects;

/**
 *
 * @author chrult
 */
public class Score {
    int rating;
    String description;

    public Score(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public int getRating() {
        return rating;
    }   

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.rating;
        hash = 13 * hash + Objects.hashCode(this.description);
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Score{" + "rating=" + rating + ", description=" + description + '}';
    }
    
}
