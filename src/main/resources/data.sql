INSERT INTO game (title, url, description, price, rating, genre, release_date, favorite, status, developer, publisher)
SELECT 'The Witcher 3: Wild Hunt',
       'https://i1.sndcdn.com/artworks-Mnckgkyr334C1360-ZmjZQg-t500x500.jpg',
       'An open-world RPG set in a fantasy universe full of choices and consequences.',
       39.99, 10, 'RPG', '2015-05-19', true, 'Completed',
       'CD Projekt Red', 'CD Projekt'
    WHERE NOT EXISTS (SELECT 1 FROM game WHERE title = 'The Witcher 3: Wild Hunt');

INSERT INTO game (title, url, description, price, rating, genre, release_date, favorite, status, developer, publisher)
SELECT 'Cyberpunk 2077',
       'https://i.redd.it/w44jvkcns8461.png',
       'An open-world RPG set in a dystopian future with high levels of customization and storytelling.',
       59.99, 8, 'RPG', '2020-12-10', false, 'In Progress',
       'CD Projekt Red', 'CD Projekt'
    WHERE NOT EXISTS (SELECT 1 FROM game WHERE title = 'Cyberpunk 2077');

INSERT INTO game (title, url, description, price, rating, genre, release_date, favorite, status, developer, publisher)
SELECT 'Red Dead Redemption 2',
       'https://assets.vg247.com/current//2018/05/red_dead_redemption_2_cover_art_1.jpg',
       'A Western-themed open-world game with a rich narrative and stunning graphics.',
       59.99, 10, 'Action-Adventure', '2018-10-26', true, 'Completed',
       'Rockstar Games', 'Rockstar Games'
    WHERE NOT EXISTS (SELECT 1 FROM game WHERE title = 'Red Dead Redemption 2');

INSERT INTO game (title, url, description, price, rating, genre, release_date, favorite, status, developer, publisher)
SELECT 'God of War',
       'https://upload.wikimedia.org/wikipedia/pt/a/a5/God_of_War_Ragnarök_capa.jpg',
       'A story-driven action game set in the world of Norse mythology.',
       49.99, 9, 'Action', '2018-04-20', false, 'Not Started',
       'Santa Monica Studio', 'Sony Interactive Entertainment'
    WHERE NOT EXISTS (SELECT 1 FROM game WHERE title = 'God of War');

INSERT INTO game (title, url, description, price, rating, genre, release_date, favorite, status, developer, publisher)
SELECT 'Hades',
       'https://cdn1.epicgames.com/min/offer/1200x1600-1200x1600-e92fa6b99bb20c9edee19c361b8853b9.jpg',
       'A rogue-like dungeon crawler game set in the Greek underworld.',
       24.99, 9, 'Indie', '2020-09-17', true, 'Completed',
       'Supergiant Games', 'Supergiant Games'
    WHERE NOT EXISTS (SELECT 1 FROM game WHERE title = 'Hades');

INSERT INTO users (name, email)
SELECT 'John Doe', 'user@email.com'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'user@email.com');
