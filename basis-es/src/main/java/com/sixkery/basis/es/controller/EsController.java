package com.sixkery.basis.es.controller;

import com.sixkery.response.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sixkery
 * @since 2023/9/4
 */
@Slf4j
@RestController
@RequestMapping("/es")
public class EsController {

    @GetMapping
    public ApiResponses<Object> brandRank() {
        return ApiResponses.ok();
    }
}
