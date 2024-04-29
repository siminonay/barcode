package com.generator.barcode.controller;

import com.generator.barcode.domain.BarcodeRequest;
import com.generator.barcode.service.BarcodeService;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;

    @GetMapping(value = "/qrCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateBarcode(@RequestParam("content") String content,
                                 @RequestParam("width") int width,
                                 @RequestParam("height") int height) throws IOException, WriterException {
        BarcodeRequest request = new BarcodeRequest(content, width, height);
        byte[] barcode = barcodeService.generateQRCode(request);
        return ResponseEntity.ok().body(barcode);
    }
}