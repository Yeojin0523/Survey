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
function confirmSubmission(event) {
    event.preventDefault(); // 기본 폼 제출 방지

    var form = document.getElementById('donation-form');

    if (confirm("제출하시겠습니까?")) {
        alert("정상적으로 제출되었습니다.");
        document.getElementById('redirectPage').value = "main"; // 리다이렉트 페이지 설정
        form.submit(); // 폼 제출
    } else {
        alert("제출이 취소되었습니다.");
        // 취소 시에는 아무런 추가 동작이 필요 없습니다.
    }
}
$(document).ready(function(){
	listing();
})
function listing() {
    $.ajax({
        type: "GET",
        url: "/listing",
        data: {},
        success: function(response) {
            if (response["result"] === "success") {
                let images = response['images'];
                for (let i = 0; i < images.length; i++) {
                    let title = images[i]['imageName'];
                    let file = images[i]['imageUrl'];

                    let temp_html = `
                        <div class="col">
                            <div class="card h-100">
                                <img src="../static/${file}" class="card-img-top" style="max-height: 300px">
                                <div class="card-body">
                                    <h5 class="card-title">${title}</h5>
                                </div>
                            </div>
                        </div>`;
                    $('#image-container').append(temp_html);  // '#image-container'는 이미지를 담을 HTML 요소의 ID
                }
            }
        }
    });
}

