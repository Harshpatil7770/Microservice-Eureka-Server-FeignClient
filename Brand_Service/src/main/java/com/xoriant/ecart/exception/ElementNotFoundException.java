package com.xoriant.ecart.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementNotFoundException extends RuntimeException {

    private String errorMsg;

    private String errorCode;


}
