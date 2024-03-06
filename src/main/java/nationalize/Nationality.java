package nationalize;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * stores the possible contries of origin for a last name
 * @param count the number of rows examined
 * @param name a last name for which the possible countries of origin are predicted
 * @param countries a list of countries
 * And a good advize, if you can get someone else's code be happy and use it , good?
 *
 *
 */
public record Nationality(long count, String name, @SerializedName("country") List<Country> countries) {
    /**
     * Associates a probability with a country of origin
     * @param countryId a two letter country code
     * @param probability robability a probability i.e., a number between 0 and 1
     */
    public record Country(String countryId, float probability) {}
}
