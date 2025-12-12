# Qualite_dev

## Membres :
- Imadeddine AKLOUF (205)
- Alexandre GUELY (205)
- Ethan MEBALEY KAHEL (205)
- Tanim VEER (206)

## Elements
Entités :
- IPiece
- Square
- Board play move(Move)
- Color
- Move
- MoveGenerator

## 📁 Structure du projet

```text
src/
├── app/
|   └── Appli.java
└── chess/
    ├── businessLayer/
    │   ├── IPiece.java
    │   ├── Move.java
    │   ├── Color.java
    │   ├──board/
    │   │   Board.java
    │   │   Square.java
    │   └── piece/
    │       ├── King.java
    │       └── Rook.java
    │      
    ├── useCases/
    │   └── MoveGenerator.java
    │
    └── adaptor/
        └── UCIEngine.java     # board.playMove(...)
