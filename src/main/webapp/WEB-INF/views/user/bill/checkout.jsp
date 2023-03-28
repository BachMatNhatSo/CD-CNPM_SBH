<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3>Thanh Toasn</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">			
		
		<form:form action="checkout" methos="post" modelAttribute="bill">  
		<h3>Thanh Toan Don Hang</h3>
		<div class="control-group">
			<label class="control-label">Họ Tên <sup>*</sup></label>
			<div class="controls">
			   <form:input type="text" placeholder ="Mời Nhập Họ Tên" path="displayname" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Email <sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" class="span3" placeholder ="Mời Nhập Họ Tên" path="user" />
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">Liên Hệ <sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" class="span3" placeholder ="Mời Nhập SDT" path="phone" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">Địa Chỉ <sup>*</sup></label>
			<div class="controls">
			 <form:textarea  path="address" row ="5" cols="30" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Ghi Chú <sup>*</sup></label>
			<div class="controls">
			 <form:textarea  path="note" row ="5" cols="30" />
			</div>
		</div>
	<div class="control-group">
		<div class="controls">
		 <input type="submit" name="submitAccount" value="Đặt Hàng" class="shopBtn exclusive">
		</div>
	</div>
	</form:form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		
	</div>	
	
</div>