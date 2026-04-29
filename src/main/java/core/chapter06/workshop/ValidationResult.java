package core.chapter06.workshop;

import lombok.Getter;

public class ValidationResult {

    private final boolean valid;
    @Getter
    private final String message;

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValidString() {
        return valid;
    }

}
