BEGIN
	declare _casecodeself varchar(100); -- 案源标示
	declare _count int; -- 案源标示
	declare _executestep varchar(100); -- 最小执行步骤
	declare _savetime varchar(100); -- 最小保存时间
	declare done int;
	declare deal_count int  DEFAULT 0;

	DECLARE rs_cursor CURSOR FOR select count(*) as count,MIN(executestep),MIN(savetime),casecodeself from courtinfo 
	where   LENGTH(caseCode)>0  and excludeStatus = '0' and executestep=2
	group by pname,caseCode having count>1
	order by executestep  asc,savetime asc ;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;

	open rs_cursor; 
	cursor_loop:loop
   FETCH rs_cursor into _count, _executestep, _savetime,_casecodeself; -- 取数据

	if done=1 then
    leave cursor_loop;
   end if;

	##update courtinfo set excludeStatus='2';
	delete  from courtinfo where casecodeself=_casecodeself;
	delete  from executebusiness where e_c_casecodeself=_casecodeself;

	set deal_count = deal_count+1;
	end loop cursor_loop;
close rs_cursor;
select deal_count;
END