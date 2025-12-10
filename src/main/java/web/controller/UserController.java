package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/kataPP_2_3_1_war_exploded/"})
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // для формы добавления
        return "index";
    }

    @PostMapping({"/add", "/kataPP_2_3_1_war_exploded/add"})
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("age") Integer age,
                          @RequestParam("city") String city) {
        User user = new User(firstName, lastName, email, age, city);
        userService.createUser(user);
        return "redirect:/kataPP_2_3_1_war_exploded/";
    }

    @GetMapping({"/edit", "/kataPP_2_3_1_war_exploded/edit"})
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping({"/update", "/kataPP_2_3_1_war_exploded/update"})
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("age") Integer age,
                             @RequestParam("city") String city) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAge(age);
            user.setCity(city);
            userService.updateUser(user);
        }
        return "redirect:/kataPP_2_3_1_war_exploded/";
    }

    @PostMapping({"/delete", "/kataPP_2_3_1_war_exploded/delete"})
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/kataPP_2_3_1_war_exploded/";
    }
}
