package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.UserRegBindModel;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.model.view.UserProfileViewModel;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegBindModel userRegBindModel() {
        return new UserRegBindModel();
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        if (!model.containsAttribute("userRegBindModel")) {
            model.addAttribute("userRegBindModel", new UserRegBindModel());
        }
        if (!model.containsAttribute("usernameExist")) {
            model.addAttribute("usernameExist", false);
        }
        if (!model.containsAttribute("passwordNotMatch")) {
            model.addAttribute("passwordNotMatch", false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegBindModel userRegBindModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 1. check for input errors and matching passwords
        if (bindingResult.hasErrors() || !userRegBindModel.getPassword().equals(userRegBindModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegBindModel", userRegBindModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegBindModel", bindingResult);
            if (!userRegBindModel.getPassword().equals(userRegBindModel.getConfirmPassword())) {
                redirectAttributes
                        .addFlashAttribute("passwordNotMatch", true);
            }
            return "redirect:/users/register";
        }
        // 2. check for username exist
        if (userService.findByUsername(userRegBindModel.getUsername()) != null) {
            redirectAttributes
                    .addFlashAttribute("userRegBindModel", userRegBindModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegBindModel", bindingResult)
                    .addFlashAttribute("usernameExist", true);
            return "redirect:/users/register";
        }
        //3. register / save into db
        userService.registerUser(modelMapper.map(userRegBindModel, UserServiceModel.class));
        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        if (!model.containsAttribute("username")) {
            model.addAttribute("username", null);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.loginUser(username, password) == null) {
            model.addAttribute("username", username);
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String getProfilePage(@PathVariable Long id, Model model) {
        model.addAttribute("userProfile",
                modelMapper.map(userService.findById(id), UserProfileViewModel.class));
        return "profile";
    }
}
