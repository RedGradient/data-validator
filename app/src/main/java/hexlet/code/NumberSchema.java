package hexlet.code;

public class NumberSchema implements BaseSchema {
    private boolean mustBeIncludedInRange = false;
    private int begin;
    private int end;

    private boolean required = false;

    private boolean mustBePositive = false;

    public void positive() {
        mustBePositive = true;
    }

    public void required() {
        required = true;
    }

    public void range(int begin, int end) {
        mustBeIncludedInRange = true;
        this.begin = begin;
        this.end = end;
    }

    public boolean isValid(Integer number) {
        if (number == null) {
            return !required;
        }

        if (mustBePositive && number <= 0) {
            return false;
        }

        var isNumberInRange = (number >= begin && number <= end);
        return !mustBeIncludedInRange || isNumberInRange;
    }
}
