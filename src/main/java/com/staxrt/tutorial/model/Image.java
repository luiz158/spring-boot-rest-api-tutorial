package com.staxrt.tutorial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "images")
@EntityListeners(AuditingEntityListener.class)
public class Image {

    @Id
    @Column(name = "picture_id")
    private long pictureId;

    @Column(name = "first_image")
    private String firstImage;

    @Column(name = "second_image")
    private String secondImage;

    @Column(name = "third_image")
    private String thirdImage;

    @Column(name = "fourth_image")
    private String fourthImage;

    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(String secondImage) {
        this.secondImage = secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(String thirdImage) {
        this.thirdImage = thirdImage;
    }

    public String getFourthImage() {
        return fourthImage;
    }

    public void setFourthImage(String fourthImage) {
        this.fourthImage = fourthImage;
    }

    @Override
    public String toString() {
        return "Image{" +
                "pictureId=" + pictureId +
                ", firstImage='" + firstImage + '\'' +
                ", secondImage='" + secondImage + '\'' +
                ", thirdImage='" + thirdImage + '\'' +
                ", fourthImage='" + fourthImage + '\'' +
                '}';
    }
}
