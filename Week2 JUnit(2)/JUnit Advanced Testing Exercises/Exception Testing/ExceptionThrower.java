public class ExceptionThrower {
    public void throwException(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        System.out.println("Valid input: " + input);
    }
}
