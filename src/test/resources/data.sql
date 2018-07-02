INSERT INTO campaign (id, name, advertising_phrase, weight) VALUES (1, 'campaign_test', 'advert_phrase', 10);
INSERT INTO campaign (id, name, advertising_phrase, weight) VALUES (2, 'campaign_test2', 'advert_phrase2', 50);
INSERT INTO campaign (id, name, advertising_phrase, weight) VALUES (3, 'campaign_test3', 'advert_phrase3', 30);

INSERT INTO placement (id, name) VALUES (1, 'placement_test');
INSERT INTO placement (id, name) VALUES (2, 'placement_test2');
INSERT INTO placement (id, name) VALUES (3, 'placement_test3');

INSERT INTO campaign_to_placement (campaign_id, placement_id) VALUES (1, 1);
INSERT INTO campaign_to_placement (campaign_id, placement_id) VALUES (2, 2);