<?xml version="1.0" encoding="UTF-8" ?>

<cities xmlns:c="http://java.sun.com/jsp/jstl/core">
	<headings>
		<heading>City</heading>
		<heading>Time</heading>
		<heading>Population</heading>
	</headings>
<c:forEach var="city" items="${cities}">
	<city>
		<name>${city.name}</name>
		<time>${city.shortTime}</time>
		<population>${city.population}</population>
	</city>
</c:forEach>
</cities>