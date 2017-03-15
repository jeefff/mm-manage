package com.vertical.mm.service.picture;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	Map uploadPicture(MultipartFile uploadFile);
}
