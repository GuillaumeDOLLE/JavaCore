package javacore.chapter05.object.project;

public class PromptFactory {

    public PromptConfig<String> createPromptText() {
        return new PromptConfig.PromptConfigText();
    }

    public PromptConfig<String> createPromptAction() {
        return new PromptConfig.PromptConfigAction();
    }

    public PromptConfig<Integer> createPromptIteration() {
        return new PromptConfig.PromptConfigIteration();
    }

    public PromptConfig<String> createPromptAlphabet() {
        return new PromptConfig.PromptConfigAlphabet();
    }

}
