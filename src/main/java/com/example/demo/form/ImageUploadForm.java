package com.example.demo.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageUploadForm implements Serializable{
	private MultipartFile file;
}
