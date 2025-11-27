# ⭐ **Transformée de Fourier – Version Naïve & Rapide (FFT)**
### *Projet L3 – Outils Mathématiques (2025–2026)*
**Auteurs : Axel Kramer & Arsène Cléry**

---

## 🌀 Introduction
Ce projet implémente en **Java** l’ensemble des outils nécessaires pour calculer :

- la **Transformée de Fourier Discrète (TFD)** en 1D et 2D  
- les versions **inverses** (TFD⁻¹)  
- les versions **rapides FFT** (Fast Fourier Transform) 1D et 2D  
- les versions **inverses IFFT**

Toutes les implémentations suivent les formules et explications détaillées dans le rapport fourni. :contentReference[oaicite:0]{index=0}

---

## 📘 Classe `Complexe`
La transformée de Fourier manipule des **nombres complexes**.  
Nous avons donc créé une classe dédiée contenant :

- une partie réelle  
- une partie imaginaire  
- des opérations : **addition**, **soustraction**, **multiplication**  

Cette classe constitue la base de tous les calculs FFT/TFD.

---

## 🔢 Transformée de Fourier 1D – Version naïve
La version naïve applique directement la formule mathématique à l’aide de deux boucles imbriquées.

- Complexité : **O(N²)**
- Implémentation : `TransformeeFourier1DN`
- Version inverse également fournie : `TransformeeFourier1DIN`

---

## 🖼️ Transformée de Fourier 2D – Version naïve
Extension directe du cas 1D en parcourant lignes et colonnes.

- Complexité : **O(N² M²)**
- Implémentation : `TransformeeFourier2DN`
- Version inverse : `TransformeeFourier2DIN`

---

## ⚡ FFT 1D – Version rapide
La version rapide exploite la séparation **pairs / impairs**, la récursivité et la recombinaison via des facteurs complexes.

- Complexité : **O(N log N)**
- Implémentation : `TransformeeFourier1DR`
- Version inverse : `TransformeeFourier1DIR`

---

## 🖥️ FFT 2D – Version rapide
La transformée 2D rapide utilise la **séparabilité** :

1. FFT 1D sur chaque **ligne**
2. FFT 1D sur chaque **colonne**

- Complexité : **O(NM log N log M)**
- Implémentation : `TransformeeFourier2DR`
- Version inverse : `TransformeeFourier2DIR`

---

## 📊 Résumé des complexités

| Méthode | 1D | 2D |
|--------|-----|------|
| Naïve | O(N²) | O(N²M²) |
| Rapide (FFT) | O(N log N) | O(NM log N log M) |

---

## 🛠️ Technologies
- **Java**
- Manipulation de nombres complexes
- Calcul numérique
- Traitement du signal et des images

---

## 🎯 Conclusion
Ce projet propose une implémentation complète et fidèle des versions naïves et rapides de la Transformée de Fourier en 1D et 2D.  
Il constitue une base solide pour tout traitement fréquentiel des signaux ou images en Java.

