#!/bin/bash

# Cette ligne force le terminal à se mettre dans le dossier du projet
cd "$(dirname "$0")"

# Tentative 1 : Si Appli est dans le package chess
java -cp out/production/Jeu_d-echec_205-206 chess.Appli 2>/dev/null

# Tentative 2 : Si Appli est à la racine (src)
if [ $? -ne 0 ]; then
    java -cp out/production/Jeu_d-echec_205-206 Appli
fi