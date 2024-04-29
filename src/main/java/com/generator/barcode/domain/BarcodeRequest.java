package com.generator.barcode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarcodeRequest {

    private String content;
    private Integer width;
    private Integer height;

}
