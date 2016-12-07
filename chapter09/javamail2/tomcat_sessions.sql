create table tomcat_sessions (
  session_id     varchar(100) not null primary key,
  valid_session  char(1) not null,
  max_inactive   int not null,
  last_access    bigint not null,
  app_name       varchar(255),
  session_data   mediumblob,
  KEY kapp_name(app_name)
);
