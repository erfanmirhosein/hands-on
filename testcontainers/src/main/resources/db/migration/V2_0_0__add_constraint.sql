alter table test_schema.test_table
    add CONSTRAINT dmy_less_than_twenty check ( dummy_field < 20 )