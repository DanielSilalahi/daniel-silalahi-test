CREATE TABLE IF NOT EXISTS partai (
    id INT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS dapil (
    id INT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS caleg (
    id INT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    nomor_urut INT,
    partai_id INT,
    dapil_id INT,
    FOREIGN KEY (partai_id) REFERENCES partai(id),
    FOREIGN KEY (dapil_id) REFERENCES dapil(id)
);

-- Insert dummy data for partai
INSERT INTO partai (id, nama) VALUES
(1, 'Partai A'),
(2, 'Partai B'),
(3, 'Partai C');

SELECT * FROM partai;

-- Insert dummy data for dapil
INSERT INTO dapil (id, nama) VALUES
(1, 'Dapil 1'),
(2, 'Dapil 2'),
(3, 'Dapil 3');

SELECT * FROM dapil;

-- Insert dummy data for caleg
INSERT INTO caleg (id, nama, nomor_urut, partai_id, dapil_id) VALUES
(1, 'Caleg 1', 101, 1, 1),
(2, 'Caleg 2', 102, 1, 2),
(3, 'Caleg 3', 103, 2, 1),
(4, 'Caleg 4', 104, 2, 2),
(5, 'Caleg 5', 105, 3, 3);

SELECT * FROM caleg;