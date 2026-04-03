# BloomBar Rose Backend API

API REST pour la gestion d'une boutique de vente de bouquets de fleurs.  
Développée avec **Spring Boot 3.5** · **Java 17** · **MySQL** · Architecture en couches (Controller / Service / Repository / DTO / Mapper).

---

## Stack technique

| Technologie       | Version        |
|-------------------|----------------|
| Java              | 17             |
| Spring Boot       | 3.5.3          |
| Spring Data JPA   | —              |
| Spring Validation | —              |
| MySQL Connector   | —              |
| Maven             | Wrapper inclus |

---

## Architecture du projet

```
src/main/java/sn/bloombar/rose_backend/
├── controller/   # Points d'entrée HTTP (REST)
├── service/      # Logique métier
├── repository/   # Accès base de données (Spring Data JPA)
├── modele/       # Entités JPA
├── dto/          # Objets de transfert de données
└── mapper/       # Conversion modèle ↔ DTO
```

---

## Modèle de données

```
Categorie (1) ──── (N) Produit (N) ──── (1) Commande (1) ──── (1) Paiement
                                               │
                                           (N) User (1)
```

| Entité    | Champs principaux                                |
|-----------|--------------------------------------------------|
| Produit   | id, nom, taille, description, prix, categorie    |
| Categorie | id, nom                                          |
| Commande  | id, statue, total, produit, user                 |
| Paiement  | id, datepaiement, montant, ref, commande         |
| User      | id, nom, prenom, numero, role                    |

---

## Endpoints de l'API

### Produits — `/api/produit`

| Méthode | URL                | Description                |
|---------|--------------------|----------------------------|
| GET     | /api/produit/liste | Liste tous les produits    |
| GET     | /api/produit/{id}  | Récupère un produit par ID |
| POST    | /api/produit       | Crée un nouveau produit    |
| PUT     | /api/produit/{id}  | Met à jour un produit      |
| DELETE  | /api/produit/{id}  | Supprime un produit        |

### Catégories — `/api/categorie`

| Méthode | URL                   | Description                   |
|---------|-----------------------|-------------------------------|
| GET     | /api/categorie/liste  | Liste toutes les catégories   |
| GET     | /api/categorie/{id}   | Récupère une catégorie par ID |
| POST    | /api/categorie        | Crée une catégorie            |
| PUT     | /api/categorie/{id}   | Met à jour une catégorie      |
| DELETE  | /api/categorie/{id}   | Supprime une catégorie        |

### Commandes — `/api/commande`

| Méthode | URL                         | Description                           |
|---------|-----------------------------|---------------------------------------|
| GET     | /api/commande/liste         | Liste toutes les commandes            |
| GET     | /api/commande/{id}          | Récupère une commande par ID          |
| POST    | /api/commande?userId={id}   | Crée une commande pour un utilisateur |
| PUT     | /api/commande/{id}          | Met à jour une commande               |
| DELETE  | /api/commande/{id}          | Supprime une commande                 |

### Paiements — `/api/paiement`

| Méthode | URL                  | Description                 |
|---------|----------------------|-----------------------------|
| GET     | /api/paiement/liste  | Liste tous les paiements    |
| GET     | /api/paiement/{id}   | Récupère un paiement par ID |
| POST    | /api/paiement        | Enregistre un paiement      |
| PUT     | /api/paiement/{id}   | Met à jour un paiement      |
| DELETE  | /api/paiement/{id}   | Supprime un paiement        |

### Utilisateurs — `/api/user`

| Méthode | URL              | Description                    |
|---------|------------------|--------------------------------|
| GET     | /api/user/liste  | Liste tous les utilisateurs    |
| GET     | /api/user/{id}   | Récupère un utilisateur par ID |
| POST    | /api/user        | Crée un utilisateur            |
| PUT     | /api/user/{id}   | Met à jour un utilisateur      |
| DELETE  | /api/user/{id}   | Supprime un utilisateur        |

---

## Lancer le projet en local

### Prérequis

- Java 17+
- MySQL 8+
- Maven (ou utiliser le wrapper `./mvnw`)

### Configuration

Créer/éditer `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_bbs
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

### Démarrage

```bash
# Cloner le repo
git clone https://github.com/votre-username/rose-backend.git
cd rose-backend

# Lancer avec Maven wrapper
./mvnw spring-boot:run

# Ou avec Maven installé
mvn spring-boot:run
```

L'API est accessible sur `http://localhost:8080`

---

## Exemples de requêtes

### Créer un produit

```bash
curl -X POST http://localhost:8080/api/produit \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "Bouquet Romantique",
    "taille": "Grand",
    "description": "Roses rouges et gypsophile",
    "prix": 15000,
    "categorie": { "id": 1 }
  }'
```

### Passer une commande

```bash
curl -X POST "http://localhost:8080/api/commande?userId=1" \
  -H "Content-Type: application/json" \
  -d '{
    "statue": "EN_ATTENTE",
    "total": 15000,
    "produit": { "id": 1 }
  }'
```

---

## Roadmap DevOps *(en cours)*

- [ok]  Dockerisation: `Dockerfile` + `docker-compose.yml`
- [ok]  Pipeline CI/CD: GitHub Actions et jenkins (build → test → image Docker)
- [ ]  Déploiement Kubernetes/openshift: `deployment.yaml` + `service.yaml`
- [ ]  Déploiement Cloud: AWS EC2 / ECS

---

## Auteur

Projet développé dans le cadre du cursus **Licence 3 GLSI** ESP / UCAD Dakar.