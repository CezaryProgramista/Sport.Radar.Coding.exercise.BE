# Sport.Radar.Coding.exercise.BE
English below
                                             Opis działania aplikacji
Aplikacja przyjmuje plik JSON jako input i wyświetla liczbę zespołów o największej liczbie prawdopodobieństwa wyniku.
Liczba zespołów przyjmowana jest od uzytkownika.
Input podany jest jako lista JSON o nazwie events, kazdy JSON zawiera dane eventu liste uczestników (ARRAY JSON) i JSON VENUE
W pierwszym kroku wczytuje input do stringa i z niego Liste JSON do listy obiektów EVENTS.
Z listy obiektów Events wyciągam JSON VENUE i parsuje w pętli to Listy VENUE.
W tej samej pętli parsuje liste JSON COMPETITORS do HashMapy obiektów COMPETITORS.
Metodą typingProbality typuje największy możliwy wynik z listy obiektów EVENTS i zwracam do listy.
Metoda objectAssociation pobiera Listy VENUES EVENTS i liste z poprzedniej metody.
W pętli:
Przyrównuje wynik Listy typingProbality do pola klas EVENT uzyskując qualifier
Pobieram date z Listy Obiektów EVENTS.
Pobieram z listy VENUES nazwę stadionu.
Pobieram z hashMapy nazwy zespołów  i narodowości.
Tworze obiekt OUTPUTWINNERS który wrzucam do listy.
Metodą displayWinners wyswietlam posortowaną liste, metoda pobiera argument kóry definiuje ilość wyświetlanych obiektów.
Argument pobieram od uzytownika z konsoli.
Informuje uzytkownika o zakresach wprowadzanego argumentu tj. od 0 do rozmiaru Listy EVENTS.
Metodą uniqueListOfCompetitors zwracam posortowane wartości hashMapy COMPETITORS.

                                 Description of how the application works
The application takes a JSON file as input and displays the number of teams with the highest probability score.
The number of teams is taken from the user.
Input is given as a JSON list named events, each JSON contains event data a list of participants (ARRAY JSON) and JSON VENUE.
In the first step I load the input into a string and from it the JSON List into the EVENTS object list.
From the Events object list, I extract the JSON VENUE and parse it in a loop to the VENUE List.
In the same loop I parse the JSON COMPETITORS list into a COMPETITORS object HashMap.
The typingProbality method types the largest possible result from the EVENTS object list and returns it to the list.
The objectAssociation method takes the VENUES EVENTS list and the list from the previous method.
In the loop:
I equate the result of the typingProbality List to the EVENT class field getting the qualifier.
I retrieve the date from the EVENTS list of objects.
I retrieve the name of the stadium from the VENUES list.
I retrieve the team names and nationalities from the hashMap.
I create an OUTPUTWINNERS object which I insert into the list.
Using the displayWinners method, I display the sorted list, the method takes an argument which defines the number of displayed objects.
The argument is taken from the user from the console.
It informs the user about the range of the input argument, i.e. from 0 to the size of the EVENTS list.
Using the uniqueListOfCompetitors method, I return the sorted values of the COMPETITORS hashMap
