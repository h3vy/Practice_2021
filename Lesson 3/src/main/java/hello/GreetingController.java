package hello;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        LocalDateTime todayDate = LocalDateTime.now();
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name), todayDate);
    }

    @RequestMapping("/**")
    public EchoEnitity echo(HttpServletRequest request){
        return new EchoEnitity(request.getMethod(), request.getRequestURI(), request.getProtocol(), request.getPathInfo(), request.getRemoteAddr());
    }
//    public static void showCookie(PrintWriter out, HttpServletRequest request){
//        out.println(getCookie(request,"connection"));
//    }
//
//
//    public static String getCookie(HttpServletRequest request, String name) {
//        String value = null;
//        Cookie[] cookies = request.getCookies();
//        if (null != cookies) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(name)) {
//                    value = cookie.getValue();
//                }
//            }
//        }
//        return value;
//    }



}
