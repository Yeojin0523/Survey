document.addEventListener("DOMContentLoaded", function() {
    var contentBoxes = document.querySelectorAll(".each-content");
    contentBoxes.forEach(function(box) {
        box.addEventListener("click", function(event) {
            var seq = this.getAttribute('data-seq');
            var text = this.querySelector('span:nth-child(2)').innerText;

            // 폼 생성
            var form = document.createElement('form');
            form.method = 'POST';
            form.action = '../DonationServlet';

            // seq 값 추가
            var seqField = document.createElement('input');
            seqField.type = 'hidden';
            seqField.name = 'seq';
            seqField.value = seq;
            form.appendChild(seqField);

            // text 값 추가
            var textField = document.createElement('input');
            textField.type = 'hidden';
            textField.name = 'text';
            textField.value = text;
            form.appendChild(textField);

            // 폼 제출
            document.body.appendChild(form);
            form.submit();
        });
    });
});
/*
document.addEventListener("DOMContentLoaded", function(){
	var DonateBoxes = document.querySelectorAll(".donate_area");
	DonateBoxes.forEach(fuction(box2){
		box2.addEventListener("click", function(event){
			// 
		})
	})
})*/
