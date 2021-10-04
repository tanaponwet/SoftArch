package com.company;

public class Square extends Shape {

    private int width;
    private int height;

    Square() {
    }

    Square(int side) {
        this.width = side;
        this.height = side;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
