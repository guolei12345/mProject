<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>电影信息</title>
	</head>

	<body>
	<div id="user-profile-3" class="user-profile row">
		<div class="col-sm-offset-1 col-sm-10">
			<div class="space"></div>
			<div class="page-header">
				<h1>
					电影信息
					<small>
						<i class="icon-double-angle-right"></i>
						Large &amp; Small
					</small>
				</h1>
			</div><!-- /.page-header -->
			<div class="dataTables_filter">
				<label>
					<a href="#" onclick="load('/movie/movieTuijian')" aria-controls="sample-table-2">热门推荐</a>
					电影类型:
					<select name="movieType" id="movieType" aria-controls="sample-table-2">
						<option value=""></option>
						<c:forEach items="${typeList}" var="type">
							<option value="${type.typeid}">${type.typename}</option>
						</c:forEach>
					</select>

					关键字: <input type="text" id="movieInfoKey" aria-controls="sample-table-2">
					<button class="btn btn-info" onclick="searchMovie('/movie/movieInfo','movieInfoKey','movieType')">
						<i class="icon-ok bigger-110"></i>
						查询
					</button>
				</label>
			</div>
			<div class="row">
				<c:forEach items="${movieList}" var="movie">
				<div class="col-xs-6 col-sm-3 pricing-box">
					<div class="widget-box">
						<div class="widget-header header-color-green">
							<h5 class="bigger lighter">${movie.movename}</h5>
							<input type="hidden" id="movieid" name="movieid" value="${movie.moveid}">
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<ul class="list-unstyled spaced2">
									<li>
										<i class="icon-ok green"></i>
										片名：${movie.movename}
									</li>

									<li>
										<i class="icon-ok green"></i>
										描述：${movie.director}
									</li>

									<li>
										<i class="icon-ok green"></i>
										导演：${movie.actor}
									</li>

									<li>
										<i class="icon-ok green"></i>
										语言：${movie.language}
									</li>

									<li>
										<i class="icon-ok green"></i>
										类型：${movie.type.typename}
									</li>
								</ul>
								<hr />
							</div>
							<div>
								<div>
									<a href="#" class="btn btn-block btn-success" onclick="option('/movie/buy','movieid',${movie.moveid})">
										<i class="icon-shopping-cart bigger-110"></i>
										<span>Buy</span>
									</a>
								</div>
							</div>
						</div>

					</div>
				</div>
				</c:forEach>
			</div>
		</div><!-- /span -->
	</div><!-- /user-profile -->
	<script type="text/javascript">
		jQuery(function($) {
			$('#user-profile-3').end().find('.date-picker').datepicker().next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
		});
	</script>
	</body>
</html>