CREATE DEFINER=`root`@`localhost` PROCEDURE `GETALLROLES`()
BEGIN
select * from roles_master;
END