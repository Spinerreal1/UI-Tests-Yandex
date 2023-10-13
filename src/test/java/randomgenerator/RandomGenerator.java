package randomgenerator;
import java.util.Random;

public class RandomGenerator {


    public static String newFolderName() {
        String randomLetters = generateRandomLetters(10);
        System.out.println("Название новой папки: " + randomLetters);
        return randomLetters;
    }

    public static String newFileName() {
        String randomLetters = generateRandomLetters(10);
        System.out.println("Название нового файла: " + randomLetters);
        return randomLetters;
    }

    public static String generateRandomLetters(int length) {
        StringBuilder randomString = new StringBuilder();
            Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomLetter = (char) ('a' + random.nextInt(26));
            randomString.append(randomLetter);
        }
        return randomString.toString();
    }
}

