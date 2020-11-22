package com.minimed.MiniMedAPI.service.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}