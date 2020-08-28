insert into Rescue (Rescue_ID, Organization_Name, Email, Phone, Link, City, Zipcode) 
values ("rid", "our shelter", "ourshelter@usc", "405509", "ourshelter.com", "los angeles", "73013"), 
("RID2", "shelter name 2", "ourshelter@us", "40559", "2ourshelter.com", "los angeles", "90089"), 
("RID3", "shelter name 3", "3shelter@us", "43430559", "o3urshelter.com", "los angeles", "989")
;

insert into Adopter (First_Name, Last_Name, Email, Phone, Zipcode, City, Password) 
value ("joe", "mac", "email@email", "4055090325", "73013", "los angeles", "password");

insert into Pet (Pet_ID, Pet_Name, PetType, Age, Size, Gender, Rescue_ID,
ImgLink, Children, Dogs, Cats) 
values (123, "mac and cheese", "cat", "old", "big", "female", "rid", "imglink.com", 1, 1, 1),
(2, "spoon", "cat", "12", "smol", "female", "rid", "imglink.com", 1, 1, 1),
(1, "bacon", "cat", "11", "smol", "female", "rid", "imglink.com", 1, 1, 1),
(3, "grilledcheese", "baby", "dog", "smol", "female", "rid", "imglink.com", 1, 1, 1),
(4, "bailey", "bird", "not babe", "BIG", "female", "rid", "imglink.com", 1, 1, 1),
(5, "car", "cat", "adolescent", "medium", "male", "rid", "imglink.com", 1, 1, 1),
(6, "cuppie", "dog", "adolescent", "medium", "male", "rid", "imglink.com", 1, 1, 1),
(7, "the very last pet", "cat", "adolescent", "medium", "male", "rid", "imglink.com", 1, 1, 1); 

insert into Message (Sender, Pet_ID, Email, Date_Time, Content) 
values (1, 123, "email@email", "2020-7-12 12:34:5342", "hi there"),
(0, 123, "email@email", "2020-7-12 12:35:5342", "hi there"),
(0, 123, "email@email", "2020-7-12 12:36:5342", "wahts up"),
(1, 123, "email@email", "2020-7-12 12:37:5342", "some yeehaw shit thanks"),
(1, 3, "email@email", "2020-7-12 12:37:5342", "I too want a grilled cheese"),
(1, 2, "email@email", "2020-7-12 12:37:5342", "cuppie"),
(1, 2, "email@email", "2020-7-12 12:38:5342", "just change his code"),
(1, 4, "email@email", "2020-7-12 12:37:5342", "is ti still gonna "),
(1, 5, "email@email", "2020-7-12 12:39:5342", "will there sil "),
(1, 6, "email@email", "2020-7-12 12:39:5342", "chat jsp"),
(1, 7, "email@email", "2020-7-12 12:40:5342","well hmmm");