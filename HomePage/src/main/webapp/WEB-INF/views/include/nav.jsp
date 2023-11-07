<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/include/nav.css">
</head>
<body>
	<div class="pnf_search_wrap">
		<div class="logo_box">
			<a href="/page" class="logo_link"> <img
				src="/image/PageFlow-LogoImage3.png" style="height: 90px"> <span
				class="hidden">PageFlow</span>
			</a>
		</div>
		<div class="pnf_search_box">
			<div class="search_input_wrap">
				<form id="searchForm" action="/book/search" method="get">
					<input id="searchInput" type='search' name='keyword'
						placeholder='검색어를 입력해주세요' class="ip_pnf_search">
				</form>
			</div>
			<a href='#' class='btn_pnf_search' onclick="searchBook();"> </a>
		</div>

		<script>
			function searchBook() {
				var keyword = document.getElementById("searchInput").value;
				var url = "/book/search?keyword=" + keyword;
				window.location.href = url;
			}
		</script>

		<ul class="user_menu_list">
			<li class="user_menu_item cart"><a href="/cart/list"
				class="user_menu_link"></a></li>
			<li class="user_menu_item my"><a href="/member_info_page"
				class="profile-icon user_menu_link done"></a></li>
		</ul>
	</div>
	<div class="pnf_wrap">
		<ul class="pnf_list">
			<li class="pnf_item"><a href="/category/book/110"
				class="pnf_link"> 소설 </a></li>
			<li class="pnf_item"><a href="/category/book/120"
				class="pnf_link"> 만화 </a></li>
			<li class="pnf_item"><a href="/category/book/130"
				class="pnf_link"> 참고도서 </a></li>
		</ul>
	</div>
</body>
</html>