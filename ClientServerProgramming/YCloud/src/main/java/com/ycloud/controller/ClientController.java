package com.ycloud.controller;

import com.ycloud.service.impl.ServiceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ServiceServiceImpl serviceService;

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('client:read')") //дозвіл до сторінки
    public String getOrderPage(Model model){
        model.addAttribute("services", serviceService.selectAll());
        return "order";
    }

//    @PostMapping("/orders")
//    @PreAuthorize("hasAuthority('client:write')")
//    public String getCreateOrder(OrderDto orderDto, @ModelAttribute("attribute") ModelMap model, final RedirectAttributes redirectAttributes) {
//
//        return "redirect:/clients/orders/success";
//    }
//
//
//    @GetMapping("/orders/success")
//    @PreAuthorize("hasAuthority('client:read')")
//    public String getOrderSuccess(@ModelAttribute("attribute")ModelMap modelMap,Model model){
//
//        return "order_success";
//    }


}
