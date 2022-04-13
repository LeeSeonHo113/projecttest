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
    private Integer contentSeq;
    private String areaName;
    private String partName;
    private String title;
    private String address;
    private String latitude;
    private String longitude;
    private String tel;
}