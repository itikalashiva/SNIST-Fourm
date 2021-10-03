package com.example.shiva.forum;

/**
 * Created by shiva on 3/12/2017.
 */
public class Deom {
    String text;
    int pic;

    public Deom(String text, int pic) {
        this.text = text;
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
