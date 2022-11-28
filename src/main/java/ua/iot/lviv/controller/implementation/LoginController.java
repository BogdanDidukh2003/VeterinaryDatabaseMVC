package ua.iot.lviv.controller.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {
    @PostMapping("/login")
    String Login(@RequestBody String input) {
        var status = "12345678".equals(input) ? "Success" : "Failure";
        log.info("Password is " + input);
        log.info("Status is " + status);
        return status;
    }
}
