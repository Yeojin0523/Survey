// 파일 업로드 관련.
package donation.controller.file;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) {
	    // 파일 처리 로직
		
		try {
			// 파일 이름 생성
			String filename = new SimpleDateFormat("yyyyMMDDHmmss").format(new Date(0)) + "-" + file.getOriginalFilename();
			Path path = (Path) Paths.get("C:/upload-dir/" + filename); // 경로 수정 기능
			Files.write(path, file.getBytes());

		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	    return "redirect:/main";
	}
}
