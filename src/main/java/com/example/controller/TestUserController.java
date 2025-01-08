package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import hibiscus.cetide.app.annotation.SignalEmitter;
import hibiscus.cetide.app.config.BusinessCache;
import hibiscus.cetide.app.core.collector.HibiscusSignalContextCollector;
import hibiscus.cetide.app.core.service.HibiscusCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TestUserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @Autowired
    private HibiscusCacheManager cacheManager;

    @GetMapping("/test/{id}")
    public String getProduct(@PathVariable Long id) {
        // 使用 BusinessCache 而不是直接使用 HibiscusCache
        BusinessCache<String, String> cache = cacheManager.getBusinessCache("default");
        cache.put("user" + id, "hibiscus - amazing"+id.toString());
        String user = cache.get("user" + id);
        return user;
    }


    @GetMapping("/{id}")
    @SignalEmitter("user:login")
    public String getProductBusiness(@PathVariable Long id) {
        // 使用 BusinessCache 而不是直接使用 HibiscusCache
        BusinessCache<String, String> cache = cacheManager.getBusinessCache("product_cache");
        cache.put("user" + id, "hibiscus - amazing"+id.toString());
        HibiscusSignalContextCollector.collect("user", id);
        String user = cache.get("user" + id);
        return user;
    }
} 