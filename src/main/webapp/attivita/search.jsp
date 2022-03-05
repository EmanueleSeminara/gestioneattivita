<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestioneattivita.model.Attivita"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Inserisci Nuova Attività</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuova attività</h5> 
				    </div>
				    <div class='card-body'>
		
		
		
							<form method="post" action="ExecuteSearchAttivitaServlet" class="row g-3" novalidate="novalidate">
							
								<% Attivita attivitaInPagina = (Attivita)request.getAttribute("search_attivita_attr"); %>
							
								<div class="col-md-6">
									<label for="titolo" class="form-label">Titolo </label>
									<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo"  
										value="<%=attivitaInPagina.getTitolo()!=null?attivitaInPagina.getTitolo():"" %>">
								</div>
								
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Descrizione </label>
									<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"  
										value="<%=attivitaInPagina.getDescrizione()!=null?attivitaInPagina.getDescrizione():"" %>">
								</div>
							
								<div class="col-md-6">
									<label for="priorita" class="form-label">Priorità </label>
									<input type="number" class="form-control" name="priorita" id="priorita" placeholder="Inserire priorita" 
									value="<%=attivitaInPagina.getPriorita()!=null?attivitaInPagina.getPriorita():"" %>">
								</div>
								
								<div class="col-md-3">
									<label for="data" class="form-label">Data</label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=attivitaInPagina.getData()!=null? new SimpleDateFormat("yyyy-MM-dd").format(attivitaInPagina.getData()):""  %>"/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>