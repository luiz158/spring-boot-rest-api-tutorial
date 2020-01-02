package com.staxrt.tutorial.model.response;

import com.staxrt.tutorial.model.Image;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;


public class SummaryBO {

    public final String name;
    public final int age;
    public final String bio;
    public final double distance;
    public final List<String> images;

    public SummaryBO(String name, int age, String bio, double distance, List<String> images) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.distance = distance;
        this.images=images;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", bio='" + bio + '\'' +
                ", distance=" + distance +
                ", image=" + images.stream().map(a->a.toString()+", ").toString() +
                '}';
    }

    public static class Builder{
        private String name;
        private int age;
        private String bio;
        private double distance;
        private List<String> images;


        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }


        public SummaryBO build(){
            return new SummaryBO(name,age,bio,distance,images);
        }
    }
}
