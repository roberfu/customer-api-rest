CREATE TABLE IF NOT EXISTS customer(
    id SERIAL,
    first_name TEXT,
    last_name TEXT,
    document_type TEXT,
    document_id TEXT,
    phone TEXT,
    email TEXT,
    address_id INT,
    invoice_data_id INT,
    customer_type TEXT,
    legal_name TEXT,
    contact_id INT,
    classification TEXT
);