CREATE DATABASE coolbox_db;
USE coolbox_db;

-- tables
-- Table: asistencia_empleado
CREATE TABLE asistencia_empleado
(
    id           int       NOT NULL AUTO_INCREMENT,
    empleados_id int       NOT NULL,
    entrada      timestamp NOT NULL,
    salida       timestamp NOT NULL,
    CONSTRAINT asistencia_empleado_pk PRIMARY KEY (id)
);

-- Table: caja
CREATE TABLE caja
(
    id    int NOT NULL AUTO_INCREMENT,
    monto int NOT NULL,
    CONSTRAINT caja_pk PRIMARY KEY (id)
);

-- Table: clientes
CREATE TABLE clientes
(
    id        int         NOT NULL AUTO_INCREMENT,
    nombres   varchar(50) NOT NULL,
    apellidos varchar(50) NOT NULL,
    direccion varchar(50) NOT NULL,
    dni       varchar(50) NOT NULL,
    telefono  varchar(50) NOT NULL,
    correo    varchar(50) NOT NULL,
    CONSTRAINT clientes_pk PRIMARY KEY (id)
);

-- Table: detalle_denta
CREATE TABLE detalle_denta
(
    productos_id int NOT NULL AUTO_INCREMENT,
    venta_id     int NOT NULL,
    cantidad     int NOT NULL,
    CONSTRAINT detalle_denta_pk PRIMARY KEY (productos_id, venta_id)
);

-- Table: empleados
CREATE TABLE empleados
(
    id          int         NOT NULL AUTO_INCREMENT,
    nombres     varchar(50) NOT NULL,
    apellidos   varchar(50) NOT NULL,
    dni         varchar(50) NOT NULL,
    usuario     varchar(50) NOT NULL,
    contrasenia varchar(50) NOT NULL,
    UNIQUE INDEX empleados_ak_1 (usuario),
    CONSTRAINT empleados_pk PRIMARY KEY (id)
);

-- Table: movimientos
CREATE TABLE movimientos
(
    id             int NOT NULL,
    empleados_id   int NOT NULL,
    caja_id        int NOT NULL,
    monto          int NOT NULL,
    operaciones_id int NOT NULL,
    CONSTRAINT movimientos_pk PRIMARY KEY (id)
);

-- Table: operaciones
CREATE TABLE operaciones
(
    id     int         NOT NULL,
    nombre varchar(50) NOT NULL,
    CONSTRAINT operaciones_pk PRIMARY KEY (id)
);

-- Table: productos
CREATE TABLE productos
(
    id            int NOT NULL AUTO_INCREMENT,
    nombre        int NOT NULL,
    precio_compra int NOT NULL,
    precio_venta  int NOT NULL,
    stock         int NOT NULL,
    CONSTRAINT productos_pk PRIMARY KEY (id)
);

-- Table: ventas
CREATE TABLE ventas
(
    id           int NOT NULL AUTO_INCREMENT,
    empleados_id int NOT NULL,
    clientes_id  int NOT NULL,
    total        int NOT NULL,
    CONSTRAINT ventas_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: asistencia_empleado_empleados (table: asistencia_empleado)
ALTER TABLE asistencia_empleado
    ADD CONSTRAINT asistencia_empleado_empleados FOREIGN KEY asistencia_empleado_empleados (empleados_id)
        REFERENCES empleados (id);

-- Reference: detalle_denta_productos (table: detalle_denta)
ALTER TABLE detalle_denta
    ADD CONSTRAINT detalle_denta_productos FOREIGN KEY detalle_denta_productos (productos_id)
        REFERENCES productos (id);

-- Reference: detalle_denta_venta (table: detalle_denta)
ALTER TABLE detalle_denta
    ADD CONSTRAINT detalle_denta_venta FOREIGN KEY detalle_denta_venta (venta_id)
        REFERENCES ventas (id);

-- Reference: movimientos_caja (table: movimientos)
ALTER TABLE movimientos
    ADD CONSTRAINT movimientos_caja FOREIGN KEY movimientos_caja (caja_id)
        REFERENCES caja (id);

-- Reference: movimientos_empleados (table: movimientos)
ALTER TABLE movimientos
    ADD CONSTRAINT movimientos_empleados FOREIGN KEY movimientos_empleados (empleados_id)
        REFERENCES empleados (id);

-- Reference: movimientos_operaciones (table: movimientos)
ALTER TABLE movimientos
    ADD CONSTRAINT movimientos_operaciones FOREIGN KEY movimientos_operaciones (operaciones_id)
        REFERENCES operaciones (id);

-- Reference: venta_clientes (table: ventas)
ALTER TABLE ventas
    ADD CONSTRAINT venta_clientes FOREIGN KEY venta_clientes (clientes_id)
        REFERENCES clientes (id);

-- Reference: venta_empleados (table: ventas)
ALTER TABLE ventas
    ADD CONSTRAINT venta_empleados FOREIGN KEY venta_empleados (empleados_id)
        REFERENCES empleados (id);