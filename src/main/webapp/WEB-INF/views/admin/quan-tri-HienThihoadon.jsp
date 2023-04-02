<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>My Table</title>
    <style>
      #dataTable {
        border-collapse: collapse;
        width: 100%;
        font-size: 14px;
        text-align: center;
      }

      #dataTable thead tr {
        background-color: #f5f5f5;
        font-weight: bold;
      }

      #dataTable tbody tr:nth-child(even) {
        background-color: #f2f2f2;
      }

      #dataTable tbody tr:hover {
        background-color: #ddd;
      }

      #dataTable th,
      #dataTable td {
        padding: 12px;
        border: 1px solid #ddd;
      }

      #dataTable th {
        text-align: center;
      }
    </style>
  </head>
  <body>
  <h3><a href="<c:url value="/admin/ds-hoadon"></c:url>"> Thêm </a></h3>
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
      <thead>
        <tr>
          <th>Tài Khoản</th>
          <th>Số Điện Thoại</th>
          <th>Tên Người Dùng</th>
          <th>Địa Chỉ</th>
          <th>Tổng Đơn</th>
          <th>Số Lượng </th>
          <th>Ghi Chú</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${bills}">
          <tr>
            <td>${item.user}</td>
            <td>${item.phone}</td>
            <td>${item.displayname}</td>
            <td>${item.address}</td>
            <td>${item.total}</td>
            <td>${item.quanty}</td>
            <td>${item.note}</td>
            <td>
            	<a href="hoadon-edit?id=${item.id }">Edit</a>
            	<a href="hoadon-delete?id=${item.id }">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
