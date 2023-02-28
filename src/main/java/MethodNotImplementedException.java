/**
 * Class that extends RuntimeException, which specify exception for every method that will not be implemented.
 */
public class MethodNotImplementedException extends RuntimeException{
    public MethodNotImplementedException() {
        super("Method is not implemented");
    }
}
