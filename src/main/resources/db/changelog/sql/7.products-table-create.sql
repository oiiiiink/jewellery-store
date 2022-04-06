create table products (
    id bigserial primary key,
    title varchar(30),
    presentation_image text not null,
    short_description varchar not null,
    long_description text not null,
    product_type_id integer references product_types(id),
    producer_id integer references producers(id)
);