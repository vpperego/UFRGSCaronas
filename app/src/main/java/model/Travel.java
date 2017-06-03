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
