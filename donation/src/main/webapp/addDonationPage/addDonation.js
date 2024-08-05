/**
 * 기부하기 창의 js 파일입니다.
 */
function loadFile(input){
	let file = input.files[0]; //선택파일 가져오기
	let newImage = document.createElement("img");
	
	newImage.src = URL.createObjectURL(file);
	newImage.style.width = "100%"; // div에 꽉 차게 넣기 위해서
	newImage.style.height = "100%";
	newImage.style.objectFit = "cover" // div에 넘치지 않고 들어가게 하기 위해서
 
	//이미지를 div에 추가
	let container = document.getElementById('image-show');
	container.innerHTML = ""; // 기존 회색 이미지 제거
	container.appendChild(newImage);
}