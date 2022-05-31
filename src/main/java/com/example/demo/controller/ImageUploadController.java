package com.example.demo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.form.ImageUploadForm;
import com.example.demo.helper.ImageUploadHelper;

@Controller
@RequestMapping("image")
@SessionAttributes({"imageUploadForm","imageByte"})
public class ImageUploadController {
	@ModelAttribute("imageUploadForm")
	public ImageUploadForm setupForm() {
		return new ImageUploadForm();
	}
	@GetMapping
	public String form() {
		return "image/form";
	}
	@PostMapping
	public String confirm(@ModelAttribute("imageUploadForm") ImageUploadForm form, Model model) throws IOException{
		// Base64エンコードした文字列をModelに保存
		model.addAttribute("image",ImageUploadHelper.createBase64ImageString(form.getFile()));
		// 画像のバイト列データをModel（セッション）に保存
		model.addAttribute("imageByte",form.getFile().getBytes());
		return "image/confirm";
	}
	@PostMapping("complete")
	public String complete(
		@ModelAttribute("imageUploadForm") ImageUploadForm form,
		@ModelAttribute("imageByte") byte[] imageByte,
		Model model,
		SessionStatus sessionStatus
	){
		// 画像ファイルをサーバに保存してファイル名を取得
		String uploadFile = ImageUploadHelper.uploadFile(form.getFile().getOriginalFilename(), imageByte);
		// ファイル名をModelに保存
		model.addAttribute("imageUrl", uploadFile);
		// セッションを削除
		sessionStatus.setComplete();
		return "image/complete";
	}
}
