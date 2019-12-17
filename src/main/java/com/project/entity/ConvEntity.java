package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "conv_def")
public class ConvEntity {

    /** 편의점등록번호 */
    @Id
    @Getter
    private Integer convNo;
    /** 편의점이름 */
    @Getter
    private String convName;
    /** 좌표 */
    @Getter
    private String locationCoordinate;
    /** 주소 */
    @Getter
    private String address;
    /** 전화번호 */
    @Getter
    private String phoneNo;

    @Builder
    public ConvEntity(Integer convNo, String convName, String locationCoordinate, String address, String phoneNo) {
        this.convNo = convNo;
        this.convName = convName;
        this.locationCoordinate = locationCoordinate;
        this.address = address;
        this.phoneNo = phoneNo;
    }

}