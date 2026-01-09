# Projet R3-04 - Moteur d'Échecs (Finale RKK)

Ce projet implémente un moteur d'échecs capable de jouer une finale **Roi + Tour (Blancs) contre Roi (Noirs)**. Le développement respecte strictement les principes **SOLID** et la **Clean Architecture**.

## 👥 Membres de l'équipe
**Groupe TP 205-206 :**
- Tanim VEER (206)
- Alexandre GUELY (205)
- Imadeddine AKLOUF (205)
- Ethan MEBALEY KAHEL (205)

---


## 🚀 Installation et Exécution

### Prérequis
- Java 17 ou supérieur.
- Une interface graphique compatible UCI (ex: ChessX, CuteChess).

### Lancer le projet
Le projet est fourni avec un script de lancement automatique à la racine.

1. **Rendre le script exécutable** (une seule fois) :
   ```bash
   chmod +x run.sh
   
2. **Exécuter le moteur** (via le terminal pour tester) :
    ```bash 
    ./run.sh

3. **Utilisation dans ChessX** :
- Ajoutez le fichier run.sh comme moteur UCI dans les préférences. 
- Configurez une position "Setup" avec Roi Blanc, Tour Blanche et Roi Noir. 
- Lancez "Match against Engine".
---

## Elements
Entités :
- IPiece
- Square
- Board play move(Move)
- Color
- Move
- MoveGenerator

---

## 🏗️ Architecture du Projet
Le projet suit la Clean Architecture pour garantir l'indépendance des règles métier. Les dépendances vont uniquement vers l'intérieur (du plus instable vers le plus stable).

```text
run.sh

src/
├── Appli.java                       # Point d'entrée (Main)
└── chess/
    ├── adaptator/                   # Couche Adaptateur
    │   └── UCIEngine.java           # Gestion protocole UCI
    │
    ├── useCases/                    # Couche Cas d'Utilisation
    │   ├── MoveGenerator.java       # Logique de déplacement
    ├── ├── MoveGeneratorTest.java
    │   ├── IBotStrategy.java        # Interface Strategy
    │   ├── BotStrategy.java         # IA basique
    │   └── RandomStrategy.java      # IA aléatoire
    │
    └── businessLayer/               # Couche Métier (Indépendante)
        ├── IPiece.java
        ├── Move.java
        ├── Color.java
        ├── board/
        │   ├── Board.java
        │   ├── Square.java
        │   └── Position.java
        └── piece/
            ├── Piece.java
            ├── PieceType.java
            ├── King.java
            └── Rook.java
```


<img width="1919" height="858" alt="image" src="https://github.com/user-attachments/assets/d246e4ce-0317-4f21-b4d4-d17ebf440eca" />
![image](https://github.com/user-attachments/assets/1b08cd80-ea1d-4eb5-a3ab-e8c6d553011b)


## Description des couches

1. **chess.businessLayer** (Cœur du projet)
- Contient les entités pures : Board, Square, Position, Move, et les pièces (King, Rook).
- Dépendance : Aucune.

2. **chess.useCases** (Logique de jeu)
- Contient la génération des coups légaux (MoveGenerator) et les stratégies du robot (BotStrategy, RandomStrategy).
- Dépendance : Utilise businessLayer.

3. **chess.adaptator** (Communication)
- Gère le protocole UCI (UCIEngine) et le point d'entrée (Appli).
- Dépendance : Utilise useCases et businessLayer.
  
---

## 📊 État du Projet
- Génération de coups : La Tour et le Roi se déplacent correctement (pas de traversée de pièces, captures gérées).
- Protocole UCI : Le moteur communique parfaitement avec ChessX (uci, isready, position, go).
- Stratégie : Implémentation du pattern Strategy permettant de changer d'IA (Aléatoire ou Déterministe).
- Tests : 100% des tests unitaires passent. 

---

## ✅ Tests Unitaires : 11/11 validés (100%) 
**Le moteur couvre tous les cas limites :**
- Déplacements géométriques (Tour/Roi).
- Gestion des obstacles (Amis/Ennemis).

Règles avancées validées : Interdiction de suicide, gestion du clouage (Pin), et obligation de parer un échec.

--- 

## 📝 Bilan
Ce projet nous a permis de comprendre l'importance du découpage en couches. La principale difficulté a été la mise en place du protocole UCI et la gestion des inputs/outputs sans interface graphique Java. L'application stricte des principes SOLID (notamment le pattern Strategy et le Liskov pour les pièces) rend le code modulaire et facile à faire évoluer pour ajouter d'autres pièces plus tard.
