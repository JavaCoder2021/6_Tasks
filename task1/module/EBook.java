package by.epam.tasks.task1.module;

public class EBook extends Book {
    
    private String location;

    public EBook(String title, String author, String publisher, int year, String location) {
        super(title, author, publisher, year);

        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String print() {
        return super.print() + " - " + location;
    }       

    @Override
    public String toString() {
        return super.toString() + ":" + location;
    }    
    
}