package exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("L' id " + id + " non esiste");
    }
}