package vn.com.dsk.demo.base.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.dsk.demo.base.dto.request.UserRequest;
import vn.com.dsk.demo.base.service.UserService;
import vn.com.dsk.demo.base.utils.response.Response;
import vn.com.dsk.demo.base.utils.response.ResponseUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    @GetMapping("private/user/info")
    public ResponseEntity<?> getUserInfo(){
        return ResponseUtils.ok(userService.getUserInfo());
    }

    @GetMapping("private/user/test")
    public String getTest(){
        return "BTT-19-11-2001";
    }

    @PostMapping("public/user/create-user")
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseUtils.ok(userService.createUser(userRequest));
    }
}
