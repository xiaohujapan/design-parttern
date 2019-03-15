package org.dxh.java.basespring.tinyioc.step3;

public class HelloWorldService {
    private String text;

    public void helloWorld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
