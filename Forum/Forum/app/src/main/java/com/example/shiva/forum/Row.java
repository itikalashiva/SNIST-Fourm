package com.example.shiva.forum;



public class Row {
    private String name;
    private String link;
    public Row(){}
    public Row(String name, String link)
    {
        this.name=name;
        this.link=link;
    }
    public String getName()
    {
        return name;
    }
    public String getLink()
    {
        return link;
    }
}
