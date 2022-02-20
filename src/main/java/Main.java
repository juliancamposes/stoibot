import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[]Args) throws InterruptedException, TwitterException {

        boolean errorSystem = false;
        String quote;
        String author;
        String tweetOfTheDay;
        String time;

        while (!errorSystem) {

            //Getting the hour, minutes and seconds
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            time = dtf.format(LocalDateTime.now());

            // Creating the quote with the author
            try {
                if (time.equals("14:50:00")){

                    Quote DailyQuote = new Quote();
                    quote = DailyQuote.getQuote();
                    author = DailyQuote.getAuthor();
                    tweetOfTheDay = createTweet(quote, author);
                    System.out.println(tweetOfTheDay);

                    //Twitter API using Twitter4j library
                    //For tweet you need higher access level than essential (Elevated access)

                    Twitter twitter = new TwitterFactory().getInstance();
                    Status tweet = twitter.updateStatus(tweetOfTheDay);


                    //Sleep the program 23h and 59 minutes for the next tweet
                    TimeUnit.MINUTES.sleep(1439);

                } else {
                    System.out.println(time);
                }
            } catch (Exception e) {
                System.out.println("Oops! A system error was has occurred");
                System.out.println(e);
                errorSystem = true;
            }
        }
    }

    public static String createTweet(String quote, String author){
        String authorWithoutSpaces = author.replace(" ","");
        String tweetOfTheDay = "\""+ quote + "\"\n" + author + "\n#filosofia #estoicismo #"+authorWithoutSpaces+" #citasestoicas";

        //checking the number of characters and shorting if it is more than 160

        int sizeOfTweet = tweetOfTheDay.length();

        if(sizeOfTweet > 160){
            tweetOfTheDay = tweetOfTheDay.substring(0, 156);
            tweetOfTheDay = tweetOfTheDay + " ...";
        }

        return tweetOfTheDay;

    }
}