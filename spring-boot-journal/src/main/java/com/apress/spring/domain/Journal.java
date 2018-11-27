package com.apress.spring.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient  //JPA 엔진은 값을 저장하지 않고 무시한다.
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");


    public Journal(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(date);
    }

    Journal() {}     //두개의생성자는 JPA 엔진에서 무인자 생성자와 DB 레코드를 추가할 때 쓸 일반 생성자입니다.

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatedAsShort(){
        return format.format(created);
    }

    public String toString(){
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("id: ");
        value.append(id);
        value.append(",제목: ");
        value.append(title);
        value.append(",요약: ");
        value.append(summary);
        value.append(",일자 : ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
