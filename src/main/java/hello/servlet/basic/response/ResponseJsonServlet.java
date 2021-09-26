package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-type : application/json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        //이렇게 사용해도 되지만 mapper를 통해 객체를 json형식으로 바꿔서 사용하자
        //PrintWriter writer = resp.getWriter();
        //writer.println("{'username' : 'kim', 'age' : 20}");



        //refactoring
        //{"username" : "kim", "age" : 20}
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);
    }
}
