package vn.com.dsk.demo.base.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.dsk.demo.base.dto.request.LoginRequest;
import vn.com.dsk.demo.base.dto.request.SignupRequest;
import vn.com.dsk.demo.base.service.AuthService;
import vn.com.dsk.demo.base.utils.response.Response;
import vn.com.dsk.demo.base.utils.response.ResponseUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class AuthController {

    private final AuthService authService;

    @PostMapping("public/auth/login")
    public ResponseEntity<Response> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseUtils.ok(authService.login(loginRequest));
    }

    @PostMapping("public/auth/signup")
    public ResponseEntity<Response> registerAccount(@Valid @RequestBody SignupRequest signupRequest) {
        return ResponseUtils.ok(authService.signup(signupRequest));
    }

    @GetMapping("private/auth/refresh-token")
    public ResponseEntity<Response> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String refreshToken) {
        return ResponseUtils.ok("verified", authService.verifyExpiration(refreshToken));
    }
}
