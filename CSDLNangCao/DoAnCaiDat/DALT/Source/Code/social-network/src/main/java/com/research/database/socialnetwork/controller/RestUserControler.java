package com.research.database.socialnetwork.controller;

import com.research.database.socialnetwork.storage.es.dto.ESSearchUserDTO;
import com.research.database.socialnetwork.storage.es.service.ESUserService;
import com.research.database.socialnetwork.utils.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class RestUserControler {

    @Autowired
    private ESUserService esUserService;

    @GetMapping(value = "/search", produces = "application/json")
    public List<ESSearchUserDTO> searchUserWithName(@RequestParam("key") String nameInput, //
                                                    @PageableDefault(size = 10, page = 0) Pageable paging) {
        return esUserService.searchByName(nameInput, paging);
    }

    @GetMapping(value = "/updatePrincipal/{userId}", produces = "application/json")
    public Integer searchUserWithName(@PathVariable("userId") Integer userId) {
        return CommonConfig.updatePrincipal(userId);
    }
}