<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>用户信息</title>
	</head>

	<body>
	<div id="user-profile-3" class="user-profile row">
		<div class="col-sm-offset-1 col-sm-10">
			<div class="space"></div>

			<form class="form-horizontal" action="/user/updateUser" method="post" >
				<div class="tabbable">
					<ul class="nav nav-tabs padding-16">
						<li class="active">
							<a data-toggle="tab" href="#edit-basic">
								<i class="green icon-edit bigger-125"></i>
								基础信息
							</a>
						</li>

						<li>
							<a data-toggle="tab" href="#edit-settings">
								<i class="purple icon-cog bigger-125"></i>
								设置
							</a>
						</li>

						<li>
							<a data-toggle="tab" href="#edit-password">
								<i class="blue icon-key bigger-125"></i>
								密码管理
							</a>
						</li>
					</ul>

					<div class="tab-content profile-edit-tab-content">
						<div id="edit-basic" class="tab-pane in active">
							<h4 class="header blue bolder smaller">General</h4>

							<div class="row">
								<div class="col-xs-12 col-sm-4">
									<input type="file" />
								</div>

								<div class="vspace-xs"></div>

								<div class="col-xs-12 col-sm-8">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right" for="form-field-username">昵称</label>

										<div class="col-sm-8">
											<input class="col-xs-12 col-sm-10" type="text" name="loginname" id="form-field-username" placeholder="loginname" value="${user.loginname}" />
											<input type="hidden" name="userid" value="${user.userid}"/>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right" for="form-field-first">姓名</label>

										<div class="col-sm-8">
											<input class="input-small" type="text" name="firstName" id="form-field-first" placeholder="First Name" value="${user.username}" />
											<input class="input-small" type="text" name="lastName" id="form-field-last" placeholder="Last Name" value="${user.username}" />
										</div>
									</div>
								</div>
							</div>

							<hr />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-date">生日</label>

								<div class="col-sm-9">
									<div class="input-medium">
										<div class="input-group">
											<input class="input-medium date-picker" name="birthday" id="form-field-date" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
											<span class="input-group-addon" id="schedule-boxS">
											<i class="icon-calendar"></i>
										</span>
										</div>
									</div>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">性别</label>

								<div class="col-sm-9">
									<label class="inline">
										<input name="sex" type="radio" class="ace" />
										<span class="lbl"> 男生</span>
									</label>

									&nbsp; &nbsp; &nbsp;
									<label class="inline">
										<input name="sex" type="radio" class="ace" />
										<span class="lbl"> 女生</span>
									</label>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">个性签名</label>

								<div class="col-sm-9">
									<textarea id="form-field-comment" name="sign"></textarea>
								</div>
							</div>

							<div class="space"></div>
							<h4 class="header blue bolder smaller">Contact</h4>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-email">邮箱</label>

								<div class="col-sm-9">
								<span class="input-icon input-icon-right">
									<input type="email" id="form-field-email" value="${user.email}" name = "email"/>
									<i class="icon-envelope"></i>
								</span>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">电话</label>

								<div class="col-sm-9">
								<span class="input-icon input-icon-right">
									<input class="input-medium input-mask-phone" value="${user.tell}" name="tell" type="text" id="form-field-phone" />
									<i class="icon-phone icon-flip-horizontal"></i>
								</span>
								</div>
							</div>
							<div class="space"></div>
						</div>
					</div>
				</div>

				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn btn-info" type="submit">
							<i class="icon-ok bigger-110"></i>
							保存
						</button>

						&nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i>
							重置
						</button>
					</div>
				</div>
			</form>
		</div><!-- /span -->
	</div><!-- /user-profile -->
	</body>
</html>

