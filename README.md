📌 Overview

This project is a graphical version of the classic Hangman word-guessing game, implemented in Java as part of the Software Development 2 coursework. Instead of typing letters in a console, players interact with a GUI interface built using Swing components.

The program chooses a random word from a list, and the player tries to guess it letter by letter. Each wrong guess reduces the number of remaining lives, shown visually in the interface. The game ends when the word is fully guessed (win) or when all lives are lost (loss).

🔹 Key Features (Mandatory)

Word loading from file

At startup, the program reads words from a text file.

Words are chosen randomly for each round.

Graphical User Interface (GUI)

Word Display (WordPanel): Shows underscores (_) for unguessed letters and fills in correct guesses.

Letter Buttons (ButtonPanel): 26 buttons for A–Z. Once pressed, they disable to prevent repeated guesses.

Lives Display (HealthPanel): Shows remaining lives using colored indicators (green = available, red = used).

Game Flow

Correct guesses reveal letters.

Wrong guesses reduce lives.

Player wins if the word is fully revealed before lives run out.

Player loses if all lives are used, and the full word is revealed.

At the end of each round, the player can choose to restart or exit.

Program termination

Closing the main window exits the game.

🔹 Optional / Extension Features (if implemented)

Adjustable number of lives (difficulty setting).

Ability to load a custom word list.

Option to filter by word length.

Support for multiple languages.

Two-player mode with alternating turns.

🔹 Class Design (Suggested)

MainWindow (extends JFrame) → The main application window holding all panels.

HealthPanel (extends JPanel) → Displays remaining lives with colored indicators.

WordPanel (extends JPanel) → Displays the current word with underscores and revealed letters.

ButtonPanel (extends JPanel) → Contains all letter buttons and handles guesses.

Run (main class) → Entry point, creates the main window and launches the game.

🔹 Marking Breakdown

HealthPanel (lives) → 2 marks

ButtonPanel (alphabet input) → 3 marks

WordPanel (word display) → 3 marks

Full game logic + GUI integration → 4 marks

Code quality (design, comments, cohesion) → 3 marks
Total = 15 marks

🔹 Example Game Flow

Program starts → GUI opens, random word chosen.

Player clicks letters:

Correct → letters revealed in word.

Incorrect → lives reduced, indicator turns red.

Game ends:

Win: message + option to play again.

Lose: full word revealed + option to play again.
