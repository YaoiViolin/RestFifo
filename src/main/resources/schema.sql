drop table if exists messages;

create table if not exists messages (
    id serial primary key ,
    msg text
);

insert into messages (msg) values
                                  ('oh, hi it is me, the first message'),
                                  ('rita'),
                                  ('3rd message'),
                                  ('hello, darkness, my old friend. i''ve come to talk to you again');