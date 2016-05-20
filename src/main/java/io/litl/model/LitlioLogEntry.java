package io.litl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andymccall on 19/05/2016.
 */
@Entity
@Table(name = "litliologs")
public class LitlioLogEntry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "litlioEntryID")
    private int litlioEntryId;

    @Column(name = "date")
    private Date dateTime;

    @Column(name = "ipAddress")
    private long ipAddress;

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

    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(long ipAddress) {
        this.ipAddress = ipAddress;
    }
}
