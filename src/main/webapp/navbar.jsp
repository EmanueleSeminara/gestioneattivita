<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<header>
  <!-- Fixed navbar -->
 <nav class="navbar navbar-expand-lg navbar-dark bg-primary" aria-label="Eighth navbar example">
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
			<c:set var="classHome" value="${activePage != 'search' && activePage != 'add'?'nav-link active': 'nav-link'}"></c:set>
			<c:set var="classSearch" value="${activePage == 'search'?'nav-link active': 'nav-link'}"></c:set>
			<c:set var="classAdd" value="${activePage == 'add'?'nav-link active': 'nav-link'}"></c:set>
			
            <a class="${classHome}" aria-current="page" href="index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="${classSearch}" href="PrepareSearchAttivitaServlet">Cerca</a>
          </li>
          <li class="nav-item">
            <a class="${classAdd}" href="PrepareInsertAttivitaServlet">Inserisci</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

  
  
</header>