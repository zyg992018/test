package com.factoryMode;

public class Fan implements Usb {
    @Override
    public void work() {
        System.out.println("分扇开始工作了~~~~~~~~~~");
    }
}
