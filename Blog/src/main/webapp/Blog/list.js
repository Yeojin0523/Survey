/** list.js의 script file
 * 
 */
function goToInsertForm(){
	window.location.href="InsertForm.jsp";
}

document.addEventListener("DOMContentLoaded", function(){
	var contentBoxes = document.querySelectorAll(".each-content");
	contentBoxes.forEach(function(box){
		box.addEventListener("click", goToInsertForm);
	});
});