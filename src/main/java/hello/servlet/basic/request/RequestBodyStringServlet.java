package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        //text-plain API 방식으로 request가 들어왔을 때
        ServletInputStream inputStream = req.getInputStream(); //request API 데이터를 바이트 단위로 가져옴.
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 스프링에서 제공하는 StreamUtils.copyToString()을 통해 바이트 코드를 string으로 변환

        System.out.println("message = " + message);
        resp.getWriter().write("ok");
        */

        
    }
}
