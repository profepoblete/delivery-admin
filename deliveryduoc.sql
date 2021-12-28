-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2021 a las 04:30:05
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `deliveryduoc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descripcion`) VALUES
(1, 'Platos Preparados'),
(2, 'Snack'),
(3, 'Promociones'),
(4, 'Postres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle`, `cantidad`, `subtotal`, `id_producto`, `id_pedido`) VALUES
(1, 3, 2970, 2, 2),
(2, 1, 990, 2, 3),
(3, 1, 3000, 33, 4),
(4, 1, 850, 28, 4),
(5, 1, 3000, 33, 4),
(6, 1, 1300, 1, 7),
(7, 1, 990, 2, 8),
(8, 1, 2500, 31, 9),
(9, 1, 850, 28, 9),
(10, 1, 3000, 33, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_estado`, `descripcion`) VALUES
(1, 'Ingresado'),
(2, 'En preparacion'),
(3, 'En ruta'),
(4, 'Listo para retiro'),
(5, 'Entregado'),
(6, 'Cancelado'),
(7, 'Entrega confirmada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodo` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id_metodo`, `descripcion`) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `fechaventa` date NOT NULL,
  `total` int(11) NOT NULL,
  `detalle_ubicacion` varchar(100) DEFAULT NULL,
  `id_tipo_entrega` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `id_metodo_pago` int(11) NOT NULL,
  `id_ubicacion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `fechaventa`, `total`, `detalle_ubicacion`, `id_tipo_entrega`, `id_estado`, `id_metodo_pago`, `id_ubicacion`, `id_usuario`) VALUES
(2, '2020-11-19', 2970, 'Sala 404', 2, 1, 1, 1, 3),
(3, '2020-11-24', 990, 'Sala verde', 2, 4, 1, 1, 2),
(4, '2020-11-29', 6850, 'Mesón de Recepción', 1, 1, 2, 1, 3),
(5, '2021-09-07', 0, '12', 2, 1, 1, 1, 2),
(6, '2021-09-07', 0, '12', 2, 1, 2, 1, 2),
(7, '2021-09-07', 1300, '12', 1, 1, 1, 1, 2),
(8, '2021-09-07', 990, '11', 2, 1, 1, 1, 2),
(9, '2021-10-26', 6350, '15', 2, 1, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `imagen` varchar(200) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  `id_categoria` int(11) NOT NULL,
  `id_punto_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `precio`, `imagen`, `activo`, `id_categoria`, `id_punto_venta`) VALUES
(1, 'Choclo 250gr', 1300, 'choclobase.png', 1, 1, 1),
(2, 'Completo italiano', 990, 'Doggis_completo.jpg', 1, 2, 2),
(3, 'jugo 200cc', 500, 'jugo.png', 1, 3, 1),
(4, 'Tomate', 400, 'tomates-picados.jpg', 1, 1, 1),
(5, 'albahaca', 500, 'albahaca.jpg', 1, 1, 1),
(6, 'champinones', 500, 'champiÃ±on.jpg', 1, 2, 1),
(7, 'Cebolla Crispy', 500, 'c-47400023-2.jpg', 1, 1, 1),
(27, 'Mixer', 690, 'mixer.jpg', 1, 4, 2),
(28, 'Coca Cola mediana', 850, 'cocaColaMediana.jpg', 1, 2, 2),
(30, 'Super cono', 650, 'superCono.jpg', 1, 4, 2),
(31, 'Crispy HotDog', 2500, 'crispyHotDog.jpg', 1, 2, 2),
(32, 'Granizado', 1400, 'granizado.jpg', 1, 4, 2),
(33, 'Huracan XL', 3000, 'huracanXL.jpg', 1, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `punto_venta`
--

CREATE TABLE `punto_venta` (
  `id_punto_venta` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `empresa` varchar(100) NOT NULL,
  `imagen` varchar(200) NOT NULL,
  `hora_inicio` time NOT NULL DEFAULT '00:00:00',
  `hora_fin` time NOT NULL DEFAULT '00:00:00',
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  `id_sede` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `punto_venta`
--

INSERT INTO `punto_venta` (`id_punto_venta`, `nombre`, `empresa`, `imagen`, `hora_inicio`, `hora_fin`, `activo`, `id_sede`) VALUES
(1, 'Achoclonados', 'Achoclonados SA', 'logo-ACHOCLONADOS.png', '11:11:55', '11:12:35', 1, 1),
(2, 'Doggis', 'Doggis SA', 'doggis-chico.jpg', '09:00:00', '22:00:00', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `id_sede` int(11) NOT NULL,
  `nombre_sede` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`id_sede`, `nombre_sede`, `direccion`) VALUES
(1, 'Antonio Varas', 'Antonio Varas 666, Providencia, Región Metropolitana'),
(3, 'san joaquin', 'Vicuña Mackenna 4917'),
(4, 'alameda ', ' Av. España 8,'),
(5, 'Puente Alto ', 'Avenida Concha Y Toro'),
(7, 'san carlos de apoquindo', 'apoquindo ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_entrega`
--

CREATE TABLE `tipo_entrega` (
  `id_tipo_entrega` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_entrega`
--

INSERT INTO `tipo_entrega` (`id_tipo_entrega`, `descripcion`) VALUES
(1, 'Retiro'),
(2, 'Delivery');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `descripcion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `descripcion`) VALUES
(1, 'administrador'),
(2, 'punto venta'),
(3, 'colaborador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `id_ubicacion` int(11) NOT NULL,
  `nombre_edificio` varchar(50) NOT NULL,
  `piso` varchar(50) NOT NULL,
  `id_sede` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`id_ubicacion`, `nombre_edificio`, `piso`, `id_sede`) VALUES
(1, 'Edificio Varas', '4to piso', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `rut` varchar(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  `contrasena` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  `id_tipo_usuario` int(11) NOT NULL,
  `id_punto_venta` int(11) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `rut`, `nombre`, `apellido`, `email`, `telefono`, `contrasena`, `activo`, `id_tipo_usuario`, `id_punto_venta`, `id_sede`) VALUES
(1, '176166843', 'Fabiola', 'Saez', 'administrador@duoc.cl', NULL, 'duoc.2020', 1, 1, 2, 1),
(2, '89656323', 'Mario', 'Ramirez', 'colaborador@duoc.cl', NULL, 'duoc.2020', 1, 3, NULL, 1),
(3, '189620616', 'Ron', 'Weasley', 'ronw@duoc.cl', 992157066, 'duoc.2020', 1, 3, NULL, 1),
(4, '193314279', 'Jorge', 'Ramirez', 'achoclonados@achoclonados.cl', NULL, 'achoclonados.2020', 1, 2, 1, 1),
(5, '147258369', 'Harry', 'Potter', 'doggis@doggis.cl', 135487, 'doggis', 1, 2, 2, 1),
(6, '1955190222', 'Hola', 'Chao', 'jo@gmaill.com', 1234555, '123321', 1, 1, 1, 1),
(7, '4545455', 'asd', 'asd', 'asdasd@gmail.com', 123456487, 'asd', 1, 1, 1, 1),
(8, '4546545646', 'alberto', 'perez', 'alb@gmail.com', 45477878, 'alberto', 1, 2, 2, 1);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_admin` #####################################################
--

CREATE TABLE `historial_admin` (
  `id_historial_admin` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `tabla` varchar(20) NOT NULL,
  `accion` varchar(50) NOT NULL,
  `registro` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `time` time NOT NULL DEFAULT '00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `detalle_pedido_pedido_fk` (`id_pedido`),
  ADD KEY `detalle_pedido_producto_fk` (`id_producto`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodo`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `pedido_estado_fk` (`id_estado`),
  ADD KEY `pedido_metodo_de_pago_fk` (`id_metodo_pago`),
  ADD KEY `pedido_tipo_envio_fk` (`id_tipo_entrega`),
  ADD KEY `pedido_ubicacion_fk` (`id_ubicacion`),
  ADD KEY `pedido_usuario_fk` (`id_usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `producto_categoria_fk` (`id_categoria`),
  ADD KEY `producto_punto_de_venta_fk` (`id_punto_venta`);

--
-- Indices de la tabla `punto_venta`
--
ALTER TABLE `punto_venta`
  ADD PRIMARY KEY (`id_punto_venta`),
  ADD KEY `punto_de_venta_sede_fk` (`id_sede`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`id_sede`);

--
-- Indices de la tabla `tipo_entrega`
--
ALTER TABLE `tipo_entrega`
  ADD PRIMARY KEY (`id_tipo_entrega`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`id_ubicacion`),
  ADD KEY `ubicacion_sede_fk` (`id_sede`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `usuario_punto_de_venta_fk` (`id_punto_venta`),
  ADD KEY `usuario_tipo_usuario_fk` (`id_tipo_usuario`),
  ADD KEY `usuario_sede_fk` (`id_sede`) USING BTREE;

--
-- Indices de la tabla `historial_admin`
--
ALTER TABLE `historial_admin`
  ADD PRIMARY KEY (`id_historial_admin`),
  ADD KEY `historial_admin_usuario_fk` (`id_usuario`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  MODIFY `id_metodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `punto_venta`
--
ALTER TABLE `punto_venta`
  MODIFY `id_punto_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sede`
--
ALTER TABLE `sede`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo_entrega`
--
ALTER TABLE `tipo_entrega`
  MODIFY `id_tipo_entrega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  MODIFY `id_ubicacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `historial_admin`
--
ALTER TABLE `historial_admin`
  MODIFY `id_historial_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_pedido_fk` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `detalle_pedido_producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_estado_fk` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`),
  ADD CONSTRAINT `pedido_metodo_de_pago_fk` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id_metodo`),
  ADD CONSTRAINT `pedido_tipo_envio_fk` FOREIGN KEY (`id_tipo_entrega`) REFERENCES `tipo_entrega` (`id_tipo_entrega`),
  ADD CONSTRAINT `pedido_ubicacion_fk` FOREIGN KEY (`id_ubicacion`) REFERENCES `ubicacion` (`id_ubicacion`),
  ADD CONSTRAINT `pedido_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_categoria_fk` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `producto_punto_de_venta_fk` FOREIGN KEY (`id_punto_venta`) REFERENCES `punto_venta` (`id_punto_venta`);

--
-- Filtros para la tabla `punto_venta`
--
ALTER TABLE `punto_venta`
  ADD CONSTRAINT `punto_de_venta_sede_fk` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id_sede`);

--
-- Filtros para la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD CONSTRAINT `ubicacion_sede_fk` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id_sede`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_punto_de_venta_fk` FOREIGN KEY (`id_punto_venta`) REFERENCES `punto_venta` (`id_punto_venta`),
  ADD CONSTRAINT `usuario_sede_fk` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id_sede`),
  ADD CONSTRAINT `usuario_tipo_usuario_fk` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`);

--
-- Filtros para la tabla `historial_admin`
--
ALTER TABLE `historial_admin`
  ADD CONSTRAINT `historial_admin_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
