package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.model.Address;
import com.staxrt.tutorial.model.Constants;
import com.staxrt.tutorial.model.Image;
import com.staxrt.tutorial.model.Profile;
import com.staxrt.tutorial.model.response.SummaryBO;
import com.staxrt.tutorial.repository.AddressRepository;
import com.staxrt.tutorial.repository.ImageRepository;
import com.staxrt.tutorial.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address/all")
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    @GetMapping("/profile/all")
    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    @GetMapping("/images/all")
    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }


    @GetMapping("/summary")
    public List<SummaryBO> getProfilesAround(@RequestParam("lat")double latitude, @RequestParam("lng")double longitude,
                                             @RequestParam("uid")long userId){

        List<SummaryBO> list=new ArrayList<>();
        List<Profile> profiles=getAllProfiles();
        List<Address> addresses=getAllAddress();
        List<Image> images=getAllImages();

        SummaryBO.Builder builder=new SummaryBO.Builder();

        Map<Long,Image> imageMap=new HashMap<>();
        for(Image image:images){
            imageMap.put(image.getPictureId(),image);
        }

        Map<Long,Address> addressMap=new HashMap<>();
        for(Address address:addresses){
            addressMap.put(address.getAddressId(),address);
        }

        String imageUrl=Constants.awsHostName+":"+Constants.awsPortNumber;
        for(Profile profile:profiles){
            builder.setAge(profile.getAge());
            builder.setBio(profile.getBio());
            builder.setDistance(1);
            builder.setName(profile.getFirstName()+" "+profile.getLastName().substring(0,1));

            Image image=imageMap.get(profile.getPictureId());
            List<String> imageList=new ArrayList<>();
            if(image!=null){
                if(image.getFirstImage()!=null){
                    imageList.add(imageUrl+image.getFirstImage());
                }

                if(image.getSecondImage()!=null){
                    imageList.add(imageUrl+image.getSecondImage());
                }

                if(image.getThirdImage()!=null){
                    imageList.add(imageUrl+image.getThirdImage());
                }

                if(image.getFourthImage()!=null){
                    imageList.add(imageUrl+image.getFourthImage());
                }
            }
            if(imageList.isEmpty()){
                System.err.println("No images found for "+profile.getProfileId());
                continue;
            }else{
                builder.setImages(imageList);
                list.add(builder.build());
            }
        }

        System.out.println("Received users latitude: "+latitude+" , Longitude: "+longitude+" , UserId: "+userId);
        return list;
    }

}
