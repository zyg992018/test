import Util.Udp.Receive;
import Util.Udp.Send;

public class UDpReceiveMsg {
    public static  void main(String[] args){
        Send s =new Send(9090,8080);
        Receive r =new Receive(7070,6060);
        s.start();
        r.start();
    }

}

