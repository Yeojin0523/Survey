// 파일 업로드 관련.
// 수정 필요

package donation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
	    // 파일 처리 로직
	    return "redirect:/main";
	}


}
