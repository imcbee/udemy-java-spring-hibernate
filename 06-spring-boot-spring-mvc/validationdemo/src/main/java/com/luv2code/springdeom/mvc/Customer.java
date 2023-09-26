package com.luv2code.springdeom.mvc;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private String firstName;

  @NotNull(message = "is required")
  @Size(min=1, message = "is required")
  private String lastName = "";

}
