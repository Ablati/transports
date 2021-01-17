package kz.ablati.transport.utility;

public class ConflictException extends RuntimeException {

    private int status = 409;

    public ConflictException(){
        super();
    }

    public ConflictException(String message){
        super(message);
    }

    public ConflictException(String message, int status){
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
