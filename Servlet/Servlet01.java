import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;



public class Servlet01 implements Servlet{
	public void init(ServletConfig servletConfig)throws ServletException{
	
	}
	public void service(ServletRequest request, ServletResponse response)throws ServletException,IOException{
		System.out.println("服务启动");
	}
	public void destroy(){
		
	}
	public ServletConfig getServletConfig(){
		
		return null;
	}
	public String getServletInfo(){
		return null;
	}
}