package com.example.restfulservices.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"passwd"})
@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {

    private Integer id;

    @Size(min = 2)
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;

//    @JsonIgnore
    @ApiModelProperty(notes = "사용자 비밀번호을 입력해 주세요.")
    private String passwd;
//    @JsonIgnore
    @ApiModelProperty(notes = "사용자 주민번호을 입력해 주세요.")
    private String ssn;
}
