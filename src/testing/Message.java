package testing; 

import java.sql.Timestamp;
public class Message {
	private Integer sender;
    private String email;
    private Integer petID;
    private Timestamp time;
    private String message;
    public Message(Integer sender, String email, Integer petID, Timestamp time, String message) {
        this.sender = sender;
        this.email = email;
        this.petID = petID;
        this.time = time;
        this.message = message;
    }
}