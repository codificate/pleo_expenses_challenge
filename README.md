# Pleo Expenses Challenge

[![N|Solid](https://images.sftcdn.net/images/t_app-logo-l,f_auto,dpr_auto/p/172c7ebe-4781-11e7-b2ad-bac64e508b66/1443918086/pleo-icon.png)](https://www.pleo.io/en/)

This project was created to show an expenses list fetching all expenses from the provided API. Allowing the user to add notes and upload receipt pictures to each expense.

# Features availables:
  - The list of the complete data
  - Filter expenses
  - Add comment to an expense

# Platform
  - Android

# How long did it take?
  - 8 days, 4 hours per day
# Which part was the hardest to implement?
  - Set up RN project and show native screen did takes me 1 a half day.
# What functionalities are you most proud of?
  - I proud of how I did create the native modules and how related between them they are.

### Installation

Pleo challenge requires [Node.js](https://nodejs.org/) v4+ and Java 8+ to run.

Install the dependencies and start the server.

```sh
$ cd mobile-challenge/api
$ yarn install
$ yarn start
```

Clone and move to RN project .

```sh
$ git clone https://github.com/codificate/pleo_expenses_challenges.git
$ cd pleo_expenses_challenges
$ yarn intall
````
Modify your ip address into root build.gradle file

```sh
$ ifconfig
apiExpensesPath = '\"http://192.168.0.117:3000/\"'
```

### Run 
```sh
$ yarn android
```

### Libraries


| Name | Version |
| ------ | ------ |
| RxJava | For multithreading tasks |
| Retrofit | For create network calls |
| Gson | For serialization and deserialization of json objects on requests and responses |
| Navigation | To navigate throught multiplie screens using a graph of relationships |
| Ktx | For bind elements on layout more easiest |