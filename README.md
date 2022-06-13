# OOP Project
The subject of this project is a human genotype and gene mixing. Every person has unique features like hair color or skin tone. Simulation creates specified number of random people and matches them. During epoch couple that meet requirements can give birth to a new person with combined features of its parents. <br/>
To run simulation download files from Releases and enter: <br/>
```bash
java -jar ProjektPO-x.x.jar
```
This will run the simulation and display number of epoch next to the number of people that are alive: <br/>
```bash
1 => 30
```
To customize your simulation create file application.json with JSON structure as below: <br/>
```json
{
  "numberOfEpoch": 150,
  "numberOfPeople": 30,
  "fileOutputEnabled": true,
  "outputFile": "output.json",
  "percentageOfDeath": 50,
  "percentageOfMatch": 20,
  "percentageOfGeneDegradation": 80,
  "percentageOfPregnancy": 30
}
```
