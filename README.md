# TP Design Patterns

Ce projet est un travail pratique visant à comprendre et implémenter quatre design patterns fondamentaux en Java. Chaque pattern est illustré par un exemple concret et fonctionnel.

## 📋 Table des matières

1. [Adapter Pattern](#1-adapter-pattern)
2. [Decorator Pattern](#2-decorator-pattern)
3. [Observer Pattern](#3-observer-pattern)
4. [Strategy Pattern](#4-strategy-pattern)
5. [Compilation et exécution](#compilation-et-exécution)

---

## 1. Adapter Pattern

### 🎯 Concept

Le pattern **Adapter** permet de faire collaborer des classes qui ne peuvent pas le faire normalement à cause d'interfaces incompatibles. Il agit comme un pont entre deux interfaces incompatibles, permettant à une classe d'utiliser une autre classe qu'elle ne pourrait pas utiliser directement.

### 📐 Structure

- **Target (Cible)** : `Mp3Player` - L'interface attendue par le client
- **Adaptee (Adapté)** : `Mp4Player` - L'interface existante qui doit être adaptée
- **Adapter** : `Mp4toMp3Converter` - La classe qui adapte l'interface `Mp4Player` à `Mp3Player`
- **Client** : `Ipod` - La classe qui utilise l'interface cible

### 💡 Exemple dans le projet

Dans cet exemple, un `Ipod` ne peut lire que des fichiers MP3 via l'interface `Mp3Player`. Cependant, nous voulons également pouvoir lire des fichiers MP4. Le `Mp4toMp3Converter` adapte un `Mp4Player` pour qu'il fonctionne comme un `Mp3Player`.

**Classes principales :**
- `Ipod` : Le client qui utilise `Mp3Player`
- `Mp3Player` : Interface cible pour la lecture audio
- `Mp4Player` : Interface existante pour la lecture vidéo
- `Mp4toMp3Converter` : L'adaptateur qui convertit les appels MP3 en appels MP4
- `Audio` : Implémentation concrète de `Mp3Player`
- `Video` : Implémentation concrète de `Mp4Player`

**Utilisation :**
```java
Ipod ipod = new Ipod();
// Utilisation directe avec MP3
ipod.setMp3Player(new Audio());
ipod.playMedia("chabMami.MP3");

// Utilisation avec adaptateur pour MP4
Mp4toMp3Converter converter = new Mp4toMp3Converter();
converter.setMp4Player(new Video());
ipod.setMp3Player(converter);
ipod.playMedia("BeatIt-MichelJackson.MP4");
```

### ✅ Avantages

- Permet la réutilisation de code existant
- Respecte le principe d'ouverture/fermeture
- Facilite l'intégration de bibliothèques tierces

---

## 2. Decorator Pattern

### 🎯 Concept

Le pattern **Decorator** permet d'ajouter dynamiquement de nouvelles fonctionnalités à un objet sans modifier sa structure. Il utilise la composition plutôt que l'héritage pour étendre les fonctionnalités, offrant ainsi plus de flexibilité.

### 📐 Structure

- **Component** : `Panachi` - L'interface ou classe abstraite de base
- **ConcreteComponent** : `PanachiLimoun`, `PanachiHlib` - Les implémentations concrètes de base
- **Decorator** : `Decorator` - La classe abstraite qui maintient une référence au composant
- **ConcreteDecorator** : `Fraise`, `Khoukh`, `Banane` - Les décorateurs concrets qui ajoutent des fonctionnalités

### 💡 Exemple dans le projet

Dans cet exemple, un `Panachi` (boisson) de base peut être décoré avec différents ingrédients (Fraise, Khoukh, Banane). Chaque décorateur ajoute son coût et sa description au composant de base.

**Classes principales :**
- `Panachi` : Classe abstraite de base avec `description` et méthode `cout()`
- `PanachiLimoun` : Panachi de base au citron (coût : 15.0)
- `Decorator` : Classe abstraite décorateur
- `Fraise`, `Khoukh`, `Banane` : Décorateurs concrets qui ajoutent chacun 5.0 au coût

**Utilisation :**
```java
Panachi panachi = new PanachiLimoun();  // Coût : 15.0
panachi = new Fraise(panachi);          // Coût : 20.0 (15 + 5)
panachi = new Khoukh(panachi);          // Coût : 25.0 (20 + 5)
panachi = new Banane(panachi);          // Coût : 30.0 (25 + 5)
```

### ✅ Avantages

- Permet d'ajouter des fonctionnalités de manière flexible
- Évite l'explosion de classes (pas besoin de créer PanachiFraiseKhoukhBanane, etc.)
- Respecte le principe de responsabilité unique
- Permet de combiner les décorateurs de manière dynamique

---

## 3. Observer Pattern

### 🎯 Concept

Le pattern **Observer** définit une dépendance un-à-plusieurs entre objets, de sorte que lorsqu'un objet change d'état, tous ses observateurs en sont notifiés et mis à jour automatiquement. C'est un pattern comportemental qui facilite la communication entre objets.

### 📐 Structure

- **Subject/Observable** : Interface qui définit les méthodes pour gérer les observateurs
- **ConcreteSubject** : Implémentation concrète qui maintient l'état et notifie les observateurs
- **Observer** : Interface pour les objets qui doivent être notifiés
- **ConcreteObserver** : Implémentations concrètes des observateurs

### 💡 Exemple dans le projet

Le projet implémente deux variantes du pattern Observer :

#### Variante Push
Dans la variante **Push**, l'objet observable envoie directement les données (l'état) aux observateurs lors de la notification.

**Classes principales :**
- `ObservablePush` : Interface définissant `addObserver()`, `removeObserver()`, `notifyObservers()`
- `ObservableImplPush` : Implémentation concrète qui maintient une liste d'observateurs
- `ObserverPush` : Interface avec méthode `updatePush(int state)`
- `ObserverPushImpl1`, `ObserverPushImpl2`, `ObserverPushImpl3` : Implémentations concrètes

**Utilisation :**
```java
ObservableImplPush observable = new ObservableImplPush();
observable.addObserver(new ObserverPushImpl1());
observable.addObserver(new ObserverPushImpl2());
observable.setState(3);  // Tous les observateurs sont notifiés avec la valeur 3
```

#### Variante Pull
Dans la variante **Pull**, les observateurs récupèrent eux-mêmes les données de l'observable après avoir été notifiés.

**Classes principales :**
- `ObservablePull` : Interface similaire à Push
- `ObservableImplPull` : Implémentation avec méthode `getState()`
- `ObserverPull` : Interface avec méthode `updatePull(ObservablePull o)`
- `ObserverPullImpl1` : Implémentation concrète

**Utilisation :**
```java
ObservableImplPull observable = new ObservableImplPull();
observable.addObserver(new ObserverPullImpl1());
observable.setState(10);  // Les observateurs récupèrent l'état via getState()
```

### ✅ Avantages

- Découplage entre le sujet et les observateurs
- Permet d'ajouter/supprimer des observateurs dynamiquement
- Respecte le principe d'ouverture/fermeture
- Facilite la communication entre composants

---

## 4. Strategy Pattern

### 🎯 Concept

Le pattern **Strategy** définit une famille d'algorithmes, les encapsule et les rend interchangeables. Il permet de sélectionner un algorithme à l'exécution selon les besoins, plutôt qu'à la compilation.

### 📐 Structure

- **Strategy** : Interface commune pour toutes les stratégies
- **ConcreteStrategy** : Implémentations concrètes des différentes stratégies
- **Context** : Classe qui utilise une stratégie et peut la changer à l'exécution

### 💡 Exemple dans le projet

Dans cet exemple, un `Context` peut utiliser différentes stratégies (`StrategyImp1`, `StrategyImp2`, `StrategyImp3`, `StrategyImpD`) et changer de stratégie dynamiquement selon l'input de l'utilisateur.

**Classes principales :**
- `Strategy` : Interface avec méthode `operationStrategy()`
- `StrategyImp1`, `StrategyImp2`, `StrategyImp3`, `StrategyImpD` : Implémentations concrètes
- `Context` : Classe qui maintient une référence à une stratégie et exécute `effectuerOperation()`

**Utilisation :**
```java
Context context = new Context();
// L'utilisateur choisit une stratégie (1, 2, 3, ou D)
Strategy strategy = Class.forName("org.example.StrategyImp" + choix).newInstance();
context.setStrategy(strategy);
context.effectuerOperation();
```

### ✅ Avantages

- Permet de changer d'algorithme à l'exécution
- Évite les structures conditionnelles complexes (if/switch)
- Facilite l'ajout de nouvelles stratégies
- Respecte le principe d'ouverture/fermeture
- Chaque stratégie peut être testée indépendamment

---

## Compilation et exécution

### Prérequis

- Java 21 ou supérieur
- Maven (pour la gestion des dépendances)

### Compilation

```bash
mvn compile
```

### Exécution

Chaque pattern peut être exécuté indépendamment via sa classe `Main` :

#### Adapter Pattern
```bash
mvn exec:java -Dexec.mainClass="org.example.adapter.Main"
```

#### Decorator Pattern
```bash
mvn exec:java -Dexec.mainClass="org.example.decorator.Main"
```

#### Observer Pattern
```bash
mvn exec:java -Dexec.mainClass="org.example.observer.Main"
```

#### Strategy Pattern
```bash
mvn exec:java -Dexec.mainClass="org.example.strategy.Main"
```

### Structure du projet

```
src/main/java/org/example/
├── adapter/          # Pattern Adapter
├── decorator/        # Pattern Decorator
├── observer/         # Pattern Observer (Push et Pull)
└── strategy/         # Pattern Strategy
```

---

## 📚 Ressources

Pour approfondir votre compréhension des design patterns, consultez :
- **Design Patterns: Elements of Reusable Object-Oriented Software** (Gang of Four)
- **Head First Design Patterns** (O'Reilly)

---

## 👨‍💻 Auteur

Travail pratique réalisé dans le cadre du cours de Design Patterns.

