<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content text-align-center">
	<div class="margin-top-middle red font-size-huge">Nu se poate accesa pagina!</div>

	<div class="margin-top-middle">
		<img
			src="<spring:url value="/resources/images/404_1.png"  htmlEscape="true" />"
			alt="Autorizarea a e?uat!!!" />
	</div>

	<div class="margin-top-middle gray-text font-size-middle">
		<a href="<spring:url value="/home" />">&lt; <spring:message
				code="label.go.back" /></a>
	</div>

	<div class="margin-top-middle"></div>
</div>