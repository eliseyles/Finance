CREATE DATABASE FinanceJournal;

USE FinanceJournal;

CREATE TABLE TransactionType (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(50) NOT NULL    
);

CREATE TABLE TransactionSubtype (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    TransactionTypeId INT NOT NULL,
    Title VARCHAR(50) NOT NULL,
    CONSTRAINT transactionsubtype_transactiontype_fk
    FOREIGN KEY (TransactionTypeId)  REFERENCES TransactionType (Id)
);

CREATE TABLE Journal (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    TransactionTypeId INT NOT NULL,
    TransactionDate DATETIME NOT NULL,
    TransactionSubtypeId INT NOT NULL,
    Amount DECIMAL NOT NULL,
    Title VARCHAR(255),
    CONSTRAINT journal_transactiontype_fk
    FOREIGN KEY (TransactionTypeId)  REFERENCES TransactionType (Id),
    CONSTRAINT journal_transactionsubtype_fk
    FOREIGN KEY (TransactionSubtypeId)  REFERENCES TransactionSubtype (Id)
);


