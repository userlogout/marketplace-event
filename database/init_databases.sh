#!/bin/bash
cat database/create_tables.sql | docker exec -i marketplace-postgres psql -U postgres -d marketplace