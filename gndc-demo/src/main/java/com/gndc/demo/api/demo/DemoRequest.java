package com.gndc.demo.api.demo;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DemoRequest extends RequestMessage {
    @NotNull
    @Min(1)
    private Long id;
}
