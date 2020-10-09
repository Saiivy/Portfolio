package com.saivy.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Component
@Getter @Setter
@AllArgsConstructor
public class FormObject {

@NotEmpty(message="Please Enter Your Name")
@NotNull(message="Please Enter Your Name")
private String name;
@NotEmpty(message="Please Enter Your Email")
@NotNull(message="Please Enter Your Email")
private String email;
@NotEmpty(message="Please Input The Message")
@NotNull(message="Please Enter Your Message")
private String message;


}
