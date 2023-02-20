SELECT c.ID, c.NAME, COUNT(p.ID) AS num_projects
FROM CLIENT c
LEFT JOIN PROJECT p
ON c.ID = p.CLIENT_ID
GROUP BY c.ID, c.NAME
HAVING COUNT(p.ID) = (
SELECT MAX(num_projects)
FROM (
    SELECT COUNT(p.ID) AS num_projects
    FROM CLIENT c
    LEFT JOIN PROJECT p
    ON c.ID = p.CLIENT_ID
    GROUP BY c.ID
    )
)
ORDER BY num_projects DESC;