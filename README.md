# KET bedrijven applicatie

## Beschrijving

Dit project is een Java-consoleapplicatie voor KET, een Engelse technologieschool in Brussel.

De applicatie helpt om bedrijven bij te houden die interessant zijn voor stages, gastlessen, jobbeurzen of sponsoring.

De gebruiker kiest eerst een rol:

- Student
- Docent
- Administratief personeel

Afhankelijk van de rol krijgt de gebruiker andere mogelijkheden in het menu.

## Functionaliteiten

### Student

Een student kan:

- bedrijven zoeken
- zoekresultaten opslaan in een tekstbestand
- de applicatie afsluiten

### Docent

Een docent kan:

- bedrijven zoeken
- zoekresultaten opslaan in een tekstbestand
- de applicatie afsluiten

### Administratief personeel

Administratief personeel kan:

- bedrijven zoeken
- zoekresultaten opslaan in een tekstbestand
- een bedrijf toevoegen
- een bedrijf verwijderen
- een bedrijf aanpassen
- de applicatie afsluiten

## Structuur van het project

Het project is opgedeeld in duidelijke packages:

- applicatie
- dienst
- hulpmiddel
- model

### applicatie

In deze package staat de klasse `Main`.

Deze klasse start de applicatie, laat de gebruiker een rol kiezen en toont het menu.

### dienst

In deze package staat de klasse `BedrijfDienst`.

Deze klasse beheert de lijst met bedrijven. Hier kan men bedrijven zoeken, toevoegen, verwijderen en op naam terugvinden.

### hulpmiddel

In deze package staat de klasse `BestandSchrijver`.

Deze klasse schrijft de zoekresultaten naar een tekstbestand.

### model

In deze package staan de modelklassen:

- `Bedrijf`
- `Gebruiker`
- `Student`
- `Docent`
- `AdministratiefPersoneel`
- `GebruikersRol`

## Gebruikte leerstof

In dit project gebruik ik leerstof uit Programming Advanced:

- classes en objecten
- constructors
- private fields
- getters en setters
- overerving met `extends`
- abstracte klasse
- enum
- ArrayList
- for-loop
- if/else
- switch/case
- Scanner voor input
- FileWriter
- try/catch
- JavaDoc

## Testdata

De applicatie bevat drie testbedrijven:

- TechBrussels
- CyberSafe
- DesignLab

Deze bedrijven worden automatisch toegevoegd wanneer de applicatie start.

## Opslaan naar tekstbestand

De gebruiker kan de laatste zoekresultaten opslaan in een tekstbestand.

Het bestand heet `zoekresultaten.txt`.

Hiervoor gebruik ik `FileWriter` in de klasse `BestandSchrijver`.

## Planning / user stories

### User story 1

Als gebruiker wil ik mijn rol kunnen kiezen, zodat ik de juiste opties in het menu krijg.

Status: afgewerkt

### User story 2

Als student wil ik bedrijven kunnen zoeken, zodat ik stagebedrijven kan vinden.

Status: afgewerkt

### User story 3

Als docent wil ik bedrijven kunnen zoeken, zodat ik bedrijven voor stages of gastlessen kan vinden.

Status: afgewerkt

### User story 4

Als gebruiker wil ik zoekresultaten kunnen opslaan in een tekstbestand, zodat ik de resultaten later kan bekijken.

Status: afgewerkt

### User story 5

Als administratief personeel wil ik een bedrijf kunnen toevoegen, zodat nieuwe bedrijven in de lijst komen.

Status: afgewerkt

### User story 6

Als administratief personeel wil ik een bedrijf kunnen verwijderen, zodat oude of foutieve bedrijven uit de lijst verdwijnen.

Status: afgewerkt

### User story 7

Als administratief personeel wil ik een bedrijf kunnen aanpassen, zodat bedrijfsgegevens verbeterd kunnen worden.

Status: afgewerkt

## Testen

Ik heb de applicatie getest als:

- Student
- Docent
- Administratief personeel

Geteste functies:

- rol kiezen
- bedrijven zoeken
- zoekresultaten opslaan naar een tekstbestand
- bedrijf toevoegen
- bedrijf verwijderen
- bedrijf aanpassen
- afsluiten

De applicatie werkt zonder crashes.

## Bronnen

Voor dit project heb ik volgende bronnen gebruikt:

- De opdracht van Programming Advanced op Canvas
- Eigen cursusmateriaal van Programming Advanced
- ChatGPT als ondersteuning om fouten te begrijpen, code stap per stap uit te leggen en documentatie duidelijker te formuleren

Ik heb de code zelf getest en ik begrijp de werking van de gebruikte onderdelen.

## AI-gebruik

Ik heb ChatGPT gebruikt als hulpmiddel bij het begrijpen van fouten, het structureren van mijn code en het formuleren van JavaDoc en README.

De code werd stap per stap opgebouwd, getest en nagekeken.