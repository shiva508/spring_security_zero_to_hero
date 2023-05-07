package com.pool.uitil;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class SecurityAppUtil {
	public File getFile(String fileName) {
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return file;
	}
}
