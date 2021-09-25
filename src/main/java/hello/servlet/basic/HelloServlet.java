package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //해당 서블릿(HelloServlet)이 불리면 service 메서드가 호출된다.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //서블릿은 HTTP요청 메세지를 편리하게 사용할 수 있도록 파싱하여 HttpServletRequest 객체에 담아서 제공.
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String username = req.getParameter("username");
        System.out.println(username);

        resp.setContentType("text/plain");//응답 http header 정보
        resp.setCharacterEncoding("utf-8");//응답 http header 정보
        resp.getWriter().write("hello " + username);//응답 http body 정보
    }
}
