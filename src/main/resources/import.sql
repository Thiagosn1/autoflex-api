INSERT INTO tb_raw_materials (id, code, name, quantityInStock) VALUES
(UUID_TO_BIN(UUID()), 'MP001', 'Puxador Cromado 128mm', 300.00),
(UUID_TO_BIN(UUID()), 'MP002', 'Fechadura para Móveis', 200.00),
(UUID_TO_BIN(UUID()), 'MP003', 'Guia Deslizante para Gaveta', 400.00),
(UUID_TO_BIN(UUID()), 'MP004', 'Pé de Borracha para Mesa', 600.00),
(UUID_TO_BIN(UUID()), 'MP005', 'Adesivo de Montagem', 150.00),
(UUID_TO_BIN(UUID()), 'MP006', 'Suporte Metálico L 40x40', 180.00),
(UUID_TO_BIN(UUID()), 'MP007', 'Parafuso para MDF 4x30', 2500.00),
(UUID_TO_BIN(UUID()), 'MP008', 'Fita de Borda Automática', 120.00),
(UUID_TO_BIN(UUID()), 'MP009', 'Puxador para Porta de Correr', 95.00),
(UUID_TO_BIN(UUID()), 'MP010', 'Rodízio para Móveis', 210.00);

INSERT INTO tb_products (id, code, name, price) VALUES
(UUID_TO_BIN(UUID()), 'PROD001', 'Guarda-Roupa Casal 6 Portas', 1890.00),
(UUID_TO_BIN(UUID()), 'PROD002', 'Mesa de Jantar 6 Lugares', 1250.00),
(UUID_TO_BIN(UUID()), 'PROD003', 'Cama Box Queen com Colchão', 950.00),
(UUID_TO_BIN(UUID()), 'PROD004', 'Estante para Livros 5 Prateleiras', 320.00),
(UUID_TO_BIN(UUID()), 'PROD005', 'Escrivaninha de Estudo', 280.00),
(UUID_TO_BIN(UUID()), 'PROD006', 'Sofá 3 Lugares Retrátil', 2200.00),
(UUID_TO_BIN(UUID()), 'PROD007', 'Cadeira de Escritório Ergonômica', 450.00),
(UUID_TO_BIN(UUID()), 'PROD008', 'Rack para TV 55 Polegadas', 680.00),
(UUID_TO_BIN(UUID()), 'PROD009', 'Cômoda 4 Gavetas', 720.00),
(UUID_TO_BIN(UUID()), 'PROD010', 'Mesa de Centro em Vidro', 890.00),
(UUID_TO_BIN(UUID()), 'PROD011', 'Poltrona Reclinável', 950.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD001'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP001'), 8.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD001'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP002'), 2.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD001'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP003'), 12.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD002'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP004'), 6.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD002'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP007'), 48.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD003'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP006'), 4.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD003'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP010'), 4.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD004'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP008'), 18.50),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD004'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP007'), 35.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD005'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP003'), 4.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD005'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP001'), 6.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD005'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP005'), 0.75);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD006'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP010'), 6.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD006'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP009'), 2.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD007'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP003'), 8.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD007'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP010'), 5.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD008'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP001'), 4.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD008'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP006'), 2.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD009'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP002'), 4.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD009'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP003'), 8.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD009'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP007'), 32.00);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD010'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP004'), 4.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD010'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP005'), 1.20);

INSERT INTO tb_product_raw_materials (id, product_id, raw_material_id, quantityRequired) VALUES
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD011'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP009'), 1.00),
(UUID_TO_BIN(UUID()), 
 (SELECT id FROM tb_products WHERE code = 'PROD011'),
 (SELECT id FROM tb_raw_materials WHERE code = 'MP010'), 4.00);