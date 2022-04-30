<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">  
  <img class="mb-4" src="logonglet.png" style="position:relative; width:25px; top:10px"  alt="">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ajouter</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/ApplicationJoueur/ajouterjoueur">Ajouter un joueur</a>
          <a class="dropdown-item" href="/ApplicationJoueur/ajoutertournoi">Ajouter un tournoi</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Lister</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/ApplicationJoueur/listjoueur">Lister les joueurs</a>
          <a class="dropdown-item" href="/ApplicationJoueur/listtournoi">Lister les tournois</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Match</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/ApplicationJoueur/listvainqueur">Liste des vainqueurs</a>
          <a class="dropdown-item" href="/ApplicationJoueur/listfinaliste">Liste des finalistes</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Epreuves</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/ApplicationJoueur/listepreuve">Liste des epreuves</a>
        </div>
      </li>
	
       <li class="nav-item">
	    <form class="form-inline my-2 my-lg-0" action="listjoueur" method="post">      
         <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1" value="Deconnexion">Deconnexion</button>
    
         </form>
      </li>
     
    </ul>
    <form class="form-inline my-2 my-lg-0" action="listjoueur" method="post">
      <input class="form-control mr-sm-2" type="text" name="txtsearch" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1" value="Rechercher">Rechercher un joueur</button>
    </form>
    <form class="form-inline my-2 my-lg-0" action="listtournoi" method="post">
      <input class="form-control mr-sm-2" type="text" name="txtsearch1" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action2" value="Rechercher">Rechercher un tournoi</button>
    </form>
  </div>
</nav>
