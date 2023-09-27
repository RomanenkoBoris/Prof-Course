package lesson28.exceptions;

// Exception - нужно перехватывать и обрабатывать
// RuntimeException - можно перхватывать и обрабатывать по желанию
public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
