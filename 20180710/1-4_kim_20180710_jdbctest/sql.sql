--  查询出每位员工的工资等级
  select e.ename,e.sal,s.grade from emp e left join salgrade s on e.sal>s.losal and e.sal<=s.hisal;  
  
--   求平均工资最高的部门的部门编号和部门名称
  select dept.deptno,dept.dname from dept,(select deptno from emp group by deptno order by avg(sal) desc) m where dept.deptno=m.deptno and rownum=1;
    
--  求工资高于公司平均工资的员工
  select emp.ename,emp.sal,s.avgsal from emp,(select avg(sal) avgsal from emp) s where emp.sal>s.avgsal;
  
--  求工资最高的员工姓名和工资
  select t.ename,t.sal from (select ename,sal  from emp order by sal desc) t where rownum=1;
  
--  求工资高于所在部门平均工资的员工
	select emp.ename,emp.sal from emp,(select deptno,avg(sal) avgsal from emp group by deptno) s where emp.deptno=s.deptno and emp.sal>s.avgsal;
  
--	列出各部门工资最高的员工信息
    select e.ename,e.sal,e.deptno from emp e,
  (select deptno,max(sal) maxsal from emp group by deptno) t 
  where e.sal=t.maxsal and e.deptno=t.deptno;
  
--  求平均工资的级别最低的部门名称

--  求比普通员工最高工资高的经理员工姓名
	select emp.ename from emp,(select sal from emp order by sal desc where job<>'MANAGER' and rownum=1) t where emp.sal>t.sal;

--  求工资最高的前5名员工姓名
	select t.ename from (select ename,sal  from emp order by sal desc) t where rownum<=5;
	
--	求工资最高的前6-10名员工姓名
	select t.ename from (select ename,rownum as rn from (select ename,sal  from emp order by sal desc)) t where t.rn between 6 and 10;
	
--	每个人的工资级别
	select emp.ename,salgrade.grade from emp,salgrade where emp.sal>salgrade.losal and emp.sal<salgrade.hisal;
	
--	列出各部门平均工资及对应的工资等级
	select distinct t.deptno,t.avgsal,salgrade.grade from salgrade,(select deptno,avg(sal) avgsal from emp group by deptno) t where t.avgsal>salgrade.losal and t.avgsal<salgrade.hisal;