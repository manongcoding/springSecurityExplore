package com.mydomain.service;

import java.util.List;

public interface UserResource {
    List<String> loadUserResources(Long userId);
}
