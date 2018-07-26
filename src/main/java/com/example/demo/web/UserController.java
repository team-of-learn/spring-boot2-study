package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
//@RequestMapping(value="/user")
@Slf4j
public class UserController {

      @ModelAttribute
      public void populateModel(Model model) {
          model.addAttribute("title1", "用户列表");
          model.addAttribute("title2", "修改用户");
      }

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/list")
    public String list(Model model) throws Exception {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }
    
//  public List<User> userlist(){
//	return userRepository.findAll();
//}
    
    @GetMapping(value = "/update/{id}")
    public String selectone(@PathVariable("id") Long id,Model model) {
    	User user = userRepository.getOne(id);
    	model.addAttribute("user", user);
    	return "/user/update";
    }
    
    
    
    @GetMapping(value = "/save")
	public String update(@RequestParam("id") Long id, 
					   @RequestParam("name") String name,
					   @RequestParam("jobNumber") String jobNumber,Model model) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setJobNumber(jobNumber);
		user.setCreateTime(new Date());
		userRepository.save(user);
		List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
	}
    
}
