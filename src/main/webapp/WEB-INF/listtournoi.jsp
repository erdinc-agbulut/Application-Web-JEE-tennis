<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html lang="fr">
  <head>
   
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="starter-template.css">
    <title>Liste des tournois</title>
    <link rel="icon" type="image/png" sizes="16x16" href="logonglet.png">
  </head>
  <body>
<%@ include file="menu.jsp" %>
<main role="main" class="container">

  <div class="starter-template">
    <h1>Liste des Tournois</h1>
    <p class="lead">Bienvenue <c:out value="${ connectedUser.login}" /></p>
  </div>

</main><!-- /.container -->
<div class="container">

<div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
<a class="btn btn-primary" href="/ApplicationJoueur/ajoutertournoi" role="button">Ajouter un tournoi</a>
<a href="/ApplicationJoueur/listtournoi"  role="button" data-bs-toggle="button" style="position:relative; left:5px; top:10px"><img class="mb-4" src="refresh.png" alt="" style=""></a>

</div>

<table class="table">
  <thead>
    <tr>
      <th scope="col" style="width:10%">#</th>
      <th scope="col" style="width:25%">Nom</th>
      <th scope="col" style="width:20%">Code</th>
	  <th scope="col" style="width:20%"></th>
    </tr>
  </thead>
  <tbody>
  
  <c:if test="$(nboccurence == 0)" >
  <tr>
  <td colspan="5" style="text-align:center">
  </td>
  </tr>
  </c:if>
  
  <c:forEach var="tournoi" items="${tournois}">
  <form action="modifiertournoi" method="get">
  <tr>
  	
  	<td><c:out value="${tournoi.id }" /></td> 
  	<td><c:out value="${tournoi.nom }" /></td>
  	<td><c:out value="${tournoi.code }" /></td>
  	<td>
	  
	    <a type="submit" class="btn btn-outline-primary" href="/ApplicationJoueur/modifiertournoi?id=${ tournoi.id }" role="button"  >Modifier</a>
		<a type="submit" class="btn btn-outline-warning" href="/ApplicationJoueur/supprimertournoi?id=${ tournoi.id }" role="button"  >Supprimer</a>

	  </td>
	 </tr>
	 </form>
   </c:forEach>   
  </tbody>
</table>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>


