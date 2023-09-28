package com.luv2code.springdeom.mvc;


import jakarta.validation.constraints.*;
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

  @Min(value = 0, message = "must be greater than or equal to zero")
  @Max(value = 10, message = "must be less than or equal to 10")
  @NotNull(message = "is required")
  private Integer freePasses; //? the trimmer will handle this wrapper class

  @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
  private String postalCode;

}
