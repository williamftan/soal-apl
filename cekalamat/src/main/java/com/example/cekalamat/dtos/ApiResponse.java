package com.example.cekalamat.dtos;

import java.util.List;
import lombok.Data;

@Data
public class ApiResponse {
    private List<ApiItem> result;
}
