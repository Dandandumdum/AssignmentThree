INSERT INTO franchise (name, description) VALUES ('MCU', 'Lots of heroes running around.');
INSERT INTO franchise (name, description) VALUES ('CHEF TRIALS', 'Tough as nails chefs from across time come together.');
INSERT INTO franchise (name, description) VALUES ('Monster Mash', 'Every monster you can think off hanging out.');

INSERT INTO character (alias, full_name, gender, picture) VALUES ('The Invisible Man','Dave Unseen','Cannot Tell', 'https://www.royalunibrew.com/wp-content/uploads/2021/07/blank-profile-picture-973460_640.png');
INSERT INTO character (alias, full_name, gender, picture) VALUES ('Revenge Chef', 'Gordon Revenge', 'Male', 'https://i.dailymail.co.uk/1s/2021/06/21/09/44480025-9708011-image-a-1_1624263083294.jpg');

INSERT INTO movie (director, genre, movie_title, picture, release_year, trailer, franchise_id) VALUES ('Peter Jackson', 'Adventure', 'King Kong','https://www.denofgeek.com/wp-content/uploads/2017/03/king_kong_2005_peter_jackson_revisited.jpg?fit=1600%2C904', '2005', 'https://www.youtube.com/watch?v=AYaTCPbYGdk&ab_channel=MovieclipsClassicTrailers',3);
INSERT INTO movie (director, genre, movie_title, picture, release_year, trailer, franchise_id) VALUES ('Brad Bird', 'Cooking Action', 'Ratatouille','https://www.pluggedin.com/wp-content/uploads/2019/12/ratatouille-1024x583.png', '2007', 'https://www.imdb.com/video/vi906147865?playlistId=tt0382932&ref_=tt_ov_vi',2);
INSERT INTO movie (director, genre, movie_title, picture, release_year, trailer, franchise_id) VALUES ('Jon Favreau', 'Action', 'Iron Man', '2008','https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_FMjpg_UX1000_.jpg', 'https://www.imdb.com/video/vi447873305?playlistId=tt0371746&ref_=tt_ov_vi',1);