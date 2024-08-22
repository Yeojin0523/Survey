package donation.controller.file;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import donation.dto.ImageDto;

@RestController
public class ImageController {
	private final ImageService imageService = new ImageService();
	
	public List<ImageDto> listing(){
		return imageService.getAllImages();
	}
}
