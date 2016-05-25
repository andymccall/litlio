package io.litl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andymccall on 19/05/2016.
 */
@Entity
@Table(name = "litliologentries")
public class LitlioLogEntry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "litlioEntryID")
    private int litlioEntryId;

    @Column(name = "timeStamp")
    private String timeStamp;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "userAgent")
    private String userAgent;

    @Column(name = "referer")
    private String referer;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getLitlioEntryId() {
        return litlioEntryId;
    }
    public void setLitlioEntryId(int litlioEntryId) {
        this.litlioEntryId = litlioEntryId;
    }

    public String getTimestamp() { return timeStamp;}
    public void setTimestamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {return userAgent;}
    public void setUserAgent(String userAgent) { this.userAgent = userAgent;}

    public String getReferer() {return referer;}
    public void setReferer(String referer) { this.referer = referer;}

    public String toString() {
        return getId() + ","
                + getLitlioEntryId() + ","
                + getTimestamp() + ","
                + getIpAddress() + ","
                + getUserAgent() + ","
                + getReferer();
    }
}
