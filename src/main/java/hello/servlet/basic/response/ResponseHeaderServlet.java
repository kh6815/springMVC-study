package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        //content(resp);
        
        //[Cookie 편의 메서드]
        //cookie(resp);

        //[Redirect 편의 메서드]
        redirect(resp);

        //[MessageBody]
        resp.getWriter().write("ok");
    }
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // response.setContentType("text/plain");
        // response.setCharacterEncoding("utf-8");
        // response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //1. 첫번째 방법
        //Set-Cookie: myCookie=good; Max-Age=600;    
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        
        //2. 위 쿠기 생성 코드가 복잡하니까 Cookie 객체를 만들어서 response하기
         Cookie cookie = new Cookie("myCookie", "good");    
         cookie.setMaxAge(600); //600초    
         response.addCookie(cookie); 
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        // Location: /basic/hello-form.html

        //1. 첫번째 방법
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        //2. 두번째 방법
        response.sendRedirect("/basic/hello-form.html");
    }
}
