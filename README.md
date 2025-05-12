# SuperDuperApplication

Hallo !

Anbei paar kurze Infos über dieses Projekt.

Ich habe zuerst auf einem anderen Repository gearbeitet. Beim erstellen der Module habe ich dann gemerkt, das diese nicht richtig auf das andere Repo hochgeladen wurde.
Also habe ich kurzerhand ein neues Repo erstell, diueses hier, und alle Sachen hochgeladen. 
Das alte wäre falls Interesse besteht hier zu finden (https://github.com/M4slenits4/SuperDuperMarkt).

Vielleicht müssen die einzelnen Module noch seperat hinzugefügt/geladen werden.
Zumindest war das bei mir in IntelliJ so, da er sonst nicht erkannte das es ein Maven-Projekt ist.


Zu dem Produkt-Modul:

Ich habe schon vor dem "neuen" Produktmodul die Produkte in ein eigenes Ausgelagert.
Aus diesem Grund habe ich für dieses kein eigenes mehr erstellt, sondern den neuen Produttyp namens "Sausage" dort hinzugefügt.

Verarbeitungsregeln von diesem sind wie folgt:
- Es besitzt wie der Käse und der Wein einen fixen Grundpreis
- Die Qualität darf nicht negativ sein
- Es gibt einen Tipping Point, dieser beträgt 60. Wenn die Qualität größer als 60 ist, verliert es täglich nur einen Qualitätspunkt. Andernfalls 4;
- Für die Qualität über den Tipping Point wird der der Preis mit einem GOOD_PRICE_FACTOR berechnet (= GOOD_PRICE_FACTOR = 60), Sonst mit einem BAD_PRICE_FACTOR ( =BAD_PRICE_FACTOR = 10)
- Verfallsdatum muss vor dem heutigen sein


Design Patterns:

Template Method durch die abstrakte Produkt-Klasse: 
Hat sich meiner Meinung nach am besten angeboten, da die Klassen Cheese, Wine und Sausage gemeinsamkeiten haben und gemeinsame Methoden Teile, welche sich aber auch durchaus ändern.

Data Transfer Object(DTO):
Die Product-Entity transportiert daten zwischen der DB und der Service-Schicht. Meiner Meinung nach hat es sich angeboten, da man speziefische Informationen heran ziehen kann ohne z.B. immer alle Informationen auf einmal zu Laden.


Bis auf den letzen Punkt habe ich alles erledigt. 
Ich bin mit Spring noch nicht so bewandert, aber möchte das in Zukunft definitiv ändern.





  





























