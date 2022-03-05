<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestioneattivita.model.Attivita"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Elemento</title>
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
				        <h5>Modifica elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteEditAttivitaServlet" class="row g-3" novalidate="novalidate">
							
								<% Attivita attivitaInPagina = (Attivita)request.getAttribute("visualizza_attivita_attr"); %>
								<input type="hidden" name="idAttivita" value="<%=attivitaInPagina.getId()%>">
								
							
								<div class="col-md-6">
									<label for="titolo" class="form-label">Codice <span class="text-danger">*</span></label>
									<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il codice"  
										value="<%=attivitaInPagina.getTitolo()!=null?attivitaInPagina.getTitolo():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Descrizione <span class="text-danger">*</span></label>
									<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"  
										value="<%=attivitaInPagina.getDescrizione()!=null?attivitaInPagina.getDescrizione():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="priorita" class="form-label">Prezzo <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="priorita" id="priorita" placeholder="Inserire prezzo" 
									value="<%=attivitaInPagina.getPriorita()!=null?attivitaInPagina.getPriorita():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="data" class="form-label">Data di Arrivo<span class="text-danger">*</span></label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=attivitaInPagina.getData()!=null? new SimpleDateFormat("yyyy-MM-dd").format(attivitaInPagina.getData()):""  %>" required/>
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