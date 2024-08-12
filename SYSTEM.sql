alter table Donation
add title varchar(10);

alter table Donation
add categories varchar(2)
add startDate DATE
add lastDate DATE
add points INT
add targetAmount INT;

SELECT * FROM donation ORDER BY seq DESC;

