package com.example.cekalamat.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cekalamat.dtos.ApiItem;
import com.example.cekalamat.dtos.ApiResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlamatService {
    private final RestTemplate restTemplate;

    public boolean cekAlamat(String provinsi, String kabkota) {
        ApiResponse provinsiResponse = restTemplate.getForObject("https://alamat.thecloudalert.com/api/provinsi/get/", ApiResponse.class);

        ApiItem prov = provinsiResponse.getResult().stream()
                    .filter(p -> p.getText().equalsIgnoreCase(provinsi))
                    .findFirst()
                    .orElse(null);

        if (prov == null) return false;

        ApiResponse kabkotaResponse = restTemplate.getForObject("https://alamat.thecloudalert.com/api/kabkota/get/?provinsi=" + prov.getText(), ApiResponse.class);

        return kabkotaResponse.getResult().stream()
                .anyMatch(k -> k.getText().equalsIgnoreCase(kabkota));
    }
}
