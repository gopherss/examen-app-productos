package com.nttdata.stock_ms.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorDetailDto {
    private String message;
    private LocalDateTime dateTime;
}
