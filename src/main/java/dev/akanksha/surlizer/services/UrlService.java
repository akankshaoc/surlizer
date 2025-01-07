package dev.akanksha.surlizer.services;

import dev.akanksha.surlizer.models.UrlMap;
import dev.akanksha.surlizer.repositories.UrlMapRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    
    private final  UrlMapRepository urlMapRepository;
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);

    public Optional<String> retreiveUrl(String shortUrl) {
        return urlMapRepository.findByShortUrl(shortUrl);
    }

    public String createShortUrl(String url) {
        Optional<String> existing = urlMapRepository.findByUrl(url);
        if(existing.isPresent()) return existing.get();
        String shortUrl = "surlized" + (urlMapRepository.count() + 1);
        urlMapRepository.save(new UrlMap(url,shortUrl));
        return shortUrl;
    }
}
