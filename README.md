# Stoibot
### The philosophical twitter bot, every day, a random stoic quote
### Current version: 0.8 
### Current status: Waiting to elevated access to the API Twitter to test the system
#### Author: https://juliancampos.es
#### Twitter account: https://twitter.com/citasestoicas
#

Stoibot is a JAVA based bot to tweet every day a quote from a stoic author. The target of the bot is create a simple mysql and java based system to test some libraries and the mysql driver.

The system is not finished yet. We need the elevated access to the API Twitter to post the quote, so I can't test the API yet and I don't know if it works properly. I'm still waiting...

## Technologies

The bot is working with JAVA, a simple relational database (MySQL), differents JAVA Maven libraries:

- JAVA SE
- MySQL database
- MySQL-connector library
- Twitter4j library

## How does it work?

For the bot I've created a simple MySQL database with 1 table and 3 rows:
- Id: primary id with autoincrement
- Quote: varchar with the text of the quote
- Author: varchar with the author name

The JAVA script works with only 2 classes:
- Main class: connection to twitter API, infinite loop to tweet everyday (it sleeps 23h and 59 minutes) and generating the string for the tweet.
- Quote class: getting the information from the database.

If you need modify the script for other pourpose, you need read the comments of the code. I'll generate javadoc and maybe I'll detail the program in this readme.md, but for the instance the comments are very simple (as the program is).

You have a file named twitter4j.properties where you should define your Twitter API Keys.

## Next Step:

I've applied for the elevated access for the API of Twitter. When I could, I'll test that the program tweets properly the quote.

The connection to the API is correct (tested with Twitter.getInstance()).




