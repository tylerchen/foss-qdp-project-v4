SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO AUTH_USER( ID, NAME, STATUS, TYPE, TEL, EMAIL, SEX, BIRTHDAY, FAMILY_ADDR, WORK_ADDR, WORK_TEL, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES 
('xKQJKJBWR7ziMpyBFFd','管理员','Y','S','13800138000','admin@admin.com','M','1970-01-01 00:00:00','','','','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('aFX3CNaaFqUlPr1H7h6','test1@test1.com','Y','S','123','test1@test1.com','F','1970-01-01 00:00:00','','','','','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO SYS_DICTIONARY( ID, TYPE1, TYPE2, NAME1, NAME2, CODE, VALUE, SORT, DESCIPTION, STATUS, UPDATE_TIME, CREATE_TIME ) VALUES 
('1','S','SYS_ROLE','默认','角色','ADMIN','ADMIN',0,'管理员','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('2','S','SYS_ROLE','默认','角色','OPERATOR','操着者',0,'一般操着者','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('3','S','SYS_ORG','默认','组织','SYS_ORG','SYS_ORG',0,'行政组织','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('4','S','SYS_ORG','默认','组织','SYS_POS','SYS_POS',0,'岗位','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('5','S','SYS_ORG','默认','组织','SYS_PRD','SYS_PRD',0,'生产岗位','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('6','S','SYS_DEF','默认','系统默认','SYS_DEF','SYS_DEF',0,'系统默认','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('7','S','SYS_RES','默认','资源','URL','URL',0,'URL','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('8','S','SYS_RES','默认','资源','BUTTON','BUTTON',0,'按钮','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('9','S','SYS_RES','默认','资源','MENU','MENU',0,'菜单','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('10','S','SYS_SEX','默认','性别','F','男',0,'男','Y','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('11','S','SYS_SEX','默认','性别','M','女',0,'女','Y','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_ROLE( ID, NAME, CODE, TYPE1, TYPE2, STATUS, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES 
('xKQJKJBWR7ziMpyBFFe','测试','TEST','S','OPERATOR','Y','测试','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('xKQJKJBWR7ziMpyBFFc','管理员','ADMIN','S','ADMIN','Y','管理员','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('xKQJKJBWR7ziMpyBFFf','一般用户','USER','S','OPERATOR','Y','一般用户','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_RESOURCE( ID, NAME, CODE, STATUS, TYPE1, TYPE2, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES ('0tXlGsqjkVf833i3cLk','JavaMelody监控','/default/javamelody/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('4fTLyHO7SgSKxwk3otj','系统','/system/auth/authaccount/index#','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('5QWCEA374SXnNArML3o','脚本管理','/system/common/sysscript/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('8OYFlxlRyyVvENt0rzI','系统功能管理','/system/common/sysdictionary/index#','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('aN0fpzVLV7Y7kjbPRmO','账号管理','/system/auth/authaccount/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('aPd0efWiaA3BDyZaUwy','菜单管理','/system/auth/authmenu/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('BC4PxrB3Cj19vhT7w8V','查询管理','/system/common/sysquery/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('CSEychadTOE8VwJxFA6','Quartz任务管理','/default/quartz/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('d3eMsI55WvYjyFew7RN','服务列表','/default/springservice/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('dGhzokeyTWAd01QWxhG','数据词典管理','/system/auth/sysdictionary/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('f2WuQ7CcFbtgHxgO8sA','资源管理','/system/auth/authresource/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('f5cisYML7xlsFIpfxZC','访问日志','/default/log/logaccess/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('J8NnUxsh3OsuDg8sBtu','操作日志','/default/log/logoperation/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('J9YPNfI2SNi4CXn1TC8','HomePage','/index.html','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('JC4Mi0k2Fe3SeUJ3DNL','监控管理','/default/monitor#','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('JdcwvoCZQ1GTzG7UCvq','系统工具','/default/helper/index#','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('jxIzZK8jpUP6lKmO4v8','Druid监控','/default/druid/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('K7dIvNiGtnIRNr4pJ8x','权限管理','menu:system:auth','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('LD4TALxxcxc3C885gDJ','ALLURL','/**','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('mBcuePYcShiEVynpsnl','组织机构管理','/system/auth/authorganization/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('P5ZHIGt2KnwxaAGiuRt','员工管理','/system/auth/authuser/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('pyJLeyR2hF3uMNtmlwr','国际化管理','/system/common/sysi18n/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('RJsVGR7b2LXlFXO5fz4','字典管理','/system/common/sysdictionary/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('rWlDZxljQyC1fqtr3sp','资源与角色关系','/system/authroleresource/authroleresource_list.html','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('V1OOqOHgYQwix3lPGqb','角色管理','/system/auth/authrole/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('VLp1N46V2WRq7dAil3n','日志管理','/default/log#','Y','S','MENU','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('Xyh9lHyFSqCSyurLN9a','帐号管理-所有','/system/authaccount','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('zPlHv4bfWywuMp6s0kS','数据过滤管理','/system/authdatafilterconf/authdatafilterconf_list.html','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('zWleC50BS8AP0qNPPxR','工具','/default/helper/index','Y','S','URL','','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_MENU( ID, NAME, RESOURCE_ID, TYPE1, TYPE2, PARENT_ID, ROOT_ID, MENU_INDEX, MAX_LEVEL, ICO, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES 
('743jLWIk4XCzOtAUQda','工具','zWleC50BS8AP0qNPPxR','S','S','Ips0DdWFRvNy0tPqV4a','vGdRnsrvvq6Aik19SZ8',10,3,'el-icon-ion-ios-help',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('8ERjaIDCVO0d2OXAcn5','员工管理','P5ZHIGt2KnwxaAGiuRt','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',60,3,'el-icon-ion-ios-people','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('97zPYIjrSsQpfVevLM8','角色管理','V1OOqOHgYQwix3lPGqb','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',200,3,'el-icon-ion-transgender','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('9ZAB32sjb2mvQKeYTbq','脚本管理','5QWCEA374SXnNArML3o','S','S','BU6yLmzZ16MwGyzrLZP','vGdRnsrvvq6Aik19SZ8',50,3,'el-icon-ion-code-working',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('b75USmuLtQuNvMaMWnt','权限管理','K7dIvNiGtnIRNr4pJ8x','S','S','vGdRnsrvvq6Aik19SZ8','vGdRnsrvvq6Aik19SZ8',10,3,'el-icon-star-on','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('BDPqO6Rk3Kwqh4xkEPN','Druid监控','jxIzZK8jpUP6lKmO4v8','S','S','iwhpF62dmTZZbSWlFnX','vGdRnsrvvq6Aik19SZ8',100,3,'el-icon-ion-funnel',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('BU6yLmzZ16MwGyzrLZP','系统功能管理','8OYFlxlRyyVvENt0rzI','S','S','vGdRnsrvvq6Aik19SZ8','vGdRnsrvvq6Aik19SZ8',20,3,'el-icon-ion-ios-cog',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('cTmCT1xHpVgA7UT4XEO','日志管理','VLp1N46V2WRq7dAil3n','S','S','vGdRnsrvvq6Aik19SZ8','vGdRnsrvvq6Aik19SZ8',50,3,'el-icon-ion-grid',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('HrqYWA4WNAzy9EyGNGf','资源管理','f2WuQ7CcFbtgHxgO8sA','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',140,3,'el-icon-ion-android-list','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('Ips0DdWFRvNy0tPqV4a','系统工具','JdcwvoCZQ1GTzG7UCvq','S','S','vGdRnsrvvq6Aik19SZ8','vGdRnsrvvq6Aik19SZ8',40,3,'el-icon-ion-settings',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('iwhpF62dmTZZbSWlFnX','监控管理','JC4Mi0k2Fe3SeUJ3DNL','S','S','vGdRnsrvvq6Aik19SZ8','vGdRnsrvvq6Aik19SZ8',30,3,'el-icon-ion-ios-monitor',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('japldSiYHH2jJcA2MsR','账号管理','aN0fpzVLV7Y7kjbPRmO','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',120,3,'el-icon-ion-person','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('LRXMSpmgthuuyxbh52F','JavaMelody监控','0tXlGsqjkVf833i3cLk','S','S','iwhpF62dmTZZbSWlFnX','vGdRnsrvvq6Aik19SZ8',150,3,'el-icon-ion-quote',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('oUofMZw1Rb35wcST3ec','操作日志','J8NnUxsh3OsuDg8sBtu','S','S','cTmCT1xHpVgA7UT4XEO','vGdRnsrvvq6Aik19SZ8',20,3,'el-icon-ion-social-windows',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('sesNTBKYbXiZ2jIN2zo','组织机构管理','mBcuePYcShiEVynpsnl','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',210,3,'el-icon-ion-ios-world','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('Sf2dm4RNltQSHdiVWeh','查询管理','BC4PxrB3Cj19vhT7w8V','S','S','BU6yLmzZ16MwGyzrLZP','vGdRnsrvvq6Aik19SZ8',30,3,'el-icon-ion-funnel',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('ugwVl2wM3bMjigH3T7s','访问日志','f5cisYML7xlsFIpfxZC','S','S','cTmCT1xHpVgA7UT4XEO','vGdRnsrvvq6Aik19SZ8',10,3,'el-icon-ion-link',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('V3g7M6zwT9nmHIHgfFr','服务列表','d3eMsI55WvYjyFew7RN','S','S','iwhpF62dmTZZbSWlFnX','vGdRnsrvvq6Aik19SZ8',70,3,'el-icon-ion-ios-browsers',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('vGdRnsrvvq6Aik19SZ8','系统','4fTLyHO7SgSKxwk3otj','S','S',NULL,'vGdRnsrvvq6Aik19SZ8',220,3,'el-icon-setting','','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('vLc24lTooVDLSTuocOK','Quartz任务管理','CSEychadTOE8VwJxFA6','S','S','BU6yLmzZ16MwGyzrLZP','vGdRnsrvvq6Aik19SZ8',40,3,'el-icon-time',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('wLx10oOTUSTo7cxmSsz','字典管理','RJsVGR7b2LXlFXO5fz4','S','S','BU6yLmzZ16MwGyzrLZP','vGdRnsrvvq6Aik19SZ8',10,3,'el-icon-ion-outlet',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('yq3y1yyNdpgiihXGg2A','国际化管理','pyJLeyR2hF3uMNtmlwr','S','S','BU6yLmzZ16MwGyzrLZP','vGdRnsrvvq6Aik19SZ8',20,3,'el-icon-ion-ios-analytics',NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00'),
('YQpiwsMReek9qkTeg2U','菜单管理','aPd0efWiaA3BDyZaUwy','S','S','b75USmuLtQuNvMaMWnt','vGdRnsrvvq6Aik19SZ8',190,3,'el-icon-menu','','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_ORGANIZATION( ID, NAME, PARENT_ID, ROOT_ID, CODE, IS_USE_ROOT_MENU, TYPE1, TYPE2, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES 
('SrUkEHSpFIY3Fs7jipK','系统管理部',NULL,'SrUkEHSpFIY3Fs7jipK','SYSTEM_ADMIN','Y','S','S','','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_ACCOUNT( ID, LOGIN_EMAIL, LOGIN_PASSWD, STATUS, TYPE, USER_ID, LAST_LOGIN, LOGIN_TRY_TIMES, DESCRIPTION, UPDATE_TIME, CREATE_TIME ) VALUES 
('xKQJKJBWR7ziMpyBFFb','admin@123.com','56d2024b4db9684f4358cc0a67192d2b','Y','S','xKQJKJBWR7ziMpyBFFd','1970-01-01 00:00:00',0,'管理员账号','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('e6qwwAcWYAUFSltoTO7','test1@test1.com','56d2024b4db9684f4358cc0a67192d2b','Y','S','aFX3CNaaFqUlPr1H7h6','1970-01-01 00:00:00',0,'测试账号','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_AUTHER_MENU( ID, AUTHER_ID, MENU_ID, TYPE, SORT, CREATE_TIME, UPDATE_TIME ) VALUES 
('xKQJKJBWR7ziMpyBFFt','xKQJKJBWR7ziMpyBFFc','vGdRnsrvvq6Aik19SZ8','AuthRole',10,'1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_AUTHER_ROLE( ID, AUTHER_ID, ROLE_ID, TYPE, CREATE_TIME, UPDATE_TIME ) VALUES 
('xKQJKJBWR7ziMpyBFFa','xKQJKJBWR7ziMpyBFFb','xKQJKJBWR7ziMpyBFFc','AuthAccount','1970-01-01 00:00:00','1970-01-01 00:00:00');
INSERT INTO AUTH_ROLE_RESOURCE( ID, ROLE_ID, RESOURCE_ID, CREATE_TIME, UPDATE_TIME ) VALUES 
('nyMv10bU5k0rWBy6Miw','xKQJKJBWR7ziMpyBFFe','K7dIvNiGtnIRNr4pJ8x','1970-01-01 00:00:00','1970-01-01 00:00:00'),
('Q2VntRpvE1iXRhCqnI1','xKQJKJBWR7ziMpyBFFe','4fTLyHO7SgSKxwk3otj','1970-01-01 00:00:00','1970-01-01 00:00:00');

SET REFERENTIAL_INTEGRITY TRUE;