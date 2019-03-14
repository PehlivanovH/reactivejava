**reactor-hands-on**

	Übungen fürs API vom Spring Reactor.

	reactor-hands-on/uebung/lite-rx-api-hands-on-master: Die API-Übungen mit Unit Tests dazu.

	reactor-hands-on/loesung/lite-rx-api-hands-on-complete: Die Musterlösungen zu den Übungen.

	Erklärungen zu den Übungen kann man hier finden:
	https://www.codingame.com/playgrounds/929/reactive-programming-with-reactor-3/Intro


**webflux**

	Eine Spring WebFlux-Webanwendung, die ein reaktives API anbietet.
	Kann zum Beispiel über einen Webclient getestet werden, siehe Unit Tests.
	
	1. SpringBoot Application starten - siehe Klasse Application.
	2. Unit Tests mit WebClient ausführen.


**Aufgabe API-Master: Übungen fürs API vom Spring Reactor**

Das Projekt reactor-hands-on hat eine Menge von Klassen, deren Methoden keine Implementierung haben. Ergänzen Sie die Implementierung und überprüfen Sie diese mit den Unit Tests zu der Klasse.

 

 

 

**Aufgabe WebApp-Master: Webanwendung mit dem Spring Webflux Framework bauen**

Das Projekt Webflux hat alles, was Sie brauchen, um einen reaktiven Webservice zu bauen. Die bestehende Implementierung kann über Rest aufgerufen werden (siehe Controller-Klassen). Die Aufgabe definiert keine Einschränkungen oder Anforderungen. Erweitern Sie den Service nach Ihren Wünschen und testen Sie die Mono/Flux-Streams. Die Unit Tests haben Beispiele, wie man die Rest-Controller aufrufen kann.

 

 

 

**Aufgabe Stream-Master: Asynchrone Events mit Streams**

Ich als Vater habe keine Zeit, um einen Namen für das zukünftige 2. Kind zu finden. Deswegen will ich eine Anwendung haben, die mir Namensvorschläge aus der ganzen Welt gibt.

Nehmen Sie die Klasse StreamMaster als Basis. Die Klasse implementiert mit Java-Swing eine Liste mit 3 Einträgen und einen Refresh-Button. Es gibt auch Beispiele, wie man von einem Public API Namen abfragen kann, sowie wie man einen Publisher initialisieren kann.

Anforderungen:

* Beim Start werden 3 Vornamen in die Vorschlagsliste geladen
* Beim Click auf einem Namen, wird der Name gelöscht und einen neuen geladen. Name gefällt mir nicht.
* Beim Click auf dem Refresh-Button werden alle Namen gelöscht und 3 neue geladen
* Optional: Das Ursprungsland des Namens in Klammern zeigen.
* Alles ist ein Stream!
