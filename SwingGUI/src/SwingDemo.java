import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class SwingDemo {
    public static final String REGEX_IP = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
    static String ip=null;
    static JTextArea jex;
    static Send s = null;
    static Receive r = null;
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                creatGUI();
            }
        });
    }
    private static void creatGUI(){
        JFrame frame = new JFrame("在线聊天");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());


        JTextArea jta=new JTextArea(35,40);
        SwingDemo.jex = jta;
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.WHITE);    //设置按钮背景色
        JScrollPane jsp=new JScrollPane(jta);    //将文本域放入滚动窗口
        container.add(jsp);

        JTextArea txtfield1=new JTextArea(2,32);    //创建文本框
        txtfield1.setText("普通文本框");    //设置文本框的内容
        txtfield1.setLineWrap(true);
        JScrollPane jsp1=new JScrollPane(txtfield1);
        txtfield1.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        JButton button1 = new JButton("发送");
        container.add(jsp1);
        container.add(button1);

        JTextField txtfield2 = new JTextField(30);    //创建文本框
        txtfield2.setText("100.64.152.102");    //设置文本框的内容
        txtfield2.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        txtfield2.setHorizontalAlignment(JTextField.LEFT);

        JButton button2 = new JButton("对方IP");
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //ip
                String newIP = txtfield2.getText();
                if(!newIP.equals("localhost")&&!Pattern.matches(REGEX_IP, newIP)){
                    jta.append("提示：请输入正确的IP地址"+"\n");
                    return;
                };
                if(SwingDemo.ip!=null && ip.equals(newIP))return;
                if(SwingDemo.ip!=null){
                    r.closeSocket();
                    r.stop();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                SwingDemo.ip = newIP;
                s = new Send(8181,9191,SwingDemo.ip,"连接成功");
                s.start();
                r = new Receive(9191,8181,SwingDemo.ip);
                r.start();

            }
        });
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if(SwingDemo.ip==null){
                    jta.append("请先输入对方IP\n");
                    return;
                }
                String s = txtfield1.getText();
                if(s.trim().length()==0){
                    jta.append("提示：请输入内容"+"\n");
                    txtfield1.setText("");
                    return;
                }
                new Send(8181,9191,SwingDemo.ip,s).start();
                jta.append("我方："+s+"\n");
                txtfield1.setText("");
            }
        });
        container.add(txtfield2);
        container.add(button2);

        JTextField jtf=new JTextField(20);
        JButton button3=new JButton("浏览");
        JPanel panel=new JPanel();
        panel.add(jtf);
        panel.add(button3);
        container.add(panel);
        container.setVisible(true);
        button3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser("F:\\");
                int val=fc.showOpenDialog(null);    //文件打开对话框
                if(val==fc.APPROVE_OPTION)
                {
                    //正常选择文件
                    jtf.setText(fc.getSelectedFile().toString());
                }
                else
                {
                    //未正常选择文件，如选择取消按钮
                    jtf.setText("未选择文件");
                }
            }
        });
        JButton button4=new JButton("发送");
        panel.add(button4);
        button4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                String FilePath = jtf.getText();
                File f = new File(FilePath);
                if(!f.exists()&&!f.isFile()){
                    jta.append("提示：请选择文件\n");
                }else{
                    if(ip==null){
                        jta.append("提示：请先输入IP\n");
                        return;
                    }
                    String[] s = FilePath.replaceAll("\\\\","/").split("/");
                    new Send(8181,9191,SwingDemo.ip,"file:"+s[s.length-1]).start();
                    new SendFile(new File(FilePath),ip,7272).start();
                }
            }
        });


        container.setBounds(0,0,400,840);
        frame.setVisible(true);
        frame.setBounds(300,100,400,840);
    }

}



class Send extends Thread{
    int SrcPort;
    int desPort;
    BufferedReader b;
    String ip;
    String msg;
    public Send(int SrcPort,int desPort,String ip,String msg){
        this.SrcPort = SrcPort;
        this.desPort = desPort;
        this.ip = ip;
        this.msg=msg;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(SrcPort);
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,
                    new InetSocketAddress(ip, desPort));
            socket.send(packet);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receive extends Thread{
    int SrcPort;
    int desPort;
    String ip;
    boolean flag = true;
     DatagramSocket socket;
     public void setFlag(boolean flag) {
         this.flag = flag;
     }
     public void closeSocket(){
         socket.close();
     }
     public Receive(int SrcPort, int desPort, String ip){
        this.SrcPort = SrcPort;
        this.desPort = desPort;
        this.ip = ip;
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(SrcPort);
            while (flag) {
                byte[] b = new byte[1024];
                DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                        new InetSocketAddress(ip, desPort));
                socket.receive(packet);
                String s = new String(packet.getData(),0,packet.getLength());
                if(s.split(":")[0].equals("file")){
                    String[] ss = s.split(":");
                    SwingDemo.jex.append("接收文件："+ss[ss.length-1]+"\n");
                    File f = new File(ss[ss.length-1]);
                    new ReceiveFile(f).start();
                    continue;
                }
                SwingDemo.jex.append("对方："+s+"\n");
                if("bye".equals(s)) {
                    break;
                };
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SendFile extends Thread{
    File f ;
    String ip;
    int port;
    public SendFile(File f,String ip, int port){
        this.f = f;
        this.ip = ip;
        this.port = port;
    }
    @Override
    public void run() {
        try {
            Socket socket = new Socket(ip,port);
            BufferedOutputStream send = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(f));
            long l1 = System.currentTimeMillis();
            int count = 0;
            byte[] b = new byte[1024*10];
            int len = -1;
            while ((len = buffer.read(b))!= -1){
                send.write(b,0,len);
                count += len;
            }
            long l2 = System.currentTimeMillis();
            SwingDemo.jex.append("一共耗时："+(l2-l1)+"ms，平均速度是："+count/(l2-l1)+"KB/s\n");
            send.flush();
            send.close();
            buffer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReceiveFile extends Thread{
    File file;
    public ReceiveFile(File f){
        file = f;
    }
    @Override
    public void run() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(7272);
            Socket s = socket.accept();
            BufferedInputStream buffer = new BufferedInputStream(s.getInputStream());
            BufferedOutputStream w = new BufferedOutputStream(new FileOutputStream(file));
            byte[] b =new byte[1024*10];
            int count = 0;
            int len = -1;
            long l1 = System.currentTimeMillis();
            while ((len = buffer.read(b)) != -1){
                w.write(b,0,len);
                count+=len;
            }
            long l2 = System.currentTimeMillis();
            SwingDemo.jex.append("一共耗时："+(l2-l1)+"ms，平均速度是："+count/(l2-l1)+"KB/s\n");
            w.flush();
            w.close();
            buffer.close();
            s.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}