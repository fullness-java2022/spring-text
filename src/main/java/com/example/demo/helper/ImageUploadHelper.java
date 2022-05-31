package com.example.demo.helper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploadHelper {
	/**
	 * フォームから送信された画像ファイルをサーバに保存してファイル名を取得するメソッド
	 * @param fileName フォームから送信された画像ファイル名
	 * @param imageByte フォームから送信された画像ファイルのバイト列データ
	 * @return String サーバに保存したファイル名
	 */
	public static String uploadFile(String fileName, byte[] imageByte){
		String uuidFileName = UUID.randomUUID().toString() + "_" + fileName;
		String filePath = new File("src/main/webapp/img").getAbsolutePath() + File.separator + uuidFileName;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(imageByte);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("ファイルパス指定エラー",e);
		} catch (IOException e) {
			throw new RuntimeException("ファイル書き込みエラー",e);
		} finally {
			try {
				if(fos != null) fos.close();
			} catch (IOException e) {
				throw new RuntimeException("ファイル閉じる時のエラー",e);
			}
		}
		return uuidFileName;
	}

	/**
	 * フォームから送信された画像ファイルをBase64エンコードして文字列化するメソッド
	 * @param file フォームから送信された画像ファイル
	 * @return String HTMLで表示させるためのBase64エンコードされた画像データ文字列
	 * @throws IOException Base64関連の例外
	 */
	public static String createBase64ImageString(MultipartFile file){
		// 文字列連結するためStringBufferインスタンス生成
		StringBuffer data = new StringBuffer();
		// 画像のバイト列をBase64エンコード
		String base64 = "";
		try {
			base64 = new String(Base64.encodeBase64(file.getBytes()),"ASCII");
		} catch (IOException e) {
			throw new RuntimeException("画像ファイルをBase64エンコード時のエラー",e);
		}
		// HTMLで画像の文字列を表示させつための先頭文字列をStringBufferインスタンスに追加
		data.append("data:image/png;base64,");
		// StringBufferインスタンスにBase64エンコードした画像データを追加
		data.append(base64);
		return data.toString();
	}

}
