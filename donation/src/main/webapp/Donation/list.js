/** list.js의 script file
 * 
 */
function goToInsertForm(seq){
	// 서버로 텍스트 값을 전송하여 해당 텍스트 페이지로 이동
	const form = document.createElement('form');
	form.method = 'POST';
	form.action ='DisplayTextServlet';
	
	const hiddenField = document.createElement('input');
	hiddenField.type = 'hidden';
	hiddenField.name = 'seq';
	hiddenField.value = seq;
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	form.submit();
}

document.addEventListener("DOMContentLoaded", function(){
	var contentBoxes = document.querySelectorAll(".each-content");
	contentBoxes.forEach(function(box){
		box.addEventListener("click", goToInsertForm);
	});
});