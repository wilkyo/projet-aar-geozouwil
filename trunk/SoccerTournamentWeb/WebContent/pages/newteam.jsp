<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="styles/base.css" />
<title>New Team</title>
</head>
<body>
	<div>
		<p>
			<a href="?action=home">Home</a>
		</p>
		<center>
			<h1>Create a new team</h1>
		</center>
		<form action="">
			<input type="hidden" name="action" value="newteam" />
			<table align="center">
				<tr>
					<td>Equipe</td>
					<td><input type="text" name="nameEquipe"></input></td>
				</tr>
				<tr>
					<td></td>
					<td>Nom</td>
					<td>Prénom</td>
					<td>Représentant</td>
				</tr>
				<tr>
					<td>Joueur 1</td>
					<td><input type="text" name="nomjoueur1"></input></td>
					<td><input type="text" name="prenomjoueur1"></input></td>
					<td><input type="checkbox" value="c" checked="checked"></input></td>
				</tr>
				<tr>
					<td>Joueur 2</td>
					<td><input type="text" name="nomjoueur2"></input></td>
					<td><input type="text" name="prenomjoueur2"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 3</td>
					<td><input type="text" name="nomjoueur3"></input></td>
					<td><input type="text" name="prenomjoueur3"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 4</td>
					<td><input type="text" name="nomjoueur4"></input></td>
					<td><input type="text" name="prenomjoueur4"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 5</td>
					<td><input type="text" name="nomjoueur5"></input></td>
					<td><input type="text" name="prenomjoueur5"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 6</td>
					<td><input type="text" name="nomjoueur6"></input></td>
					<td><input type="text" name="prenomjoueur6"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 7</td>
					<td><input type="text" name="nomjoueur6"></input></td>
					<td><input type="text" name="prenomjoueur6"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 8</td>
					<td><input type="text" name="nomjoueur7"></input></td>
					<td><input type="text" name="prenomjoueur7"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 9</td>
					<td><input type="text" name="nomjoueur8"></input></td>
					<td><input type="text" name="prenomjoueur8"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 10</td>
					<td><input type="text" name="nomjoueur10"></input></td>
					<td><input type="text" name="prenomjoueur10"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td>Joueur 11</td>
					<td><input type="text" name="nomjoueur11"></input></td>
					<td><input type="text" name="prenomjoueur11"></input></td>
					<td><input type="checkbox" value="c"></input></td>
				</tr>
				<tr>
					<td><input type="button" value="+" style="width: 54px;"
						onclick=""></input></td>
					<td><input type="hidden" name="create" /><input type="submit"
						value="create" style="width: 130px;" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>