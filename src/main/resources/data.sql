--DELETE FROM spring_recipe.usr
--WHERE spring_recipe.usr.id = 1;
INSERT INTO spring_recipe.usr (id, active, username, password) VALUES (1, 'on', 'Admin', 'bogdan4884');
INSERT INTO spring_recipe.user_role (user_id, roles) VALUES (1, 'ADMIN');
INSERT INTO spring_recipe.user_role (user_id, roles) VALUES (1, 'USER');