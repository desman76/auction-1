package io.khasang.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class CreateTable {

    @Autowired

    private JdbcTemplate jdbcTemplate;


    public String getTableCreationStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS birds ");
            jdbcTemplate.execute("CREATE TABLE public.birds\n" +
                    "                (\n" +
                    "                        id integer NOT NULL,\n" +
                    "                        name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "                        description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "                        color integer,\n" +
                    "                        CONSTRAINT birds_pkey PRIMARY KEY (id)\n" +
                    "                )");


            return "tableCreated";
        } catch(Exception e) {
            e.printStackTrace();
            return "failed" + e;
        }
    }





}
