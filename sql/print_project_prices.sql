SELECT PROJECT.ID, 
SUM(WORKER.SALARY * DATEDIFF(
	MONTH, PROJECT.START_DATE, 
	PROJECT.FINISH_DATE)) AS Project_Cost
FROM PROJECT
INNER JOIN PROJECT_WORKER ON PROJECT.ID = PROJECT_WORKER.PROJECT_ID
INNER JOIN WORKER ON PROJECT_WORKER.WORKER_ID = WORKER.ID
GROUP BY PROJECT.ID;
