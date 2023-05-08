# Gestion de bibliothèque
Dans ce projet nous allons créer les 3 couches classiques d'une application Jakarta EE.
Dans cette première version nous utilisons nos classes préalablement réalisées: Database,DataSource,...

Dans une prochaine version nous allons nous baser sur JPA: Java Persistence API.

## 1.Configuration
Nous allons séparer les paramètres de configuration de notre DataSource dans un fichier de propriétés personnalisé: biblio.properties.L'inégration d'un telle fichier sera faite dans n'importe quelle classe annotée (en particulier dans une classe de configuration) comme suit:

```
@Configuration
@PropertySource("classpath:biblio.properties")
public class DataSource{

}
```
L'injection d'une propriété 'p' sera réalisé comme suit :

@Value("${p}")
## 2.Boucles Thymeleaf 
Pour parcourir une liste d'auteurs par exemple : authors,on utilisera la template suivante:

```
<tr th:each="a : ${authors}">

</tr>
```