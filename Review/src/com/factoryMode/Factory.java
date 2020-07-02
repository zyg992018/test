package com.factoryMode;

public class Factory {
    public static Usb createUsb(int type){
        if(type==1){
            return new Mouse();
        }else if(type==2){
            return new Upan();
        }else if(type==3){
            return new Fan();
        }
        return null;
    }
}
