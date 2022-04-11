create table producers (
  id bigserial primary key,
  title varchar(50) not null,
  contact_phone varchar(25) not null,
  short_description varchar not null
);