package io.litl.model;

/**
 * Created by andymccall on 05/06/2016.
 */
public class LitlioEntryCount {

    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "LitlioEntryCount{" +
                "count=" + count +
                '}';
    }
}
