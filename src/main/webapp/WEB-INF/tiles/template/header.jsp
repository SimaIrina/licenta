<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="header-footer">
	<div class="logo">
		<a href="<spring:url value="/" />"><img alt=""
			src="<spring:url value="/resources/images/logo_sima.png"/>"
			height="45px"> </a>
	</div>
	<div class="menu">
		<div class="menu-text separator">
			<a href=""><spring:message code="label.what.we.serve" /></a>
		</div>
		<div class="menu-text separator">
			<a href=""><spring:message code="label.what.you.get" /></a>
		</div>
		<div class="menu-text">
			<a href=""><spring:message code="label.who.we.are" /></a>
		</div>
	</div>
	<div class="menu pull-right">
		<div class="menu-text separator">
			<security:authorize access="isAnonymous()">
				<a href="<spring:url value="/patients/register" />"><spring:message
						code="label.join.us" /> ></a>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<a href="<spring:url value="/patients/home" />"><spring:message
						code="label.welcome" /> <security:authentication
						property="principal.username" /></a>
				<br />
				<a href="<spring:url value="/doLogout" />"><spring:message
						code="label.logout" /></a>
			</security:authorize>
		</div>
		<div class="menu-text">
			<a href=""><img alt=""
				src="<spring:url value="/resources/images/phone.png" />"
				height="16px"> 0720032006 </a>
		</div>
		
	</div>
</div>
