package com.crisol.ahorrandome.dto.user;

import java.io.Serializable;

public record UserInfo(Long id, String name, String email) implements Serializable {}