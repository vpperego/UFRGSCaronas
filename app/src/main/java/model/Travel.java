package model;

import java.util.Date;

/**
 * Created by user on 6/3/2017.
 */

public class Travel {
    private String source;
    private String Destiny;
    private Date date;

    public String getSource() {
        return source;
    }

    public Travel(String source, String destiny, Date date) {
        this.source = source;
        Destiny = destiny;
        this.date = date;
    }

    public Travel() {

    }

    public void setSource(String source) {
        this.source = source;

    }

    public String getDestiny() {
        return Destiny;
    }

    public void setDestiny(String destiny) {
        Destiny = destiny;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
