package com.javalesson.innerclasses;

public class Main {

    public static void main(String[] args) {
        CellPhone phone = new CellPhone("Motorola", "XT1575");
        phone.turnOn();
        phone.call("1234567890");

        Display display = phone.getDisplay();
        Display.Pixel pixel = display.new Pixel(100, 100, Display.Color.RED);
    }
}
