package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
//@RequestMapping("/user")
@Slf4j
public class UserController {
	
      @ModelAttribute
      public void populateModel(Model model) {
          model.addAttribute("title", "用户列表");
      }

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/list")
    public String list(Model model) throws Exception {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String  userdelete(@PathVariable("id") Long id,Model model){
        userRepository.deleteById(id);
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }
}
