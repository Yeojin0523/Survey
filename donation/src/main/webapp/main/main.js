document.addEventListener("DOMContentLoaded", function() {
    // .each-content 요소에 대한 클릭 이벤트 처리
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

    // .donate_area 요소에 대한 클릭 이벤트 처리
	var donateBoxes = document.querySelectorAll(".donate_area");
	donateBoxes.forEach(function(box2) {
    box2.addEventListener("click", function(event) {
        event.stopPropagation(); // 부모 요소로의 이벤트 전파 중지
        event.preventDefault(); // 기본 동작 중지
        
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = '../DonationServlet';
        
        document.body.appendChild(form);
        form.submit();
    });
});

});
