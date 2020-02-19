# Von Null zu FizzBuzz – Clojure Einführungsprojekt

Dieses Projekt richtet sich an Clojure-Einsteiger und soll einige Grundlagen
bieten, um einen Einblick in diese Programmiersprache zu bekommen.  

## Voraussetzungen

Es sollte [Leiningen](https://leiningen.org/) (ein Clojure Build-Tool)
installiert sein.

Eine IDE deiner Wahl (IntelliJ + Cursive, Emacs + CIDER, VS Code, ...) kannst du
auch verwenden, ist aber nicht zwingend notwendig.

Außerdem brauchen wir ein halbwegs aktuelles JDK.

## Verwendung

Die Projektbeschreibung befindet sich
[src/einsteiger/core.clj](src/einsteiger/core.clj). Richte deine IDE vorher ein,
wenn du eine eigene verwenden möchtest. Alternativ starte die Web-IDE (siehe
weiter unten).

### Eigene IDE

Das Projekt kann in einer IDE deiner Wahl importiert werden. Die Konfiguration
für IntelliJ + Cursive ist mit eingecheckt. Denke dran unten rechts im Editor
noch "Paredit" zu "Parinfer" zu ändern, da es einen leichteren Einstieg gibt.
Parinfer ordnet deine Klammern dann gemäß der Einrückung wohingegen Paredit
explizite Befehle erwartet, um eine Klammer zu verschieben.

In jedem Fall solltest du prüfen, dass deine IDE ein entsprechendes Clojure
Plugin liefert, damit direkt aus dem Editor heraus mit der REPL interagiert
werden kann. Parinfer gibt es auch für die meisten IDEs. Sollte dir das gerade
zu viel sein, kannst du unten die Web-IDE verwenden.

### Web-IDE

Solltest du keine IDE mit Clojure-Support eingerichtet haben, so kann auch
die integrierte Web-IDE verwendet werden. Navigiere mit dem Terminal in das
Root-Verzeichnis dieses Projekts und führe folgenden Befehl aus:
 
    lein nightlight
    
Das startet eine Web-IDE, die unter http://localhost:4000 aufgerufen werden
kann.

Der Code befindet sich in `src/einsteiger/core.clj`.

### Beispieleinstellungen der IDE

Am heutigen Abend verwende ich folgende IDE, Plugins und Einstellungen:

* [IntelliJ](https://www.jetbrains.com/de-de/idea/download/) mit [Cursive](https://cursive-ide.com/)
* "[Parinfer](https://cursive-ide.com/userguide/paredit.html)" zur Verwaltung der Klammern (unten rechts einstellbar in einem Clojure-Projekt, standard ist "Paredit")
* Farbige Klammern mit "Rainbow Parenthesis" (Einstellungen -> Languages & Framework -> Clojure)
* [Leiningen](https://leiningen.org/) (`brew install leiningen`)
* JDK 13

#### Keybindings

Damit man schnell Code in die REPL schieben kann, kann ich nur empfehlen
folgende Key Bindings nach Belieben einzurichten. Ich habe mal dahinter
geschrieben, welche Tastenkombi ich so für meine Bindings verwende:

* Load File in REPL (<kbd>Control</kbd><kbd>c</kbd>, <kbd>Control</kbd><kbd>k</kbd>)
* Send Form Before Caret to REPL (<kbd>Control</kbd><kbd>c</kbd>, <kbd>Control</kbd><kbd>e</kbd>)
* Send Top Form to REPL (<kbd>Control</kbd><kbd>c</kbd>, <kbd>Control</kbd><kbd>c</kbd>)

Alle Bindings befinden sich in Einstellungen -> Keymap -> Plug-Ins -> Cursive.

#### Weitere Tools

* Clojure Linter: [clj-kondo](https://github.com/borkdude/clj-kondo) mit [IDE-Integration](https://github.com/borkdude/clj-kondo/blob/master/doc/editor-integration.md#file-watchers--installed-binary)
* [Save Actions](https://plugins.jetbrains.com/plugin/7642-save-actions), um den Code direkt beim Speichern zu formatieren

## Weitere Aufgaben

Solltest du noch mehr Aufgaben zu Clojure haben wollen, gibt es hier weitere
Links:

* [ClojureScript Koans](http://clojurescriptkoans.com/)
* [Projekte der Clojure UG Düsseldorf](https://github.com/clojuredus/clojure-coding-dojo)
* [4Clojure](http://www.4clojure.com/)