package io.litl.model;

/**
 * Created by andym on 10/03/2016.
 */
public class LitlioEntry {

    private int id;
    private String shortURL;
    private String longURL;
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

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public void incrementHitCount() {
        this.hitCount++;
    }

    @Override
    public String toString() {
        return "LitlioEntry{" +
                "id=" + id +
                ", shortURL='" + shortURL + '\'' +
                ", longURL='" + longURL + '\'' +
                ", hitCount=" + hitCount +
                '}';
    }
}
