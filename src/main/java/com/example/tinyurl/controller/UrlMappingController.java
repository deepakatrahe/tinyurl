package com.example.tinyurl.controller;

import com.example.tinyurl.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlMappingController {

    @Autowired
    private UrlMappingService urlMappingService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl) {
        return urlMappingService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirectToLongUrl(@PathVariable String shortUrl) {
        String longUrl = urlMappingService.getLongUrl(shortUrl);
        if (longUrl != null) {
            return "redirect:" + longUrl;
        } else {
            return "Short URL not found!";
        }
    }
}

