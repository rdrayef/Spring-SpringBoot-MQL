# API Rest pour la gestion de bibliothèque
Nous appelons API REST Toute solution web permettant de désservir des objets "JSON" (ou XML) plutôt que des pages web.selon les conventions d'une architecture Rest.

## 1. Reqûêtes HTTP REST:
Une architecture REST se base sur le protocole HTTP est un ensemble de conventiion HTTP basées sur des méthodes HTTP classiques.Ainsi pour l'échange d'auteurs par exemple, on utilisera les convenrions suivantes : 

```
GET		/biblio/authors

GET		/biblio/authors/{id}

POST	/biblio/authors

PUT		/biblio/authors/{id}

DELETE /biblio/authors/{id}
```