package site.metacoding.projecttest.openapi.contents.field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentsField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String contentSeq;
    private String areaName;
    private String partName;
    private String title;
    private String keyword;
    private String address;
    private String latitude;
    private String longitude;
    private String tel;
    private String usedTime;
    private String homePage;
    private String content;
    private String provisionSupply;
    private String petFacility;
    private String restaurant;
    private String parkingLog;
    private String mainFacility;
    private String usedCost;
    private String policyCautions;
    private String emergencyResponse;
    private String memo;
    private String bathFlag;
    private String provisionFlag;
    private String petFlag;
    private String petWeight;
    private String dogBreed;
    private String emergencyFlag;
    private String entranceFlag;
    private String parkingFlag;
    private String inOutFlag;
    private String imageList;
}