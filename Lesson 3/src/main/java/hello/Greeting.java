package hello;

import java.time.*;


public class Greeting {

    private final long id;
    private final String content;
    private final LocalDateTime currentDate;

    public Greeting(long id, String content, LocalDateTime currentDate) {
        this.id = id;
        this.content = content;
        this.currentDate = currentDate;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

}
