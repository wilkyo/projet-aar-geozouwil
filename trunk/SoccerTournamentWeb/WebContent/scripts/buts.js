var requete;

function getJoueurs() {
	var equipe = document.getElementById("butEquipe");
	var url = "index?action=ajax&butEquipe=" + escape(equipe.value);
	if (window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		requete.open("GET", url, true);
		requete.onreadystatechange = majIHM;
		requete.send(null);
	} else if (window.ActiveXObject) {
		requete = new ActiveXObject("Microsoft.XMLHTTP");
		if (requete) {
			requete.open("GET", url, true);
			requete.onreadystatechange = majIHM;
			requete.send();
		}
	} else {
		alert("Le navigateur ne supporte pas la technologie Ajax");
	}
}

function majIHM() {
	if (requete.readyState == 4) {
		if (requete.status == 200) {
			// exploitation des données de la réponse
			mdiv = document.getElementById("butJoueur");
			mdiv.innerHTML = requete.responseText;
			mdiv.style.display = 'block';
		}
	}
}