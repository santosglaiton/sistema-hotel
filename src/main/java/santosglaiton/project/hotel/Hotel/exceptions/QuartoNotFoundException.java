package santosglaiton.project.hotel.Hotel.exceptions;

public class QuartoNotFoundException extends RuntimeException{

    public QuartoNotFoundException(){
        super();
    }

    public QuartoNotFoundException(String message){
        super(message);
    }

}
