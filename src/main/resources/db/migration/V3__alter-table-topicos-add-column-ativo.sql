ALTER TABLE topicos ADD COLUMN ativo TINYINT;
UPDATE topicos SET ativo = 1;