# Stoibot
### The philosophical twitter bot, every day, a random stoic quote
### Current version: 1.0 (02/03/2022)
### Current status: Working
#### Author: https://juliancampos.es
#### Twitter account: https://twitter.com/citasestoicas
#

Stoibot is a JAVA based bot to tweet every day a quote from a stoic author. The target of the bot is create a simple mysql/mariaDB and java based system to test some libraries and the mysql driver.


## Technologies

The bot is working with JAVA, a simple relational database (MySQL), differents JAVA Maven libraries:

- JAVA SE
- MySQL/MariaDB database
- MySQL-connector library
- Twitter4j library

## How does it work?

For the bot I've created a simple MySQL/MariaDB database with 1 table and 3 rows:
- Id: primary id with autoincrement
- Quote: varchar with the text of the quote
- Author: varchar with the author name

The JAVA script works with only 2 classes:
- Main class: connection to twitter API, infinite loop to tweet everyday (it sleeps 23h and 59 minutes) and generating the string for the tweet.
- Quote class: getting the information from the database.

If you need modify the script for other pourpose, you need read the comments of the code. I'll generate javadoc and maybe I'll detail the program in this readme.md, but for the instance the comments are very simple (as the program is).

You have a file named twitter4j.properties where you should define your Twitter API Keys.

## Next Step:

Studying different functionalities to the bot.




