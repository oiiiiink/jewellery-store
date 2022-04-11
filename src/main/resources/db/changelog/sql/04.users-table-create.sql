create table users (
    id bigserial primary key,
    username varchar(50) unique not null,
    last_name varchar(70) not null,
    first_name varchar(25) not null,
    phone_number varchar(25) not null,
    delivery_address varchar(100) not null,
    role_id bigint references roles(id)
);