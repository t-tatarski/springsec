package pl.keep.javac.oauthtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/login")
    public String login(){
        return  "<center><h1>panel administracyjny</h1></center><hr><br>"+
                "<center><h2>tajne dane : dupa</h2></center>";

    }


}
