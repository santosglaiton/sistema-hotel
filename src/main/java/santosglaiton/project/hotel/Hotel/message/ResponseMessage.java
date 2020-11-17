package santosglaiton.project.hotel.Hotel.message;

public class ResponseMessage {

    private String message;

    public ResponseMessage (String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(){
        this.message = message;
    }

}
