<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	
	<form:form action="ds-taikhoan" methos="post" modelAttribute="accounts">	
	<form:hidden path ="id"/>	
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Tài Khoản </label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="user" />  
				</div>
			  </div>			  
			   <div class="control-group">
				<label class="control-label" for="inputEmail">Mật Khẩu</label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="password" />  
				</div>
			  </div>
			     <div class="control-group">
				<label class="control-label" for="inputEmail">Tên Người Dùng</label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="displayname" />  
				</div>
			  </div>
			     <div class="control-group">
				<label class="control-label" for="inputEmail">Địa Chỉ</label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="address" />  
				</div>
			  </div>
			     <div class="control-group">
				<label class="control-label" for="inputEmail">Vai Trò</label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="vaitro" />  
				</div>
			  </div>
			    <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Xác Nhận</button> 
				</div>
			  </div>
			</form:form>