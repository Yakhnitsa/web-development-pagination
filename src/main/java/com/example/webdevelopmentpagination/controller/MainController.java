package com.example.webdevelopmentpagination.controller;

import com.example.webdevelopmentpagination.entity.Profile;
import com.example.webdevelopmentpagination.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
public class MainController {
    private ProfileService profileService;

    @Autowired
    public MainController(ProfileService profileService) {
        this.profileService = profileService;
//        profileService.initDB();
    }

    @ResponseBody
    @GetMapping("/api/profiles")
    public Page<Profile> getPage(

            @PageableDefault(size=10,
                    sort={"id"},
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ){
        Page<Profile> page = profileService.getByPage(pageable);
        return page;
    }
    @ResponseBody
    @GetMapping("/api/all-profiles")
    public List<Profile> getAll(){
        List<Profile> profiles = profileService.getAll();
        return profiles;
    }


}
