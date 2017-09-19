<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>CRM客户关系管理系统_用户登录</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="JavaScript" type="text/javascript" src="js/CheckForm.js"></script>
<script language="JavaScript" type="text/javascript" src="js/FormValid.js"></script>

<script type="text/javascript">
	var errori ='<%=request.getParameter("error")%>'
	if (errori == 'yes') {
		alert("用户或密码错误！请重新输入！");
	}
</script>
<link rel="stylesheet" type="text/css" href="css/login.css" />


<%
	String unum = "";
	String upw = "";
	String check = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {

		for (int i = 0; i < cookies.length; i++) {
			if ("unum".equals(cookies[i].getName())) {
				unum = cookies[i].getValue();
				check = "checked";
			}
			if ("upw".equals(cookies[i].getName())) {
				upw = cookies[i].getValue();
			}
		}

	}
%>
</head>

<body>
	<form name="from1" action="EmployeeServlet?method=login"
		method="post" onsubmit="return validator(this)">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<table width="962" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="235" background="images/login_03.gif">&nbsp;</td>
						</tr>
						<tr>
							<td height="53"><table width="100%" border="0"
									cellspacing="0" cellpadding="0">
									<tr>
										<td width="394" height="53"
											background="images/login_05.gif">&nbsp;</td>
										<td width="206" background="images/login_06.gif">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="16%" height="25"><div align="right">
															<span class="STYLE1">用户</span>
														</div></td>
													<td width="57%" height="25">
														<div align="center">
															<input type="text" name="userNum" value="<%=unum%>"
																valid="required|regexp" regexp="^[A-Za-z0-9]+$"
																errmsg="用户名不能为空!|账号只能由字母和数字组成!"
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div>
													</td>
													<td width="27%" height="25"></td>
												</tr>

												<tr>
													<td height="25"><div align="right">
															<span class="STYLE1">密码</span>
														</div></td>
													<td height="25">
														<div align="center">
															<input type="password" name="userPw" value="<%=upw%>"
																valid="required" errmsg="密码不能为空!"
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div>
													</td>
													<td height="25"><div align="left">
															<input type="submit" id="in1" value="" />
														</div></td>
												</tr>
											</table>
										</td>
										<td width="362" background="images/login_07.gif">&nbsp;
										</td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td height="213" background="images/login_08.gif"
								id="mytd" align="center" valign="top"><span>&nbsp;
									<input type="checkbox" name="remember" value="remember"
									id="remember" <%=check%>>
							</span> <span>&nbsp;&nbsp;记住密码</span><br> <br> <br> <br>
								${loginerror } ${activeerror } ${sendEmail }</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>