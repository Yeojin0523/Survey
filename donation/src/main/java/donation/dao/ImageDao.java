package donation.dao;

import java.util.List;

import donation.dto.ImageDto;

public interface ImageDao extends JpaRepository<ImageDto, Long>{
	List<ImageDto> findAll();
}
