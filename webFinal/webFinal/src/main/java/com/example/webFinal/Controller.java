package com.example.webFinal;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String SayHello(String name){
        return "Hello " + name;
    }

    @RequestMapping("/test/upload")
    public String upload (@RequestParam("photo") MultipartFile photo, Model model) throws IOException {
        if (!photo.isEmpty()) {
            String originalFilename = photo.getOriginalFilename();
            String targetFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            photo.transferTo(Paths.get("./target/uploadedData/photo/" + targetFilename));
            String message = String.format("上传成功：%s；文件大小：%d字节", photo.getOriginalFilename(), photo.getSize());
            model.addAttribute("message", message);
            model.addAttribute("targetFilename", targetFilename);
        }

        return "upload";
    }

    @RequestMapping("/test/showIcon")
    public void download(String userID) {
    }

    @RequestMapping("/test/submitComment")
    public String submitComment (Model model) {


        return "success";
    }

    @GetMapping(value = "/forward")
    public String forwardPage() {
        return "forward:/test/comment/";
    }
}
