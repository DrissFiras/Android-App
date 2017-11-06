package com.example.yasmine.myapp1;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Firas on 12/11/2016.
 */

public class Comment {
    String comment ;
    Integer Writer ;

    public Integer getWriter() {
        return Writer;
    }

    public void setWriter(Integer writer) {
        Writer = writer;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    Date date ;
    Time time ;

}
