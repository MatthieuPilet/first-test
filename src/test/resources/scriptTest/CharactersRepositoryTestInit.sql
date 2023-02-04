INSERT INTO ACCOUNT_INFORMATION(account_id,account_username,account_password,account_email,account_age,account_birthday,account_subscription_date) VALUES (99999996,'test_username', 'test_password', 'test_mail',1,CURRENT_DATE,CURRENT_DATE);    

INSERT INTO BASE_WEAPON(base_weapon_id,base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES (99999999,'Bow',8,9,6,5,7,4,6); 
INSERT INTO BASE_WEAPON(base_weapon_id,base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES (99999998,'Sword',10,6,5,4,5,9,7); 

INSERT INTO CHARACTERS_STATS(character_stats_id,character_strength,character_agility,character_intelligence,character_wisdom,character_stealth,character_vitality,character_energy,character_life) 
	VALUES (99999999,8,9,6,5,7,4,6,100.0); 
INSERT INTO CHARACTERS_STATS(character_stats_id,character_strength,character_agility,character_intelligence,character_wisdom,character_stealth,character_vitality,character_energy,character_life) 
	VALUES (99999998,10,6,5,4,5,9,7,100.0);

INSERT INTO CHARACTERS(character_id,account_id,base_weapon_id,character_stats_id,character_name,character_title) 
	VALUES (99999999,99999996,99999999,99999999,
			'Test_name1','Test_title'); 
INSERT INTO CHARACTERS(character_id,account_id,base_weapon_id,character_stats_id,character_name,character_title) 
	VALUES (99999998,99999996,99999998,99999998,
			'Test_name1','Test_title'); 