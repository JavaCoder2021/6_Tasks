package by.epam.tasks.task2;

public class Note {
    
    private String topic, date, email, message;
    
    public Note(String topic, String date, String email, String message) {
        this.topic = topic;
        this.date = date;
        this.email = email;
        this.message = message;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }    
    
    @Override
    public String toString() {
        return topic + ":" + date + ":" + email + ":" + message;
    }
    
    public String print() {
        return "Topic: " + topic + "; " + date + "; " + email + "\n" + message;
    }
    
}