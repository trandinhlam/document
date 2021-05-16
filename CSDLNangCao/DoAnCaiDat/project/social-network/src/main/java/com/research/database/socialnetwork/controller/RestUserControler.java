package com.research.database.socialnetwork.controller;

import com.research.database.socialnetwork.storage.es.dto.ESSearchUserDTO;
import com.research.database.socialnetwork.storage.es.service.ESUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}