<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>H+ Sports</title>
<style type="text/css">
body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.header {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 18px;
}

.outertable {
	border: 1px solid #CAD6E0;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.innertable {
	width: 100%;
	text-align: left;
	height: 150px;
	border: none;
}

.bottom {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	text-align: center;
	vertical-align: middle;
	color: #8E969D;
	border: 0px;
}
</style>
<link type="text/css" rel="stylesheet" href="resources/css/global.css" />
</head>
<body>
	<table class="outertable">
		<tbody>

			<tr>
				<td class="header" height="42" align="center" valign="middle"
					width="100%" bgcolor="#E4EBEB">Entry Form | Catalog</td>
			</tr>
			<tr>
				<td height="1" width="100%" bgcolor="#CAD6E0"></td>
			</tr>
			<tr>
				<td><img src="resources/img/banner.jpeg" /></td>
			</tr>
			<tr>
				<td width="100%" colspan="2">
					${pageContext.request.contextPath}
					${param.name}
					${cookie.someCookie.value}
					<h3>Item Count: ${products.size() * 2}</h3>
					<table class="innertable">
						<tbody>
							<tr>
								<th>Name</th>
								<th>Manufacturer</th>
								<th>SKU</th>
							</tr>
							<c:forEach items="${products}" var="prod">
								<tr>
									<td>
										<c:out value="${prod.name}"/>										
									</td>
									<td>
										<c:out value="${prod.manufacturer}"/>										
									</td>
									<td>
										<c:out value="${prod.sku}"/>										
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="bottom" height="1" width="100%"
					bgcolor="#CAD6E0"></td>
			</tr>
		</tbody>
	</table>
</body>

</html>
