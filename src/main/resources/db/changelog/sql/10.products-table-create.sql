create table products (
    id bigserial primary key,
    title varchar(30),
    price decimal,
    presentation_image text not null,
    short_description varchar not null,
    long_description text not null,
    size decimal not null,
    product_type_id integer references product_types(id),
    producer_id integer references producers(id),
    stone_id bigint references stones(id)
);