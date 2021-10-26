package com.ycloud.controller;

import com.ycloud.dto.ClientDto;
import com.ycloud.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final ClientService clientService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addClient(ClientDto clientDto){
            clientService.createClient(clientDto);
        return "redirect:/auth/login";
    }
}
