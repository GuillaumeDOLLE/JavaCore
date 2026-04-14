package javacore.chapter05.object.project;

public class PromptFactory {

    @SuppressWarnings("unchecked")
    public static <T> PromptConfig<T> createPrompt(PromptConfig.EntryType type) {
        switch (type) {
            case TEXT:
                return (PromptConfig<T>) new PromptConfig.PromptConfigText();
            case ACTION:
                return (PromptConfig<T>) new PromptConfig.PromptConfigAction();
            case ITERATION:
                return (PromptConfig<T>) new PromptConfig.PromptConfigIteration();
            case ALPHABET:
                return (PromptConfig<T>) new PromptConfig.PromptConfigAlphabet();
        }

        throw new IllegalStateException("Unexpected EntryType : " + type);
    }

}
