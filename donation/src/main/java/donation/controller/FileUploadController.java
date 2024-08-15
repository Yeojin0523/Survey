// 파일 업로드 관련.
// 수정 필요

package donation.controller;

public class FileUploadController {

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
	    // 파일 처리 로직
	    return "redirect:/main";
	}


}
