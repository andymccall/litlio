package io.litl.model;

import javax.persistence.*;

/**
 * Created by andym on 10/03/2016.
 */
@Entity
@Table(name = "litlioentries")
public class LitlioEntry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "shortURL")
    private String shortURL;

    @Column(name = "longURL")
    private String longURL;

    @Transient
    private int hitCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public void setHitCount(int hitCount) { this.hitCount = hitCount;}

    public int getHitCount() { return hitCount;}

    @Override
    public String toString() {
        return getId() + ","
                + getShortURL() + ","
                + getLongURL();

    }
}
