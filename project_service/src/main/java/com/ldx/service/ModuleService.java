package com.ldx.service;

import com.ldx.domain.export.Module;
import com.ldx.domain.export.User;

import java.util.List;

public interface ModuleService {
    List<Module> findModuleByUser(User user);
}
