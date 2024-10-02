<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL 기초 연습</title>
</head>
<body>
	<pre>
		index.html 과 index.jsp 의 차이점
		
		- html : html, css, js 코드 작성이 가능함 
				+ 정적 페이지 (미리 만들어진 형태 그대로 출력)

		- jsp : html, css, js, java, el, jstl 작성 가능
				+ 동적 페이지 (요청에 따라 응답화면 변화가 가능)
	</pre>
	
	<hr>
	
	<h1>EL (Expression Language, 표현 언어)</h1>
	<pre>
		- JSP에서 Java 코드 값을 쉽게 출력하는 언어
		- 표현식 : \${key}
	</pre>
	
	<%-- form 태그 method 생략 시 기본값 GET --%>
	<%-- 2레벨로도 요청주소 작성 가능! --%>
	<form action="/el/test1">
		문자열 입력 : <input type="text" name="str"> <br>
		정수 입력 : <input type="number" name="intNum"> <br>
		실수 입력 : <input type="text" name="doubleNum"> <br>
		
		<div>
			A <input type="checkBox" name="check" value="A">
			B <input type="checkBox" name="check" value="B">
			C <input type="checkBox" name="check" value="C">
		</div>
		
		<button>제출하기</button>
	</form>
	
	<hr>
	<h1>
		<%-- a태그 클릭 시 요청은 GET방식임 --%>
		<a href="/el/scope">Servlet / JSP 범위(scope)별 내장 객체 + EL 사용법</a>
	</h1>
	
	<hr>
	
	<h1>
		<a href="/jstl/test"> JSTL 간단히 다뤄보기</a>
	</h1>
	
	
	
	
	
	
</body>
</html>