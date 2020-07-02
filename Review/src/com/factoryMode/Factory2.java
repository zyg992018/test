package com.factoryMode;

public class Factory2 {
    public static Usb CreateUsb(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Usb usb = null;
        Class<?> c = Class.forName(className);
        usb =(Usb)c.newInstance();
        return usb;
    }
}
