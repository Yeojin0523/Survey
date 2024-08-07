<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Donation</title>
<link rel="stylesheet" href="addDonation.css">
</head>
<body>
	<div>
		<h1 id="h1-title">기부내용을 등록하세요</h1>
	</div>
	<div>
		<form id="donation-form" action="" method="get" enctype="multipart/form-data">
			<div id="title-show">
				제목 : <input type="text" name="title" />
			</div>
			<div id="label-show">
				<label>분류</label> <select name="categories">
					<option value="children">어린이</option>
					<option value="world">지구촌</option>
				</select>
			</div>
			<div id="content-show">
				내용 :
				<textarea id="content" name="content" placeholder="내용을 입력해 주세요"></textarea>
			</div>
			<div id="start-date-show">
				시작일 : <input type="date" min="2020-01-01" max="" name="startDate" />
			</div>
			<div id="last-date-show">
				마감일 : <input type="date" min="" max="" name="lastDate" />
			</div>
			<!-- 이미지 파일 데이터에 알맞는 enctype 설정 -->
			<div class="addImage" id="image-show">
				<!-- 이미지 띄울 공간 -->
			</div>
			<div><input type="file" accept="image/*" onchange="loadFile(this)">
			<!-- 여기서 onchange는 input이나 select 등의 데이터가 변경될 떄 호출되는 이벤트이다. 
			이 코드에서는 파일을 불러왔을 때 loadFile 함수를 실행한다. -->
			</div>
			<div id="point-show">
				포인트 <input type="text">
			</div>
			<div id="amount-show">
				목표 금액 <input type="text">
			</div>
			<div>
				<button id="btn-show">확인</button>
			</div>
		</form>
		</div>
			
	<script src="addDonation.js"></script>
</body>
</html>