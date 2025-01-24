package com.kraft.atend.model;

import org.springframework.web.multipart.MultipartFile;

public record CheckInDto(Long userId,Double latitude,Double longitude,MultipartFile rawFile) {  
}
