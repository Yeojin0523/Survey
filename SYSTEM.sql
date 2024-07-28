create table blog(
    seq NUMBER NOT NULL,
    text VARCHAR(20),
    PRIMARY KEY (seq)
);

insert into blog(seq, text) values(1, '10');

commit;

select * 
from blog;