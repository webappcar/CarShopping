/**
 * home.js
 * 
 * DOM (Document Object Model) Tree
 * 
 * Selecter 표현식 ==> DOM 에서 객체(Element, Tag)를 찾는 표현식
 * 
 * 1. 태그이름 <button></button>                =>  button
 * 2. class    <button class="btn"></button>    => .btn
 * 3. id       <button id="slideDown"></button> => #slideDown
 *
 * jQuery 함수 : jQuery()
 * jQuery() 함수가 리턴하는 Type ==> jQuery Wrapper 객체 
 *                               ==> jQuery 객체
 *                               ==> jQuery 집합 객체
 * jQuery() as $()                              
 */

function xxx(event) {
	//alert("button click...");
	console.log("button click... event=" + event);
//	$('img').slideToggle(1000);	// 1초
	$('img').fadeToggle(1000);
}

$('span').click(xxx).draggable();	// Method Chain

$('img').draggable();




