package javacore.chapter05.object.project;

import java.util.Scanner;

public class PromptService {

    public static <T> T promptService(Scanner scan, PromptConfig<T> config) {
        System.out.println(config.startMessage);

        int attempts = 1;

        while (attempts <= config.limitAttempts) {
            T value = config.readValue(scan);

            if (config.isValid(value)) {
                return value;
            }

            if (attempts < config.limitAttempts) {
                System.out.print(config.errorMessage);
            }

            attempts++;
        }

        System.out.println(config.endMessage);
        return config.getDefaultValue();
    }

}
