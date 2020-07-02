import Util.Udp.Receive;
import Util.Udp.Send;

public class UDPSendMsg {
    public static  void main(String[] args){
        Send s =new Send(6060,7070);
        Receive r =new Receive(8080,9090);
        s.start();
        r.start();
    }
}
