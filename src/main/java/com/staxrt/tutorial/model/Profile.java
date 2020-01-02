package com.staxrt.tutorial.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
@EntityListeners(AuditingEntityListener.class)
public class Profile {

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "picture_id",nullable = false)
    private long pictureId;

    @Id
    @Column(name = "profile_id",nullable = false)
    private long profileId;

    @Column(name = "bio",nullable = false)
    private String bio;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name="address_id",nullable = false)
    private long addressId;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "age=" + age +
                ", pictureId=" + pictureId +
                ", profileId=" + profileId +
                ", bio='" + bio + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressId' "+addressId+'\''+
                '}';
    }
}
