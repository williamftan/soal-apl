package com.example.cekalamat.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cekalamat.dtos.AlamatRequest;
import com.example.cekalamat.dtos.AlamatResponse;
import com.example.cekalamat.services.AlamatService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cekAlamat")
@AllArgsConstructor
public class CekAlamatController {
    private final AlamatService alamatService;
    
    @PostMapping
    public AlamatResponse cekAlamat(@RequestBody AlamatRequest request) {
        boolean sesuai =  alamatService.cekAlamat(request.getProvinsi(), request.getKabkota());

        return sesuai ? new AlamatResponse("1", "Sesuai") : new AlamatResponse("0", "Tidak Sesuai");
    }
}
