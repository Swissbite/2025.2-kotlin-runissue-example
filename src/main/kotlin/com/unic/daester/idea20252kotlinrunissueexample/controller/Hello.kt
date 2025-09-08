package com.unic.daester.idea20252kotlinrunissueexample.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping(path = ["/hello"])
open class Hello {
    @GetMapping(produces = ["text/plain;charset=utf-8"])
    fun hello(): ResponseEntity<String> = ResponseEntity.ok("Hello World")
}

@Controller
open class RootRedirectController {
    @GetMapping("/")
    fun redirectToHello(): RedirectView = RedirectView("/hello", true)
}
