package com.pool.service.dress;

import java.util.List;

import com.security.dress.model.DressImages;

public interface DressImagesService {

	public List<DressImages> getAllImages();

	public List<DressImages> getDressImagesByDressCode(String dressCode);

}
