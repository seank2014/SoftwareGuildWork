USE ConsumerComplaints;
-- testing white space
-- remove parentheses in a boolean means it wont run the condition
SELECT *
FROM Complaint
WHERE STATE = 'LA'
AND Product = 'Mortagage' OR Product = 'Debt Collection';
