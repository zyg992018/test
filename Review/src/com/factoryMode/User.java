package com.factoryMode;

public class User {
    public static void main(String[] args) {
        Usb usb1 = Factory.createUsb(1);
        if(usb1!=null){
            usb1.work();
        }else {
            System.out.println("生产失败");
        }
        try {
            Usb usb2 = Factory2.CreateUsb("com.factoryMode.Mouse");
            usb2.work();
        } catch (ClassNotFoundException e) {
            System.out.println("生产失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
