package mate.academy.internetshop.exeptions;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String msg, Exception ex) {
        super(msg, ex);
    }
}
