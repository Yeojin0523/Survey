package donation.controller.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import donation.dao.ImageDao;
import donation.dto.ImageDto;

@Service
public class ImageService {
	
	@Autowired // 개념 정리
	private ImageDao imageDao;

	public List<ImageDto> getAllImages() {
		return imageDao.findAll();
	}

}
