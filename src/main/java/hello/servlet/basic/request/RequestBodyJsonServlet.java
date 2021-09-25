package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    //2.
    //스프링은 기본적으로 jackson이라는 json 라이브러리를 가지고 있다.
    //jackson을 사용하여 json을 편하게 파싱할 수 있음.
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream(); //바이트 단위로 읽어오기
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //StreamUtils.copyToString으로 request 바이트 -> string으로 변환

        //1. json도 결국 문자임으로 text처럼 통채로 string으로 가져올 수 있다.
        //하지만 json
        System.out.println("message = " + message);

        //2. jakson의 ObjectMapper를 통해 json -> object로 파싱하기
        HelloData helloData = objectMapper.readValue(message, HelloData.class);
        System.out.println(helloData);
        System.out.println("helloDate-username : " + helloData.getUsername());
        System.out.println("helloDate-age : " + helloData.getAge());

        resp.getWriter().write("ok");
    }
}
