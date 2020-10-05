import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mommifier {

    public String insertMommyBetweenContinuousVowels(String inputString) {
        if (isEmptyString(inputString)){
            return "empty";
        }

        String[] splitLetters = inputString.split("");
        String vowelsList = "aeiou";

        if (!vowelsMoreThanThirtyPer(splitLetters, vowelsList)){
            return inputString;
        }

        return findContinuousVowelsThenInsertMommy(splitLetters, vowelsList);
    }

    private Boolean isEmptyString(String inputString) {
        if (inputString.length() == 0) {
            return true;
        }
        return false;
    }

    private Boolean vowelsMoreThanThirtyPer(String[] splitLetters, String vowelsList) {
        int vowelCount = 0;
        for (int i = 0; i < splitLetters.length; i += 1) {
            String letterExtend = "(.*)" + splitLetters[i] + "(.*)";
            if (vowelsList.matches(letterExtend)) {
                vowelCount += 1;
            }
        }
        float vowelPer = (float) vowelCount/splitLetters.length;
        boolean moreThanThirty = true;
        if (vowelPer < 0.3) {
            moreThanThirty = false;
        }
        return moreThanThirty;
    }

    private String findContinuousVowelsThenInsertMommy(String[] splitLetters, String vowelsList) {
        List<String> insertedList = new ArrayList<>();
        for (int i = 0; i < splitLetters.length-1; i += 1) {
            String letterExtend = "(.*)" + splitLetters[i] + "(.*)";
            if (vowelsList.matches(letterExtend)) {
                if (splitLetters[i].matches(splitLetters[i+1])) {
                    insertedList.add(splitLetters[i]);
                    insertedList.add("mommy");
                    continue;
                }
            }
            insertedList.add(splitLetters[i]);
        }
        insertedList.add(splitLetters[splitLetters.length-1]);
        String[] insertedArray = insertedList.toArray(new String[insertedList.size()]);
        String insertedString = new String();
        for (int i = 0; i < insertedArray.length; i += 1){
            insertedString = insertedString + insertedArray[i];
        }
        return insertedString ;
    }

}
