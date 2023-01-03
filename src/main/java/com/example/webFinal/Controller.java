package com.example.webFinal;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String SayHello(String name){
        return "Hello " + name;
    }

    @RequestMapping("/test/upload")
    public String upload (MultipartFile photo, HttpSession session) throws IOException {
        String fileName = photo.getOriginalFilename();
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + hzName;

        return "success";
    }
}
