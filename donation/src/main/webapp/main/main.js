document.addEventListener("DOMContentLoaded", function() {
    // .each-text 요소에 대한 클릭 이벤트 처리
    var contentBoxes = document.querySelectorAll(".each-text");
    contentBoxes.forEach(function(box) {
        box.addEventListener("click", goToInsertForm);
    });

    // .donate_area 요소에 대한 클릭 이벤트 처리
    var donateBoxes = document.querySelectorAll(".donate_area");
    donateBoxes.forEach(function(box2) {
        box2.addEventListener("click", function(event) {
            event.preventDefault(); // 필요에 따라 제거
            var form = document.createElement('form');
            form.method = 'POST';
            form.action = '../AddDonationServlet';
            document.body.appendChild(form);
            form.submit();
        });
    });

    // goToInsertForm 함수 정의
    function goToInsertForm(event) {
        var seq = event.currentTarget.getAttribute('data-seq');
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = '../DonationServlet';

        var seqField = document.createElement('input');
        seqField.type = 'hidden';
        seqField.name = 'seq';
        seqField.value = seq;
        form.appendChild(seqField);

        document.body.appendChild(form);
        form.submit();
    }
});
// 이미지 파일 추가를 위한 코드
function posting(){
	let title = $('img-title').val();
	let file = $('img-comment').val();
	
	// formData 객체에 데이터 추가
	let form_data = new FormData();
	form_data.append("file_give", file);
	form_data.append("title_give", title);
	
	$.ajax({
		type: "POST",
		url:"/posting", 
		data: form_data,
		contentType:false,
		processData:false,
		cache:false,
		success: function(response){
			alert(response["msg"]);
			window.location.reload();
		}
	})
}
