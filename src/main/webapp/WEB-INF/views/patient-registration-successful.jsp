<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content default-height">
	<div class="margin-top-middle margin-left-large gray-text font-size-middle">
		Contul tau a fost creat cu succes:
		${patient.user.email}.<br /> Te poti loga <a class="text-underline"
			href="<spring:url value="/login" />">aici</a> pentru a-ti face o programare! 
		
	</div>
</div>