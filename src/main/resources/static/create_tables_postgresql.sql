CREATE TABLE usuario (
    id UUID PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE
);

CREATE TABLE categoria (
    id UUID PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion TEXT
);

CREATE TABLE gasto (
    id UUID PRIMARY KEY,
    monto DECIMAL(10,2),
    descripcion TEXT,
    fecha DATE,
    usuario_id UUID REFERENCES usuario(id),
    categoria_id UUID REFERENCES categoria(id)
);


CREATE TABLE ingreso (
    id UUID PRIMARY KEY,
    monto DECIMAL(10,2),
    fecha DATE,
    fuente VARCHAR(100),
    descripcion TEXT,
    usuario_id UUID REFERENCES usuario(id)
);
