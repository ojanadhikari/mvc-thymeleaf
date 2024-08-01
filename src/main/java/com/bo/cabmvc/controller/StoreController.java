package com.bo.cabmvc.controller;

import com.bo.cabmvc.service.ExtCallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Ozads
 * @version v1.0
 * @project cab-mvc
 * @since 2024-08-01
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
@Slf4j
public class StoreController {

    private final ExtCallService extCallService;

    @GetMapping
    public String loadStore(Model model) {
        Map<String, Object> data = extCallService.getData();
        log.info("Total Data {}",data.size());
        if(data.containsKey("string")){
            log.error("Unwanted data is present");
        }
        if(data.containsKey("available")){
            log.warn("Unsold items are in the store");
        }
        model.addAttribute("data", data);
        return "store";
    }
}
