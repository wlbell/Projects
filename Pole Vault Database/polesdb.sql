DROP TABLE IF EXISTS atlete_uses;
DROP TABLE IF EXISTS athlete;
DROP TABLE IF EXISTS ownes;
DROP TABLE IF EXISTS poles;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS school;


create table company(comp_name varchar(255),email varchar(255), website varchar(255), primary key(comp_name))ENGINE = InnoDB;

create table brand(brand_name varchar(255), ID_num integer,length float(3,1), test_weight_range varchar(255),comp_name 									varchar(255),primary key(brand_name, ID_num), foreign key(comp_name) references company(comp_name) on delete 							cascade on update cascade)ENGINE = InnoDB;

create table school(coach varchar(255),school_name varchar(255),divison varchar(2),email varchar(255), primary key(coach))ENGINE = InnoDB;

create table athlete(A_ID tinyint, a_name varchar(255),weight integer, primary key(A_ID), coach varchar(255), foreign key (coach)           						references school(coach) on delete cascade on update cascade)ENGINE = InnoDB;

create table poles(test_weight integer, length float(3,1),flex_number float(3,1),  brand_name varchar(255),lendable varchar(255), comp_name varchar(255),ID_num integer, coach varchar(255), primary key(length,test_weight,flex_number),foreign key(brand_name,ID_num) references brand(brand_name, ID_num),foreign key(comp_name) references company(comp_name), foreign key (coach) references school(coach))ENGINE = InnoDB;




create table athlete_uses(test_weight integer, length float(3,1),flex_number float(3,1), lendable varchar(3), A_ID tinyint, a_name                                             							varchar(255),weight integer,primary key(length,test_weight,A_ID), foreign key(length,test_weight) references poles(length,test_weight) on delete cascade on update cascade, foreign key(A_ID) references athlete(A_ID) on delete cascade )ENGINE = InnoDB;
							


							
/*create table ownes(test_weight integer,length float(3,1),coach varchar(255), primary key(length,test_weight,coach), foreign 							key(length,test_weight) references poles(length, test_weight) on delete cascade on update cascade, foreign 								key(coach) references school(coach) on delete cascade)ENGINE = InnoDB; */





/* Didn't know where to put the data files...?
load data infile '/home/will/Desktop/dbpjt/data/company' into table company;
load data infile '/home/will/Desktop/dbpjt/data/schools' into table school;
source /home/will/Desktop/dbpjt/data/brand.sql
source /home/will/Desktop/dbpjt/data/Poles.sql
source /home/will/Desktop/dbpjt/data/Athletes.sql
source /home/will/Desktop/dbpjt/data/uses.sql */
