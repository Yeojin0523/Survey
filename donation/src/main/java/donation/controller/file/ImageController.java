package donation.controller.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import donation.dto.ImageDto;

@RestController
public class ImageController {
	
	
	ImageService imageService;
	
	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	public List<ImageDto> listing(){
		return imageService.getAllImages();
	}
}
