<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand ps-3" href="index.html">${Loginfo.displayname }</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text"
					placeholder="Mã dịch vụ vận chuyển..." aria-label="Search for..."
					aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item"><a
				href="<c:url value="/dang-xuat-admin"></c:url>"><span
					class="icon-edit"></span>Đăng Xuất </a></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Thông tin chính</div>
						<a class="nav-link"
							href="<c:url value="/admin/tong-quan"></c:url>">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Tổng Quan
						</a>
						<div class="sb-sidenav-menu-heading">Chi tiết</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Tài sản
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="layout-static.html">Tình trạng kho</a>
								<a class="nav-link" href="layout-sidenav-light.html">Tình
									trạng xe </a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Kinh doanh
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> Hóa đơn
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseAuth"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="login.html">Hóa đơn vận chuyển</a> <a
											class="nav-link" href="register.html">Hóa đơn thuê kho</a> <a
											class="nav-link" href="password.html">Hóa đơn thuê xe</a>
									</nav>
								</div>
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseError" aria-expanded="false"
									aria-controls="pagesCollapseError"> Sản phẩm
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseError"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="404.html">Chọn xe</a>
									</nav>
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="404.html">Đang cung cấp</a>
									</nav>
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="404.html">Tồn kho</a>
									</nav>

								</div>
							</nav>
						</div>
						<div class="sb-sidenav-menu-heading">Thống kê</div>
						<a class="nav-link" href="charts.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Biểu đồ thống kê
						</a> <a class="nav-link" href="tables.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Bảng thống kê
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Đăng nhập bởi:</div>
					ADMIN
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Tổng Quan</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Tổng Quan</li>
					</ol>
					<div class="row">
						<div class="col-xl-3 col-md-6">
							<div class="card bg-primary text-white mb-4">
								<div class="card-body">Tình trạng kho trống:</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="#">Xem chi
										tiết</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-warning text-white mb-4">
								<div class="card-body">Tình trạng xe trống:</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="#">Xem chi
										tiết</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-success text-white mb-4">
								<div class="card-body">Tồn kho trái cây:</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="#">Xem chi
										tiết</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-danger text-white mb-4">
								<div class="card-body">Tài khoản khách hàng:</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="#">Xem chi
										tiết</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Danh sách khách hàng
						</div>
						<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Id</th>
								<th>Tên loại sản phẩm</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ categorys }">
						<li><a href='<c:url value="/san-pham/${ item.id }"></c:url>'><span
								class="icon-circle-blank"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Admin &copy; Logistic</div>
						<div>
							<a href="#">Nguyễn Quốc Khánh</a> <span>|</span> <a href="#">Hoàng
								Thị Yến Trinh</a> <span>|</span> <a href="#">Trần Ngọc Trung</a> <span>|</span>
							<a href="#">Lê Vi Tú</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>