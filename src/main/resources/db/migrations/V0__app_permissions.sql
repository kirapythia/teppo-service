CREATE SCHEMA project;
ALTER SCHEMA project OWNER TO tepposervice;

-- Make default grants to application role for objects created by flyway
GRANT CONNECT, CREATE ON DATABASE teppo TO "${application_user}";
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA project TO "${application_user}";
