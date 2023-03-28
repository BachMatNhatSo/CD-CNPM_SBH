<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Login</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>Đăng Ký Tài Khoản</h5><br/>
		
			<form:form action="dang-ky" methos="POST" modelAttribute="user">  
			  <div class="control-group">
				<label class="control-label" for="inputEmail">E-mail </label>
				<div class="controls">				  
				  <form:input type="email" class="span3" placeholder ="Mời Nhập Email" path="user" />  
				</div>
			  </div>
			   <div class="control-group">
				<label class="control-label" for="inputEmail">Mật Khẩu </label>
				<div class="controls">
				  
				  <form:input type="password" class="span3" placeholder="Mời Nhập Mật Khẩu" path="password" />
				</div>
			  </div>
			   <div class="control-group">
				<label class="control-label" for="inputEmail">Họ Tên </label>
				<div class="controls">
				  
				   <form:input type="text" class="span3" placeholder="Mời Nhập Họ Tên" path="displayname" />
				</div>
			  </div>
			   <div class="control-group">
				<label class="control-label" for="inputEmail">Địa Chỉ</label>
				<div class="controls">				 
				   <form:input type="text" class="span3" placeholder="Mời Nhập Địa Chỉ" path="address" />
				</div>
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn block">Tạo Tài Khoản</button>
			  </div>
			</form:form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>Đăng Nhập</h5>
			<h1>${statusLogin }</h1>
			<form:form action="dang-nhap" methos="POST" modelAttribute="user">  
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
				
				  <form:input type="email" class="span3" placeholder ="Mời Nhập Email" path="user" />
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Mật Khẩu</label>
				<div class="controls">
				 
				   <form:input type="password" class="span3" placeholder="Mời Nhập Mật Khẩu" path="password" />
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Đăng Nhập</button> <a href="#">Quên Mật Khẩu</a>
				</div>
			  </div>
			</form:form>
		</div>
		</div>
	</div>	
	
</div>