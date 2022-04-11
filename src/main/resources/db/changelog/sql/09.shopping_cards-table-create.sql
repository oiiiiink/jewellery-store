create table shopping_cards (
    id bigserial,
    users_id bigint references users(id),
    products_id bigint references products(id)
);