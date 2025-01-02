package dev.akanksha.surlizer.controller;

import dev.akanksha.surlizer.services.UrlService;
import dev.akanksha.surlizer.exceptions.NoSuchUrlInUse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("shorten")
    public ResponseEntity<Map<String, String>> shorten(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>(
                Map.of("shortUrl", urlService.createShortUrl(body.get("url"))),HttpStatus.CREATED
        );
    }

    @GetMapping("redirect/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) throws NoSuchUrlInUse {
        Optional<String> url = urlService.retreiveUrl(shortUrl);
        if(url.isEmpty()) throw new NoSuchUrlInUse(shortUrl);
        return new RedirectView(url.get());
    }
}
