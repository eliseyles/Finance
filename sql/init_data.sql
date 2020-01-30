-- TRUNCATE TABLE Journal;
-- TRUNCATE TABLE TransactionSubtype;
-- TRUNCATE TABLE TransactionType;

INSERT INTO TransactionType(Title) 
VALUES ('Expense'), ('Income');

INSERT INTO TransactionSubtype(TransactionTypeId, Title) 
VALUES (1, 'Clothes'), 
 		(1, 'Food'), 
		(1, 'Eatingout'), 
		(1, 'Entertainment'), 
		(1, 'Transport'),
        (1, 'Tax'),
        (1, 'Health'),
        (1, 'Other'), 
        (2, 'Salary'),
        (2, 'Savings'), 
        (2, 'Debt');

INSERT INTO Journal(TransactionTypeId, TransactionDate, 
TransactionSubtypeId, Amount, Title)
VALUES (2, '2020-01-20 00:00:00', 9, 600, 'Salary from Jan'),
		(1, '2020-01-21 00:00:00', 1, 300, 'Smth'), 
        (1, '2020-01-21 00:00:00', 3, 250, 'Smth new'),
        (1, '2020-01-21 00:00:00', 4, 200, 'Smth else'), 
        (1, '2020-01-21 00:00:00', 5, 10, 'Smth to delete');





