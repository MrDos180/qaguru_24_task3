package utils;

import java.util.HashMap;
import java.util.Random;

public class RandomUtils {
    static Random random = new Random();

    public String cityRandom() {
        String[] states = {"Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer"};
        int i = random.nextInt(states.length);
        return states[i];
    }


    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }


    public static String monthRandom() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int i = random.nextInt(month.length);
        return month[i];
    }

    public static String genderRandom() {
        String[] gender = {"Male", "Female", "Other"};
        int i = random.nextInt(gender.length);
        return gender[i];
    }

    public static String hobbieRandom() {
        String[] hobbie = {"Sports", "Reading", "Music"};
        int i = random.nextInt(hobbie.length);
        return hobbie[i];
    }
}
