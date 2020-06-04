package dev.spring.controller;

import dev.spring.UserResponseDto;
import dev.spring.model.User;
import dev.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectUser() {
        userService.add(new User("Vlad", "123"));
        userService.add(new User("Ola", "111"));
        userService.add(new User("Dima", "222"));
        userService.add(new User("Kolyan", "333"));
        return "Successful injecting";
    }

    @GetMapping("{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return getUserResponseDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream().map(u -> get(u.getId()))
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
