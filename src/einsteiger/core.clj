(ns einsteiger.core
  (:require [clojure.repl :refer [doc]]))

;; Willkommen in deiner ersten REPL Session mit Clojure!

;; Sorge dafür, dass deine IDE korrekt eingestellt ist, sodass du eine REPL
;; starten kannst und so Unterstützung von der IDE erhälst.

;; Für den Einstieg in Clojure eignet sich folgendes OpenBook:
;; https://www.braveclojure.com/
;; Wobei man nicht (mehr) unbedingt Emacs verwenden muss. Es gibt tolle
;; Clojure Plugins für alle möglichen Editoren / IDEs.





;; TODO: Wenn IntelliJ mit Cursive verwendet wird...
;; Wenn IntelliJ mit Cursive verwendet wird, dann stellt bitte sicher, dass
;; unten rechts "Paredit" zu "Parinfer" geändert wird. Dann habt ihr den selben
;; Modus wie in der Einleitung.
;; Eine Startkonfiguration ist schon im Repository hinterlegt. Du kannst die
;; Run-Configuration "Start" verwenden und erhälst sofort eine REPL.


;; TODO Wenn die Web-IDE "Nightlight" verwendet wird...
;; Dann ist das meiste schon eingestellt. Aktiviere noch InstaREPL und passe bei
;; unendlichen Datenstrukturen auf.










;; -----------------------------------------------------------------------------
;; 1. Aufgabe
;;
;; In einem Lisp, wie Clojure, wird die Präfix-Notation verwendet. Außerdem
;; wird ein Funktionsaufruf mit einer öffnenden Klammer begonnen. Ein
;; Funktionsaufruf sieht daher wie folgt aus:

(+ 1 2)

;; Es wird also die Funktion `+` mit den Argumenten 1 und 2 aufgerufen:
;;
;; (funktion operand1 operand2 ... operandn)
;;
;; Das Ergebnis kannst du dir in der REPL anschauen, wenn du den Ausdruck
;; evaluierst.

;; Funktionen können beliebig verschachtelt werden. Versuche nun zunächst das
;; Produkt der Zahlen 2 und 3 zu bilden und auf das Ergebnis 1 zu addieren.









;; -----------------------------------------------------------------------------
;; 2. Aufgabe
;;
;; In Clojure gibt es den Spruch: "There is a Function for it"
;;
;; Um eine Zahl zu inkrementieren, gibt es die Funktion `inc`. Es lohnt sich
;; zu schauen, ob es nicht schon eine eingebaute Funktion gibt. Erfreulich
;; häufig wird man eine finden.

;; Schreibe nun den letzten Teil des Code aus Aufgabe 1 um, indem du `inc` statt `+` verwendest.









;; -----------------------------------------------------------------------------
;; 3. Aufgabe
;;
;; Das Ergebnis von Evaluationen möchten wir gerne speichern. Dafür verwenden
;; wir `def`. Mit `def` können wir Symbolen einen Wert zuweisen. Das kann
;; dann so aussehen:

(def x 42)

;; Dabei behält `x` immer den Wert 42, da wir hier keine Variablen haben, die
;; veränderlich sind. Das zeigt sich an folgendem Beispiel, wenn wir den Code
;; in der REPL ausführen:

(inc x)
;; => 43
x
;; => 42

;; Der Wert von `x` hat sich also nicht verändert. `def` speichert den Wert
;; außerdem global ab, sodass alle Funktionen darauf zugreifen können.
;; Möchten wir den Scope begrenzen, so verwenden wir ein `let`. Die
;; Zuweisungen leben nur innerhalb der definierten Closure:

(let [y 43]
  (dec y))
;; => 42

;; Würden wir nun auf `y` zugreifen außerhalb des lets, so erhalten wir:
;; Unable to resolve symbol: y in this context

;; Speichere nun das Ergebnis der vorherigen Aufgabe in einem Symbol ab.











;; -----------------------------------------------------------------------------
;; 4. Aufgabe
;;
;; Wir schauen uns nun ein paar Kontrollstrukturen an. Beginnen wir mit dem
;; `if`. Ein if nimmt drei Argumente entgegen. Das erste muss zu truthy oder
;; falsy evaluieren. Das Zweite ist der "then" Fall, zuletzt kommt der "else"
;; Fall. Wenn es kein "else" gibt, kann statt dem `if` auch ein `when`
;; verwendet werden.

;; Beispiel:

(if true
  "Welcome to Coding Students Düsseldorf!"
  "I am groot")
;; => "Welcome to Coding Students Düsseldorf!")

(if false
  "Welcome to Coding Students Düsseldorf!"
  "I am groot")
;; => "I am groot"


;; Experimentiere nun ein wenig mit `if` herum. Finde heraus, welche Wert
;; truthy sind, wie sich `if` verhält, wenn du verschiedene Werte einsetzt.

;; Was passiert, wenn man `if` durch `when` ersetzt? Nimm die beiden
;; Codebeispiele oben und ersetze `if` durch `when`.











;; -----------------------------------------------------------------------------
;; 5. Aufgabe
;;
;; Clojure kennt `true` und `false`. Außerdem wird `nil` verwendet um "no
;; value" anzugeben. Was zu nil und false evaluiert, wird als falsey bezeichnet.
;; Die Funktion `nil?` nimmt ein Argument entgegen und prüft, ob ein Wert
;; falsey ist.
;; Funktionen, die mit einem Fragezeichen enden, liefern per Konvention einen
;; Boolean, also true oder false zurück.

;; Schaue dir diese Beispiele an. Was sind die Rückgabewerte der folgenden
;; Ausdrücke? Denke zuerst nach und nutze dann die REPL zur Verifizierung:

(nil? 1)

(nil? nil)

(nil? [])

(nil? "Foo")

(nil? "")







;; -----------------------------------------------------------------------------
;; 6. Aufgabe
;;
;; Funktionen können auf verschiedene Arten angelegt werden. Die kürzeren
;; Varianten sind nur zu empfehlen, wenn man wirklich nur eine ganz kleine
;; Sache erledigen möchte. Ansonsten verliert man die Übersicht.
;;
;; Hier ein Beispiel mit der Square-Funktion, die Zahlen quadrieren soll:

(fn [n]
  (* n n))

;; Diese anonyme Funktion hat offensichtlich keinen Namen. Wir können diese
;; Funktion aber einem Symbol zuweisen:

(def square1
  (fn [n]
    (* n n)))

;; Da das häufiger vorkommt, gibt es eine Kurzform dazu:

(defn square2 [n]
  (* n n))

;; Hier haben wir das Makro `defn`, welches einen Funktionsnamen, einen
;; Argumentvektor und dann den Funktionskörper entgegennimmt. Der letzte
;; Ausdruck innerhalb einer Funktion ist der Rückgabewert, hier also das
;; Ergebnis von `(* n n)`.
;;
;; Im Argumentvektor steht gerade nur ein `[n]`. Dort können aber auch mehr
;; Argumente übergeben werden, beispielsweise `[n m]` etc.
;;
;; Es gibt auch noch eine Kurzform dazu:

(def square3 #(* % %))

;; Hier ist `%` der Wert, der in die Funktion gegeben wird. Für den Moment
;; genügt uns das hier.

;; Die drei Varianten liefern die gleichen Ergebnisse:

(let [n 4]
  (= (square1 n)
     (square2 n)
     (square3 n)))

;; Schreibe nun eine Funktion, die ein paar arithmetische Operationen
;; ausführt. Probiere auch die verschiedenen Schreibweisen aus.





;; Was ist die Ausgabe des folgenden Ausdrucks?

(defn multiply-and-increment [n m]
  (inc n)
  (inc (* n m)))

(multiply-and-increment 2 3)

;; Warum ist das Ergebnis 7 und warum sehen wir keine Ausgabe / keinen
;; Einfluss von `(inc n)`?








;; -----------------------------------------------------------------------------
;; 7. Aufgabe
;;
;; In Clojure verwenden wir häufig Vektoren oder Listen als Datenstrukturen.
;; Eine Beispielstruktur sieht wie folgt aus:

(def mycol [1 2 3])

;; In `mycol` haben wir nun einen Vektor gespeichert, der die oben
;; angezeigten Daten beinhaltet.
;;
;; Es gibt einige Komfortfunktionen, mit denen wir auf die Elemente zugreifen
;; können. Wenn wir beispielsweise auf das erste Element in einer
;; Datensammlung zugreifen wollen, bietet sich die Funktion `first` an:

(first mycol)

;; Experimentiere mit den folgenden Funktionen herum:

ffirst
second
last
nth

;; Du kannst die Dokumentation der Funktionen auch auf der REPL anzeigen
;; lassen mit folgender Funktion:

(doc nth)

;; Das klappt eventuell nicht in einer Web-IDE. Du kannst aber auch im
;; Browser danach suchen:
;; https://clojuredocs.org/clojure.core/nth










;; -----------------------------------------------------------------------------
;; 8. Aufgabe
;;
;; In Clojure denken wir in ganzen Datenstrukturen und nicht iterativ in
;; Schleifen. Wir definieren uns Funktionen, die unsere Daten so
;; transformieren, wie wir sie gerade benötigen. Diese Funktionen wenden wir
;; dann auf jedes Element in unseren Datensammlungen an.
;;
;; Wie man Funktionen definiert haben wir schon gesehen. Nun schauen wir uns
;; `map` an, welche es erlaubt eine Funktion auf jedes Element einer
;; Collection anzuwenden. `map` nimmt eine Funktion und eine oder mehrere
;; Colections und wendet die Funktion auf jedes Element an.
;;
;; Möchten wir beispielsweise eine Sammlung von Zahlen quadrieren, sieht das
;; wie folgt aus:

(def sample [1 2 3 4 5])

(map square1 sample)

;; Hier eignet sich auch die Kurzschreibweise für Funktionen, die wir nur in
;; diesem Kontext verwenden möchten:

(map (fn [n] (* n n)) sample)

;; oder noch kürzer:

(map #(* % %) [1 2 3 4 5])

;; Das funktioniert auch mit eingebauten Funktionen:

(map inc sample)

;; Experimentiere nun ein wenig mit `map` herum.












;; -----------------------------------------------------------------------------
;; 9. Aufgabe
;;
;; Unendliche Datenstrukturen sind in Clojure möglich. Wir können
;; Vorschriften definieren, sodass wir beliebig viele Werte in unserer
;; Datensammlung haben. Diese Daten werden nur dann ausgewertet, wenn sie
;; wirklich benötigt werden (sie sind also lazy).
;;
;; Die einfachste Variante einer unendlichen Datenstruktur ist die folgende:

(range 5)

;; Dieser Aufruf generiert uns eine Liste von Werten von 0 bis (exklusive) die
;; übergebene Zahl.
;;
;; `range` nimmt auch einen Startwert entgegen:

(range 1 10)

;; Startet bei 1, endet bei 9.

;; Nutzt man range ohne Parameter, erhält man eine unendliche Liste von
;; Zahlen, beginnend bei 0. Gibt man beispielsweise den Aufruf (range) in die
;; REPL ein, wird versucht unendlich viele Zahlen auf der Konsole auszugeben.
;; Das ist natürlich nicht sinnvoll, weshalb wir die maximal ausgegebenen
;; Zahlen auf der Konsole mit folgendem Befehl beschränken können:

;; (set! *print-length* 20)

;; Das haben wir pauschal in dem Projekt so eingestellt, damit es zu keinen
;; Komplikationen beim Spielen gibt.

;; Nun sehen wir nur noch 20 Zahlen, wenn wir die lange Datenstrukturen
;; ausgeben:

;; (range)

;; `map` ist auch lazy, weshalb das Ergebnis erst dann ausgewertet wird, wenn
;; es benötigt wird (beispielsweise beim printen).

(def natürliche-zahlen
  (map inc (range)))

;; Mit `take` können wir dann beispielsweise eine gewisse Anzahl von
;; Elementen aus der Datensammlung herausholen:

(take 10 natürliche-zahlen)

;; Experimentiere nun ein wenig mit range und map herum. Achte darauf, dass
;; eine Auswertung einer unendlichen Datenstruktur deinen Editor eventuell
;; zum Abstürzen bringen könnte.









;; -----------------------------------------------------------------------------
;; 10. Aufgabe
;;
;; 9 Aufgaben geschafft -- fast durch mit diesem Tutorial. Nun gut:
;;
;;     Wir möchten ein Spiel mit euch spielen 😈
;;
;; Wir haben nun alles gesehen, um FizzBuzz zu implementieren. Bei FizzBuzz
;; nehmen wir eine Reihe von natürlichen Zahlen. Jede Zahl, die glatt durch 3
;; teilbar ist, wird dann durch ein "FIZZ" ersetzt. Wenn sie glatt durch 4
;; teilbar ist, soll "BUZZ" erscheinen. Gelten beide Regeln, soll "FIZZBUZZ"
;; zurückgegeben werden. Tritt nichts davon ein, soll die Eingabezahl
;; zurückgegeben werden.
;;
;; Beispiel: n = 13, beginnend ab 1. Ein Aufruf von `(fizzbuzz 13)`
;; soll dann folgenden Output liefern:

'(1 2 "FIZZ" "BUZZ" 5 "FIZZ" 7 "BUZZ" "FIZZ" 10 11 "FIZZBUZZ" 13)

;; Die Beschreibung zeigt nur grob was gefragt ist. Du kannst jederzeit davon
;; abweichen und deine eigenen (vielleicht sinnvolleren) Ideen einbringen








;; Für Fortgeschrittene:
;; Die Funktion `fizzbuzz` könnte auch _alle_ möglichen Lösungen beinhalten,
;; also lazy sein. Ein Aufruf könnte dann wie folgt aussehen:
;; `(take 13 fizzbuzz)`.









;; -----------------------------------------------------------------------------
;; Bonusaufgabe
;;
;; Neben `map` gibt es auch noch diverse andere nützliche
;; Higher-Order-Funktionen (HOF), also Funktionen, die andere Funktionena als
;; Parameter entgegennehmen.
;; Diese Funktionen des täglichen Clojureentwickelns sind beispielsweise:

filter
remove
reduce
apply

;; Benutzt die neuen HOF, um eine Liste aller geraden Zahlen zu generieren.
;; Denkt euch weitere Beispiele aus und spielt damit herum.
