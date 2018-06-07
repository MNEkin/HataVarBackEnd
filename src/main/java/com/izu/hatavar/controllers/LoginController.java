package com.izu.hatavar.controllers;

import com.izu.hatavar.models.User;
import com.izu.hatavar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController
{
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody User user)
    {
        userService.save(user);
    }

    @PostMapping("/login")
    User login(@RequestBody User user)
    {
        return userService.findFirstByUserEmailAndPasswprd(user.getUserEmail(), user.getPassword());
    }

    /*
    * @PostMapping(value = "/bugs", headers = ("content-type=multipart/form-data;boundary=032a1ab685934650abbe059cb45d6ff3"))
    void recordBug(@RequestBody BugRecord bugRecord, @RequestParam("file") MultipartFile[] files)
    {
        System.out.println(bugRecord.getContent());
        String path = storageService.store(files);
        bugRecord.setImgPath(path);
        System.out.println("files are set");
        bugRecordService.save(bugRecord);
    }*/
}
