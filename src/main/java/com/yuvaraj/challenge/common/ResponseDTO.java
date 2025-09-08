package com.yuvaraj.challenge.common;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO {

    @NonNull
    @NotBlank(message = "Response status can't be blank")
    private String status;
    private Object result;

}
