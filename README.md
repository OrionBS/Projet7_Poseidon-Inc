# Projet Poseidon Inc - Financial's App
***

Il s’agit d’un logiciel d’entreprise déployé sur le Web qui vise à générer d'avantage de transactions pour les investisseurs institutionnels qui achètent et vendent des titres à revenu fixe.

#### Lien Github : https://github.com/OrionBS/Projet7_Poseidon-Inc

## Pour commencer

### Pré-requis

- IntelliJ (Environnement de développement)
- Java 11
- MySQL
- Maven 3.6.3
- NodeJS
- NPM
- Angular

### Téléchargement

```
cd /"dossier de téléchargement"/
git clone https://github.com/OrionBS/Projet7_Poseidon-Inc
cd /Projet7_Poseidon-Inc
```

### Installation

Pensez à intaller les dernières versions de Java, MySQL, Maven, NodeJS, NPM et Angular

### Paramétrage MySQL

Dans la console, démarrez MySQL
```
mysql
```
Puis créez la base de donnée et l'utilisateur avec ses privilèges.
```
create database poseidonApp;
create user 'poseidonUsername'@'localhost' identified by 'poseidonPassword';
grant all privileges on poseidonApp.* to 'poseidonUsername'@'localhost';
flush privileges;
```

## Démarrage

API :

```
cd ./Poseidon_SpringAPI
mvn build
java -jar PoseidonAPI.jar
```

FRONT :

```
cd ./Poseidon-AngularFront
npm start
```

## Web

http://localhost:4200

## Fabriqué avec

* [IntelliJ Community](https://www.jetbrains.com/idea/download/#section=windows) - Environnement de développement
* [Java SE JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - JDK Java
* [Maven 3.6.3](http://maven.apache.org/download.cgi) - Maven
* [NodeJS](https://nodejs.org/en/) - NodeJS
* [Angular](https://angular.io/) - Angular

### Rapport SureFire

```
$ mvn surefire-report:report
```

## Versions

**Dernière version stable :** 1.0

## Auteurs
Listez le(s) auteur(s) du projet ici !
* **Orion Beauny** _alias_ [@OrionBS](https://github.com/OrionBS)
* Tous les [contributeurs](https://github.com/OrionBS/Projet5_SafetyNet/contributors)

## License

Ce projet est conçu pour répondre en tant que travail d'étudiant lors d'une soutenance.


