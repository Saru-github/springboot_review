package com.example.hello.validation.dto;


import com.example.hello.validation.annotation.YearMonth;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class User {

    @NotBlank(message = "최소 1글자 이상 적어주세요")
    private String name;
    @Min(value = 0, message = "나이는 0살 이상이여야 합니다.")
    @Max(value = 150, message = "나이는 150살 이하여야 합니다.")
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{4,5}-\\d{4}$", message = "핸드폰 번호 양식이 맞지 않습니다. 010-xxxx-xxxx")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @YearMonth

    private String reqYearMonth; //yyyyMM

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

//    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
//    public boolean isReqYearMonthValid() {
//        try{
//        LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        }catch (Exception e){
//            return false;
//        }
//        return true;
//
//    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }

}
