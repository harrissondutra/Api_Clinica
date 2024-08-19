ALTER TABLE doctor
    ADD active BOOLEAN;

UPDATE doctor
SET active = true;