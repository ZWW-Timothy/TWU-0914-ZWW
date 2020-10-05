import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MommifierTest {
    Mommifier mommifier = new Mommifier();

    @Test
    public void should_return_empty_if_input_string_empty() {
        String input_string = "";
        String expected = "empty";
        String received = mommifier.insertMommyBetweenContinuousVowels(input_string);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_same_string_if_vowels_less_than_or_equal_to_30_per_of_input_string() {
        String input_string = "aabcdfgh";
        String expected = "aabcdfgh";
        String received = mommifier.insertMommyBetweenContinuousVowels(input_string);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_same_string_if_vowels_more_than_30_per_of_input_string_but_not_continuous() {
        String input_string = "abeio";
        String expected = "abeio";
        String received = mommifier.insertMommyBetweenContinuousVowels(input_string);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_mommy_inserted_between_continuous_vowels_string_if_vowels_more_than_30_per_of_input_string_and_is_continuous() {
        String input_string = "aaabcee";
        String expected = "amommyamommyabcemommye";
        String received = mommifier.insertMommyBetweenContinuousVowels(input_string);
        assertEquals(expected, received);
    }

}
