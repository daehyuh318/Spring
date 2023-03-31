CREATE TABLE Meber(
                      id number(10),
                      name varchar2(100)
);

select * from Member;

desc Member;
INSERT INTO Member VALUES (s1.NEXTVAL,'2');

commit;

CREATE SEQUENCE s1;
drop SEQUENCE s1;