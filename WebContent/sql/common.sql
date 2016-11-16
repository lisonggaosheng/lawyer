select casecodeself,pname,excludeStatus,caseCode,count(*) as count from courtinfo where caseCode is not null and excludeStatus = '0'
group by pname,caseCode having count>1;