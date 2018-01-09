# BlackjackJava
Simple game of Blackjack written in java.

Played in the users terminal using basic interactions.
Game is unfinished, still lacks splitting on doubles as well as ace revaluing.

Eventual plan is to pair this with an Angular front-end which will visualize the
game in a more appealing way. Until that time the game is mostly fully functional 
within the console.

The code itself is an attempt to embody the rules and guidelines of Bob Martin's
Clean Code series. Code should be easy to follow for any reader regardless of their 
familiarity with Java. I attempted to keep all methods very short and readable though
there are still a few which need further extraction. This was more of an exercise in 
Java as I was new to the language but it has turned into a little project as I have
continued to refactor and simplify the code. There are several features which are
unnecessary such as the Enum's for card face and suit as well as some of the static 
variables for user inputs. These could have been achieved in a more consistent way but
the point of this code was to experiment with different tools available in Java so any 
irregularities and inconsistencies are there because I wanted to explore different features
rather than keep the code uniform.

**********************************************************************************************

This may be recreated in a new repo utilizing stringent TDD practices as a way to refactor the
code and ensure that the program is both flexible and loosely coupled. 
