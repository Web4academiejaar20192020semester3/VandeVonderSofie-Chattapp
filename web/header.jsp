<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<img alt="Banner" src="images/ChatApp.jpg">
<nav>
<ul>

<%--<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>

</c:otherwise>
</c:choose>--%>


</ul>
</nav>
<h2>
${param.title}
</h2>

</header>