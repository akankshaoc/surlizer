package dev.akanksha.surlizer.repositories;

import dev.akanksha.surlizer.models.UrlMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMapRepository extends JpaRepository<UrlMap, String> {
    @Query("SELECT map.url FROM UrlMap map WHERE map.shortUrl = ?1")
    Optional<String> findByShortUrl(String shortUrl);

    @Query("SELECT map.shortUrl FROM UrlMap map WHERE map.url = ?1")
    Optional<String> findByUrl(String url);
}
