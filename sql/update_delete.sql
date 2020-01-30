UPDATE Journal
SET Amount = 900
WHERE TransactionSubtypeId in (9);

DELETE FROM Journal 
WHERE Amount < 100;	