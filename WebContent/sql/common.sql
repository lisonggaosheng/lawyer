select count(*) as count,casecodeself,pname,excludeStatus,caseCode,MIN(executestep) ,MIN(savetime)  from courtinfo 
where   LENGTH(caseCode)>0  and excludeStatus = '0' and executestep=2
group by pname,caseCode having count>1
order by executestep  asc,savetime asc ;



select * from courtinfo where pname='北京正华永兴房地产开发有限公司' and caseCode='(2013)顺执字第04734号';

select * from executebusiness where e_c_casecodeself in ('11020220130408004','1102022013032202520131004085819');
select * from applierinfo where a_c_casecodeself in ('11020220130408004','1102022013032202520131004085819');





##material表添加attach字段，varchar128