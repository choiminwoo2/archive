CREATE TABLE tbl_todo (
                          tno int AUTO_INCREMENT PRIMARY KEY,
                          title varchar(100) NOT NULL,
                          dueDate date NOT NULL,
                          finished TINYINT DEFAULT 0
);

CREATE TABLE tbl_member (
                            mid varchar(50) PRIMARY KEY,
                            mpw varchar(50) NOT NULL,
                            mname varchar(100) NOT null
);

ALTER TABLE tbl_member ADD COLUMN uuid varchar(50);



