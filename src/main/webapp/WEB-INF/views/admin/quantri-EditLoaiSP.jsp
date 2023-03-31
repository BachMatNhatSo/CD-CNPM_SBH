<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	
	<form:form action="edit" methos="POST" modelAttribute="categorys">		
	<form:hidden path ="id"/>
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Tên Loại Sản Phẩm </label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="name" />  
				</div>
			  </div>			  
			   <div class="control-group">
				<label class="control-label" for="inputEmail">Miêu Tả </label>
				<div class="controls">				  
				  <form:input type="text" class="span3" placeholder ="Mời Nhập Email" path="description" />  
				</div>
			  </div>
			    <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Thêm</button> 
				</div>
			  </div>
			</form:form>