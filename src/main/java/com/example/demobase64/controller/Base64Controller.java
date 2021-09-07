package com.example.demobase64.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class Base64Controller {

    @GetMapping("/encode")
    ResponseEntity handle(@RequestParam("input") String inputStr) {
        byte[] bytesEncoded = Base64.encodeBase64(inputStr.getBytes());
        return ResponseEntity.status(200).body(new String(bytesEncoded));
    }

    @GetMapping("/encode-file")
    ResponseEntity handleEncodeFile(@RequestParam("filePath") String filePath) throws IOException {
        File file = new File(filePath);
        byte[] bytesEncoded = Base64.encodeBase64(Files.readAllBytes(file.toPath()));
        return ResponseEntity.status(200).body(new String(bytesEncoded));
    }

}