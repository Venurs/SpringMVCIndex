package com.yanyd.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanyd.entity.Account;

import java.io.File;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @ResponseBody
    @RequestMapping(value = "/accountInfo/{userId}", method = RequestMethod.GET)
    public Account json(@PathVariable Integer userId){
        Account account = null;
        switch(userId){
            case 1:
                account = new Account(1, 21, "lz", "123456789");
                break;
            case 2:
                account = new Account(2, 22, "lz", "123456789");
                break;
            case 3:
                account = new Account(3, 23, "lz", "123456789");
                break;
            default:
                account = new Account(7, 23, "lz", "123456789");
                break;
        }

        return account;
    }

//    @ResponseBody
    @RequestMapping(value = "/accounts.do", method = RequestMethod.GET)
    public ResponseEntity<Account> accountInfos(){
        Account account = new Account(2, 24, "wx", "tyvubinokmpl");
        ResponseEntity<Account> accountEntity = new ResponseEntity<Account>(account, HttpStatus.OK);
        return accountEntity;
    }

    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public ModelAndView uploadAvatar(@RequestParam("file") MultipartFile file) throws Exception{
        ModelAndView mv = new ModelAndView("index");
        if(!file.isEmpty()) {
            File saveFile = new File("./src/main/resources/uploads/", System.currentTimeMillis() + file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
            mv.addObject("message", file.getOriginalFilename());
        }else{
            mv.addObject("message", "empty file");
        }
        return mv;
    }

}
