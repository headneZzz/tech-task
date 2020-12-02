package com.headnezzz.techtask.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    private String client;
    private LocalDateTime date;
    private String address;
    private List<GoodsDto> goods;
}
