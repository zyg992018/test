import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

public class TestDateTime {
    public static void main(String[] args) throws ParseException{
//        test01();
//        test02();
//        test03();
        Calendar c = new GregorianCalendar();
        c.set(2020,0,1);
        PrintCalendar1(c);
    }
    public static void test01(){
        //test Date
        Date d1 = new Date(123456);
        System.out.println(d1);
        System.out.println(d1.toInstant());
        System.out.println(d1.toString());
        System.out.println(d1.getTime());
        Date d2 = new Date(2020,3,16,36,59);//month 0~11表示1~12
        System.out.println(d2);
        System.out.println(d2.after(d1));
        d2.setTime(9023456789999L);
        System.out.println(d2);
        d2.setYear(2020);
        System.out.println(d2.getTime());
    }

    public static void test02()throws ParseException {
        //test DateFormat(SimpleDateFormat)
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d1 = new Date(902345600789L);
        String s = s1.format(d1);
        System.out.println(s);
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date d2 = s2.parse("1970年02月10日 12:23:05");
        System.out.println(d2);
        SimpleDateFormat s3 = new SimpleDateFormat("该年第D天");//D表示一年的第几天
        System.out.println(s3.format(d2));
    }

    public static void test03(){
        Calendar c = new GregorianCalendar(2020,10,9,12,45,5);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);//)0~11
        int weekday = c.get(Calendar.DAY_OF_WEEK);//星期几(1日~7六),格式XX_OF__OO表示XX在OO的第几个的意思
        int day = c.get(Calendar.DAY_OF_MONTH);
        int Day = c.get(Calendar.DATE);
        System.out.println(year+"  "+month+"  "+weekday+"  "+day+"  "+Day);
        c.set(Calendar.YEAR,2012);
        System.out.println(c);
        c.add(Calendar.DATE,100);//加100天
        System.out.println(c.get(Calendar.DATE));
        printCalendar(c);
    }

    public static void printCalendar(Calendar c){
        int year  = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DATE);
        int weekday = c.get(Calendar.DAY_OF_WEEK)-1;
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String week = "日一二三四五六";
        System.out.printf("%d年%d月%d日 %d:%d:%d 星期%c\n",year,month,day,hour,minute,second,week.charAt(weekday));
    }

    public static void PrintCalendar1(Calendar c)throws ParseException{
//        long current = System.currentTimeMillis();
        System.out.println("请输入日期：xxxx-xx-xx");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d = s.parse(str);
        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(d);
        for(int j = 0; j < 12; j++) {
            System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月");
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for (int i = 1; i < c.get(Calendar.DAY_OF_WEEK); i++) {
                System.out.print('\t');
            }
            int day_num = c.getActualMaximum(Calendar.DATE);
            for (int i = 1; i <= day_num; i++) {
                if(currentDate.get(Calendar.DATE)==c.get(Calendar.DATE)
                        &&currentDate.get(Calendar.MONTH)==c.get(Calendar.MONTH)
                        &&currentDate.get(Calendar.YEAR)==c.get(Calendar.YEAR)
                )System.out.print(c.get(Calendar.DATE) + "*\t");
                else
                    System.out.print(c.get(Calendar.DATE) + "\t");
                if (c.get(Calendar.DAY_OF_WEEK) == 7)
                    System.out.print("\n");
                c.add(Calendar.DATE, 1);
            }
            System.out.println("\n");
        }
    }
}
