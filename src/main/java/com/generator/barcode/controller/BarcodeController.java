package com.generator.barcode.controller;

import com.generator.barcode.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;

        @GetMapping(value = "/barcode", produces = MediaType.IMAGE_PNG_VALUE)
        public ResponseEntity<byte[]> generateBarcode(@RequestParam("content") String content) throws Exception {
            byte[] barcode = barcodeService.generateQRCode(content);
            return ResponseEntity.ok().body(barcode);
        }
}