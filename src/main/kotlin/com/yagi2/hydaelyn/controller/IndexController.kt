package com.yagi2.hydaelyn.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController {

    @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
    fun index(): String = "hear…… feel…… think……"
}