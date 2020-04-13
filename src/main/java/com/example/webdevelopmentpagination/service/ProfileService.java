package com.example.webdevelopmentpagination.service;


import com.example.webdevelopmentpagination.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private ProfileRepo profileRepo;

    @Autowired
    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
        initDB();
    }

    public List<Profile> getAll(){
        return profileRepo.findAll();
    }

    public Page<Profile> getByPage(Pageable pageable){
        return profileRepo.findAll(pageable);
    }


    public void initDB(){
        for(int a = 0; a <100; a++){
            String name = "User_" + a;
            String description = "Description of User_" + a;
            String password = ";asldfj ;sdfs;lfdjs;dCU;";

            profileRepo.save(new Profile(name,description,password));

        }
    }
}
