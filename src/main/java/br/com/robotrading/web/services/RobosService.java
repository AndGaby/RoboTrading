package br.com.robotrading.web.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mchange.io.FileUtils;

import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.helper.ImageResizer;
import br.com.robotrading.web.model.Robo;

@Service
public class RobosService {
	
	@Autowired
	private RobosDAO robosDAO;
	@Autowired
	private Environment env;
	
	public String handleFileUpload(MultipartFile imagemRobo, Long idRobo, String oldImageName) {
		String fullPathFileLocation = env.getProperty("folder.uploaded.images");
		String originalFilename;
		File defaultImage = null;
		
		if (imagemRobo.getSize() == 0) {
			originalFilename = env.getProperty("default.image.name");
			defaultImage = new File(fullPathFileLocation + originalFilename);
		}else{
			originalFilename = imagemRobo.getOriginalFilename();
		}
		
		String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = "image_upload_robo_id_" + idRobo + fileExtension;
		File image = null;
		try {
			image = new File(fullPathFileLocation + fileName);
			if (!image.exists())
				image.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(image);
			if(defaultImage != null){
				ImageResizer.resize(defaultImage, 150, 150);
				fos.write(FileUtils.getBytes(defaultImage));
			}else{
				fos.write(imagemRobo.getBytes());
				fos.close();
				ImageResizer.resize(image, 150, 150);
			}	
			fos.close();
			// para nao duplicar imagens para um mesmo robo
			if (oldImageName != null && !oldImageName.equals(fileName)) {
				File oldImage = new File(fullPathFileLocation + oldImageName);
				oldImage.delete();
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		if (image.exists())
			return fileName;
		else
			return "Error";
	}
	
	public Robo findRobo(Long id) {
		if (robosDAO.exists(id)) {
			return robosDAO.findOne(id);
		}
		throw new RoboNaoExisteException();
	}
	
	public boolean deleteRoboImage(Robo robo){
		File image = new File(env.getProperty("folder.uploaded.images") + robo.getLinkImg());
		if (image.exists())
			image.delete();
		
		return !image.exists() ? true : false;  
	}
}
