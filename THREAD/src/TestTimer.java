import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args){
        Timer t = new Timer();
        t.schedule(new TimerRun(),1000,1000);
    }
}

class TimerRun extends TimerTask
{
    @Override
    public void run() {
        GregorianCalendar a = new GregorianCalendar();
        a.setTime(new Date(System.currentTimeMillis()));
        System.out.println(a.get(Calendar.SECOND));
    }
}